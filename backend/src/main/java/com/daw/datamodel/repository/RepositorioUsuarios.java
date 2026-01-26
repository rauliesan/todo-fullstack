package com.daw.datamodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.datamodel.entity.Usuario;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {

}
