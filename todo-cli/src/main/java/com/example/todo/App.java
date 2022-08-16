package com.example.todo;

import com.example.todo.migration.DatabaseMigration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DatabaseMigration.Migration1();
    }
}
