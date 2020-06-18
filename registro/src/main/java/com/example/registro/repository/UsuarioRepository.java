package com.example.registro.repository;


import java.util.Optional;

import com.example.registro.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional <Usuario> findByUsuario(String usuario);
}