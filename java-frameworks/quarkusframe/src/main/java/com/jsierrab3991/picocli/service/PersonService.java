package com.jsierrab3991.picocli.service;

import com.jsierrab3991.picocli.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> savePerson(Person person);
}
