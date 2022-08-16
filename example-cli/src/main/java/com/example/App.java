package com.example;

import com.example.commands.HelloCommand;
import com.example.commands.TodoCommand;
import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        int exitsStatus = new CommandLine(new TodoCommand())
                .execute(args);
        System.exit(exitsStatus);
    }
}
