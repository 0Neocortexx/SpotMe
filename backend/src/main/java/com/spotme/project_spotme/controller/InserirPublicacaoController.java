package com.spotme.project_spotme.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotme.project_spotme.model.entities.Publicacao;
import com.spotme.project_spotme.repository.PublicacaoRepository;

@RestController
@RequestMapping(value = "/publicacao")
public class InserirPublicacaoController {
    
    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @PostMapping("/publicar")
    public String inserirPublicacao(@RequestBody Publicacao publicacao) {

        LocalDateTime dataAtual = LocalDateTime.now();

        publicacao.setData(dataAtual);

        publicacaoRepository.save(publicacao);

        return "OK!";
    }
}
