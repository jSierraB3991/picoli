package com.mycompany.app.repository.database.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRepositoryImpl<T> {

    protected SessionFactory buildSessionFactory(Class<?> clas) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(clas)
                .buildSessionFactory();
    }

    public void save(T model) {
        var factory= buildSessionFactory(model.getClass());
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
