package com.spotme.project_spotme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotme.project_spotme.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Long>{
}
