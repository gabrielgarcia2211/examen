package com.example.registro.repository;

import com.example.registro.entities.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    
}