package com.jsierrab3991.picocli.springboot.repository;

import com.jsierrab3991.picocli.springboot.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}