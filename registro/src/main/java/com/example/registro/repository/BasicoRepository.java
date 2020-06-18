package com.example.registro.repository;

import com.example.registro.entities.Basico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicoRepository extends JpaRepository<Basico, Integer> {
    
}