package com.spotme.project_spotme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotme.project_spotme.model.entities.Usuario;
import com.spotme.project_spotme.model.entities.Publicacao;
import com.spotme.project_spotme.repository.PublicacaoRepository;
import com.spotme.project_spotme.repository.UsuarioRepository;
import com.spotme.project_spotme.services.FindEmailService;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroUserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PublicacaoRepository publicacao;

    @Autowired
    private FindEmailService findEmailService;

    @PostMapping("/usuario")
    public String cadastraUsuario(@RequestBody Usuario data_user) {

        Usuario value = findEmailService.buscarUsuarioPorEmail(data_user.getEmail());

        if (value != null) {
            return "Usuário já existe!";
        } else {
            usuarioRepository.save(data_user);
            return "OK!";
        }
    }

    @PostMapping("/publicacao")
    public void cadastraPublicacao(@RequestBody Publicacao pub) {
        publicacao.save(pub);
    }
}
