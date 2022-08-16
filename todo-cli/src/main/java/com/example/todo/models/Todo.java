package com.example.todo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Todo implements Serializable {

    private static final long serialVersionUID = 4663044935291053899L;

    private Long id;
    private String message;
    private Status status;
    private LocalDate createOn;
    private LocalDate updateOn;
}
