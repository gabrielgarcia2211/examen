package com.example.registro.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {


    
     
    @GetMapping({"/" , "/index"})
    public String index() {
        return "login";        
    }

     
    @GetMapping({"/menu"})
    public String menu() {

        return "menu";        
    }


    // public String infoBasic(Model modelo) {

    //     final Optional<Ufps> uOptional = ufpsRepository.findById(username.getDocumento());

    //     final Ufps usuario = uOptional.get();

    //     return "infoBasic";
    // }
}