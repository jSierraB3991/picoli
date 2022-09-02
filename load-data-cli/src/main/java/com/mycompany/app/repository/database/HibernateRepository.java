package com.mycompany.app.repository.database;

import java.util.List;
import java.util.Optional;

public interface HibernateRepository<Model, Id> {
    void save(Model model);

    List<Model> findAll(Class clas);

    Optional<Model> findBy(Id idModel, Class clas);
}
