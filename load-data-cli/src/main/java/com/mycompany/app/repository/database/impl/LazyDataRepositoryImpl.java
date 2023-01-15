package com.mycompany.app.repository.database.impl;

import com.mycompany.app.model.LazyData;
import com.mycompany.app.repository.database.LazyDataRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Objects;

@Log4j2
public class LazyDataRepositoryImpl extends HibernateRepositoryImpl<LazyData, Long> implements LazyDataRepository {
    @Override
    public boolean isFileMigrate(String fileName) {
        var factory = this.buildSessionFactory(LazyData.class);
        try(factory) {
            Session session = factory.openSession();
            var object = session.createCriteria(LazyData.class)
                    .add(Restrictions.eq("name",fileName))
                    .uniqueResult();
            return Objects.nonNull(object);

        }catch (Exception ex) {
            log.info("Exception: {}", ex.toString());
            ex.printStackTrace();
            return false;
        }
    }
}
