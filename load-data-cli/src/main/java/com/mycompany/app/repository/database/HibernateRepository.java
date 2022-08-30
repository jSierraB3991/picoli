package com.mycompany.app.repository.database;

import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

@Log
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
            System.out.println(model.getClass().getName() + " {" + model + "} success in the database");
            session.close();
        } catch (Exception ex) {
            log.info("exception: " + ex.getMessage());
            throw  ex;
        }
    }
}
