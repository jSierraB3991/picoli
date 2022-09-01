package com.mycompany.app.repository.database.impl;

import com.mycompany.app.model.LazyData;
import com.mycompany.app.repository.database.LazyDataRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Log4j2
public class LazyDataRepositoryImpl extends HibernateRepositoryImpl<LazyData> implements LazyDataRepository {
    @Override
    public boolean isFileMigrate(String fileName) {
        var factory = this.buildSessionFactory(LazyData.class);
        try(factory) {
            Session session = factory.openSession();
            String hql = "FROM LazyData AS ld WHERE ld.name = :file_name";
            Query<LazyData> query = (Query<LazyData>) session.createQuery(hql);
            query.setParameter("file_name",fileName);
            List<LazyData> results = query.list();
            return !results.isEmpty();

        }catch (Exception ex) {
            log.info("Exception: {}", ex.toString());
            ex.printStackTrace();
            return false;
        }
    }
}
