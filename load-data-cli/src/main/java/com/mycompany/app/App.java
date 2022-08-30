package com.mycompany.app;

import com.mycompany.app.commands.LoadCommand;
import com.mycompany.app.config.ApplicationConfig;
import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        new CommandLine(new LoadCommand(ApplicationConfig.clientService()))
                .execute(args);
    }
}
