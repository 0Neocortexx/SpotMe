package com.spotme.project_spotme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotme.project_spotme.model.entities.Publicacao;

public interface PublicacoesRepository extends JpaRepository<Publicacao, Long>{
    
}
