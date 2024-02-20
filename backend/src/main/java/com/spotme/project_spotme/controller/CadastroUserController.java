package com.spotme.project_spotme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spotme.project_spotme.model.entities.Usuario;
import com.spotme.project_spotme.repository.UsuarioRepository;
import com.spotme.project_spotme.services.FindEmailService;

@RestController
@RequestMapping(value = "/cadastro")
@CrossOrigin(origins = "http://localhost:8080/")
public class CadastroUserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FindEmailService findEmailService;

    @PostMapping("/usuario")
    public String cadastraUsuario(@RequestBody Usuario data_user) {
        
        Usuario value = findEmailService.buscarUsuarioPorEmail(data_user.getEmail());

        if (value != null) {
            return "Email já cadastrado no sistema!";
        } else {
            usuarioRepository.save(data_user);
            return "OK!";
        }
    }
}
