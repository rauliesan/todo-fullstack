package com.daw.datamodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.datamodel.entity.Libro;

@Repository
public interface RepositorioLibros extends JpaRepository<Libro, Long> {

}
