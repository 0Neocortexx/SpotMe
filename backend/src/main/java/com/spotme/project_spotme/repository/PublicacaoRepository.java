package com.spotme.project_spotme.repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spotme.project_spotme.model.entities.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long>{
}
