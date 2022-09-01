package com.mycompany.app;

import com.google.inject.Guice;
import com.mycompany.app.commands.LoadCommand;
import com.mycompany.app.config.ApplicationConfig;
import com.mycompany.app.service.ClientService;
import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        var injector = Guice.createInjector(new ApplicationConfig());
        var clientService = injector.getInstance(ClientService.class);
        showBanner();
        new CommandLine(new LoadCommand(clientService))
                .execute(args);
    }

    public static void showBanner()  {
        // TODO REPLACE FOR FIGLET
        System.out.println("__________.__  .__        __       _____              .___");
        System.out.println("\\_    ___/|  | |__| _____/  |_    /  _  \\   ____    __| _/___________  __________   ____  ");
        System.out.println("|    __)_ |  | |  |/  _ \\   __\\  /  /_\\  \\ /    \\  / __ |/ __ \\_  __ \\/  ___/  _ \\ /    \\ ");
        System.out.println("|        \\|  |_|  (  <_> )  |   /    |    \\   |  \\/ /_/ \\  ___/|  | \\/\\___ (  <_> )   |  \\");
        System.out.println("/______  /|____/__|\\____/|__|   \\____|__  /___|  /\\____ |\\___  >__|  /____  >____/|___|  /");
        System.out.println("       \\/                               \\/     \\/      \\/    \\/           \\/           \\/");
        System.out.println();
    }
}
