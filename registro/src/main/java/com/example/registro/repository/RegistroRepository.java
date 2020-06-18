package com.example.registro.repository;


import com.example.registro.entities.Cormobilidad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Cormobilidad, Integer> {
    
}
