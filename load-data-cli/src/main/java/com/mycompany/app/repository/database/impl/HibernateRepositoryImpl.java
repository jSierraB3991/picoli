package com.mycompany.app.repository.database.impl;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateRepositoryImpl<T> {

    public void save(T model) {
        var factory = new Configuration()
                .configure()
                .addAnnotatedClass(model.getClass())
                .buildSessionFactory();
        try (factory) {
            Session session = factory.openSession();
            session.beginTransaction();
            session.persist(model);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Hibernate Exception" + ex.getMessage());
            throw  ex;
        }
    }
}