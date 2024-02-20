package com.spotme.project_spotme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spotme.project_spotme.model.entities.Usuario;
import com.spotme.project_spotme.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class GetUserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    @ResponseBody
    public List<Usuario> getUser() {
        List<Usuario> users = usuarioRepository.findAll();
        return users;
    }
}
