package com.jsierrab3991.picocli.springboot.repository;

import com.jsierrab3991.picocli.springboot.model.LazyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LazyDataRepository extends JpaRepository<LazyData, Long> {
}