package com.jsierrab3991.picocli.service.impl;

import com.jsierrab3991.picocli.model.Person;
import com.jsierrab3991.picocli.service.PersonService;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class PersonServiceImpl implements PersonService {
    @Override
    @Transactional
    public List<Person> savePerson(Person person) {
        person.persist();
        return Person.listAll();
    }
}
