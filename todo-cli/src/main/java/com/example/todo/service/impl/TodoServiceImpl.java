package com.example.todo.service.impl;

import com.example.todo.models.Status;
import com.example.todo.models.Todo;
import com.example.todo.service.TodoService;
import lombok.extern.java.Log;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Log
public class TodoServiceImpl implements TodoService {

    public static final String TODO_MAPDB = "todo.mapdb";
    public static final String TODO = "todo";
    private DB db = null;
    ConcurrentMap<Long, Todo> map = null;
    Comparator<Todo> todoComparator = (o1, o2) -> o1.getCreateOn().compareTo(o2.getCreateOn());

    private void start() {
        this.db = DBMaker.fileDB(TODO_MAPDB).make();
        this.map = db.hashMap(TODO, Serializer.LONG, Serializer.JAVA).createOrOpen();
    }

    private void shutdown() {
        this.db.close();
    }

    private Long getNewTaskId() {
        return db.atomicLong("id").createOrOpen().addAndGet(1);
    }

    @Override
    public Todo createTodo(String message) {
        return createTodo(message, LocalDate.now());
    }

    @Override
    public Todo createTodo(String message, LocalDate date) {
        this.start();
        var todo = Todo.builder()
                .message(message)
                .id(getNewTaskId())
                .status(Status.CREATE)
                .createOn(date)
                .updateOn(date)
                .build();
        map.put(todo.getId(), todo);
        this.shutdown();
        return todo;
    }

    @Override
    public Todo updateMessage(Long taskId, String message) {
        var optionalTodo = this.finById(taskId);

        if (optionalTodo.isPresent()) {
            var task = optionalTodo.get();
            task.setMessage(message);
            task.setUpdateOn(LocalDate.now());
            this.start();
            map.put(taskId, task);
            this.shutdown();
            return task;
        }

        return null;
    }

    @Override
    public Todo updateStatus(Long taskId, Status status) {
        var optionalTodo = this.finById(taskId);

        if (optionalTodo.isPresent()) {
            var task = optionalTodo.get();
            task.setStatus(status);
            task.setUpdateOn(LocalDate.now());
            this.start();
            map.put(taskId, task);
            this.shutdown();
            return task;
        }

        return null;
    }

    @Override
    public boolean markTaskCompletedById(Long taskId) {
        return Objects.nonNull(updateStatus(taskId, Status.COMPLETED));
    }

    @Override
    public boolean deleteById(Long taskId) {

        if (Objects.nonNull(taskId)) {
            this.start();
            map.remove(taskId);
            this.shutdown();
        }

        return true;
    }

    @Override
    public List<Todo> findAll() {
        this.start();
        var collect = map.values().stream()
                .sorted(todoComparator)
                .collect(Collectors.toList());
        this.shutdown();
        return collect;
    }

    @Override
    public List<Todo> findAllByIds(List<Long> ids) {
        this.start();
        var collect = ids.stream()
                .map(map::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        this.shutdown();
        return collect;
    }

    @Override
    public List<Todo> findByStatus(Status status) {
        this.start();
        var collect = findAll().stream().filter(todo ->
                        status.equals(todo.getStatus()))
                .collect(Collectors.toList());
        this.shutdown();
        return collect;
    }

    @Override
    public Optional<Todo> finById(Long taskId) {
        this.start();
        var todo = map.get(taskId);
        this.shutdown();
        return Optional.of(todo);
    }
}
