package com.spotme.project_spotme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotme.project_spotme.model.entities.Usuario;
import com.spotme.project_spotme.repository.EmailRepository;

@Service
public class FindEmailService {
    
    @Autowired
    private EmailRepository email_repository;

    public Usuario buscarUsuarioPorEmail(String email) {
        return email_repository.findByEmail(email);
    }
}       
