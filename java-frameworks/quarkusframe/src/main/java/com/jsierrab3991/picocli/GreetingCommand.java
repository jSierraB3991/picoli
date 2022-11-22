package com.jsierrab3991.picocli;

import com.jsierrab3991.picocli.model.Person;
import com.jsierrab3991.picocli.model.Status;
import com.jsierrab3991.picocli.service.PersonService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Random;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class GreetingCommand implements Runnable {

    @Parameters(paramLabel = "<name>", defaultValue = "Luis Aguero",
        description = "Your name.")
    String name;

    @Inject
    private PersonService personService;

    @Override
    public void run() {
        System.out.printf("Hello %s, go go commando!\n", name);
        var person = Person.builder()
                .name(name)
                .birth(LocalDate.now())
                .status(Status.ACTIVE)
                .build();
        var list = personService.savePerson(person);
        list.forEach(System.out::println);
    }
}
