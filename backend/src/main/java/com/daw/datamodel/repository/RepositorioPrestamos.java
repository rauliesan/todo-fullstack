package com.daw.datamodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.datamodel.entity.Prestamo;

@Repository
public interface RepositorioPrestamos extends JpaRepository<Prestamo, Long> {

}
