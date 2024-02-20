package com.spotme.project_spotme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotme.project_spotme.model.entities.Usuario;

public interface EmailRepository extends JpaRepository<Usuario, Long>{
    
    Usuario findByEmail(String email);
}
