package com.Crud.demo.repository;

import com.Crud.demo.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients, Long> {

}
