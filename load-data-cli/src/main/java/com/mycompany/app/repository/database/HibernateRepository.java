package com.mycompany.app.repository.database;

public interface HibernateRepository<T> {
    void save(T model);
}
