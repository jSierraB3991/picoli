package com.example.todo;

import com.example.todo.commands.TodoCommand;
import com.example.todo.migration.DatabaseMigration;

import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DatabaseMigration.Migration1();
        System.exit( new CommandLine(new TodoCommand())
                .execute(args));
    }
}
