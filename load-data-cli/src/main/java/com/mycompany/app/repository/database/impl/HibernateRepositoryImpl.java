package com.mycompany.app.repository.database.impl;

import com.mycompany.app.repository.database.HibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HibernateRepositoryImpl<Model, Id> implements HibernateRepository<Model, Id> {

    protected SessionFactory buildSessionFactory(Class<?> clas) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(clas)
                .buildSessionFactory();
    }

    @Override
    public void save(Model model) {
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

    @Override
    public List<Model> findAll(Class clas) {
        var factory = this.buildSessionFactory(clas);
        try(factory) {
            Session session = factory.openSession();
            return session.createCriteria(clas)
                    .list();
        }catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Model> findAllPageFinal(Class clas, int maxResult) {
        var factory = this.buildSessionFactory(clas);
        try(factory) {
            Session session = factory.openSession();
            return session.createCriteria(clas)
                            .setMaxResults(maxResult)
                    .list();
        }catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Model> findBy(Id idModel, Class clas) {
        var factory = this.buildSessionFactory(clas);
        try(factory) {
            Session session = factory.openSession();
            var object = session.createCriteria(clas)
                    .add(Restrictions.eq("id",idModel))
                    .uniqueResult();

            return Objects.isNull(object)
                    ? Optional.empty()
                    : Optional.of((Model) object);
        }catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
