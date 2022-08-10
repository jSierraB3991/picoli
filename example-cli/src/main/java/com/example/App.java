package com.example;

import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        new CommandLine(new HelloCommand())
                .execute(args);
    }
}
