package com.mycompany.app.repository.database;

import com.mycompany.app.model.LazyData;

public interface LazyDataRepository extends HibernateRepository<LazyData> {

    boolean isFileMigrate(String fileName);
}
