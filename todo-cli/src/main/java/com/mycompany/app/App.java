package com.mycompany.app;

import com.mycompany.app.commands.TodoCommand;
import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.exit( new CommandLine(new TodoCommand())
                .execute(args));
    }
}
