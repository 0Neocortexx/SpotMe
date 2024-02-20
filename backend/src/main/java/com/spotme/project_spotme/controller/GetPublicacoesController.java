package com.spotme.project_spotme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotme.project_spotme.model.entities.Publicacao;
import com.spotme.project_spotme.repository.PublicacaoRepository;

@RestController
@RequestMapping("/feed")
public class GetPublicacoesController {
    
    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @GetMapping()
    public List<Publicacao> getPublications (){
        List<Publicacao> lista = publicacaoRepository.findAll();
        return lista;
    }
}
