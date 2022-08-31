package com.mycompany.app.repository.database;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateRepository<T> {

    public void saveModel(T model) {
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
            throw  ex;
        }
    }
}
