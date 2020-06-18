package com.example.registro.controller;
import java.sql.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.example.registro.entities.*;
import com.example.registro.repository.BasicoRepository;
import com.example.registro.repository.CormobilidadRepository;
import com.example.registro.repository.RegistroRepository;
import com.example.registro.repository.UsuarioRepository;


import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping({ "/menu" })
public class IndexController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BasicoRepository basicoRepository;

    @Autowired
    CormobilidadRepository cormobilidadRepository;

    @Autowired
    RegistroRepository registroRepository;


    
    
    @GetMapping({"/"})
    public String index(){
        return "index";
    }

    @GetMapping({"/infoBasic"})
    public String infoBasic(Model modelo, HttpServletRequest request) {

        final Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        final String username = loggedInUser.getName();

        final Optional<Usuario> uOptional = usuarioRepository.findById(Integer.parseInt(username));

        final Usuario persona = uOptional.get();

        modelo.addAttribute("user", persona);

        return "datos";
    }


    @PostMapping({"/infoBasic"})
    public String actualizaBasic(HttpServletRequest request){

        final Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        final String username = loggedInUser.getName();

        final Optional<Usuario> p = usuarioRepository.findById(Integer.parseInt(username));

        byte embarazada=1;

        if(request.getParameter("embarazada").equals("SI")){
            embarazada=0;
        }

        Basico b = new Basico();

        b.setContactotelefono(request.getParameter("telefono"));
        //b.setCormobilidad(Byte.valueOf(request.getParameter("embarazada")));
        
        b.setEmbarazo(Byte.valueOf(request.getParameter("embarazada")));
        //b.setEp(Integer.valueOf(request.getParameter("eps")));
        b.setFechanacimiento(Date.valueOf(request.getParameter("fecha")));
        //b.setFechareg(Date.valueOf(request.getParameter("fecha")));

        b.setGenero(request.getParameter("genero"));

       // b.setMas60(null);


    
        //basicoRepository.save(b);

        return "redirect:/menu";
    }

    @GetMapping({"/infoPer"})
    public String infoPer(){
        return "infoPer";
    }

    @GetMapping({"/cormo"})
    public String CormoP(){
        return "cormo";
    }


    @PostMapping({"/cormo"})
    public String cormo(HttpServletRequest request){


        Optional<Usuario> p = usuarioRepository.findById(registro());

        String diab = request.getParameter("diabetis");
        byte aux=0;
        if(diab==null){
            aux = 1;
        }

        String diabetis = request.getParameter("cardio");
        byte aux2=0;
        if(diabetis==null){
            aux2 = 1;
        }

        String accidente = request.getParameter("accidente");
        byte aux3=0;
        if(accidente==null){
            aux3 = 1;
        }

        String vih = request.getParameter("vih");
        byte aux4=0;
        if(vih==null){
            aux4 = 1;
        }

        String cancer = request.getParameter("cancer");
        byte aux5=0;
        if(cancer==null){
            aux5 = 1;
        }

        String corticoides = request.getParameter("corticoides");
        byte aux6=0;
        if(corticoides==null){
            aux6 = 1;
        }

        String croni = request.getParameter("croni");
        byte aux7=0;
        if(croni==null){
            aux7 = 1;
        }
       

        String nutricion = request.getParameter("nutricion");
        byte aux8=0;
        if(nutricion==null){
            aux8 = 1;
        }

        String fumadores = request.getParameter("fumadores");
        byte aux9=0;
        if(fumadores==null){
            aux9 = 1;
        }

        Cormobilidad c = new Cormobilidad();

       
        c.setId(p.get().getId());
        c.setCardio(aux2);
        c.setCancer(aux5);
        c.setCorticoides(aux6);
        c.setDiabetes(aux);
        c.setCerebro(aux3);
        c.setEpoc(aux7);
        c.setFumador(aux9);
        c.setNutricion(aux8);
        c.setVih(aux4);
       

        cormobilidadRepository.save(c);
       

        return "redirect:/menu";
    }


    @PostMapping({"/registro"})
    public String registroR(HttpServletRequest request){


        String tos = request.getParameter("tos");
        byte aux=0;
        if(tos==null){
            aux = 1;
        }

        String malestar = request.getParameter("malestar");
        byte aux2=0;
        if(malestar==null){
            aux2 = 1;
        }

        String fatiga = request.getParameter("fatiga");
        byte aux3=0;
        if(fatiga==null){
            aux3 = 1;
        }

        String secrecion = request.getParameter("secrecion");
        byte aux4=0;
        if(secrecion==null){
            aux4 = 1;
        }

        String dolor = request.getParameter("dolor");
        byte aux5=0;
        if(dolor==null){
            aux5 = 1;
        }

        String dificultad = request.getParameter("dificultad");
        byte aux6=0;
        if(dificultad==null){
            aux6 = 1;
        }

        String fecha = request.getParameter("fecha");
       
        
        String temperatura = request.getParameter("difitemperaturacultad");


        final Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        final String username = loggedInUser.getName();

        final Optional<Usuario> p = usuarioRepository.findById(Integer.parseInt(username));

        Registro s = new Registro();

        //s.setCovid(0);
        s.setDificultad(aux5);
        s.setFatiga(aux3);
        //s.setFecha(Date.ValueOf(fecha));
        //s.setFechareg(aux7);
        s.setGarganta(aux6);
        s.setId(p.get().getId());
        s.setMalestar(aux2);
        s.setNasal(aux4);
        //s.setTemperatura('');
        s.setTos(aux);


        //registroRepository.save(s);
       

        return "redirect:/menu";
    }


    
    @GetMapping({"/registro"})
    public String CormoR(){
        return "registro";
    }

    @PostMapping({"/familiar"})
    public String familiarR(HttpServletRequest request){

     Basico f = new Basico();

  

        Optional<Usuario> p = usuarioRepository.findById(registro());

        byte mayores_60=0;
        byte menores_15=0;
        byte sector=0;

        if (request.getParameter("mayores_60")==null) {
            mayores_60=1;
        }
        if (request.getParameter("menores_15")==null) {
            menores_15=1;
        }
        if (request.getParameter("sector")==null) {
            sector=1;
        }




        /*f.setTelefonoFamiliar(request.getParameter("telefono_familiar"));
        f.setNombreFamiliar(request.getParameter("nombre_familiar"));
        f.setMayores60(mayores_60);
        f.setMenores15(menores_15);
        //f.setSectorSalud(sector);

        f.setPersona(p.get());*/

        //familiarRepository.save(f);

        return "menu";


    }

    
    @GetMapping({"/familiar"})
    public String famiR(){
        return "familiar";
    }



    
    public Integer registro(){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username =loggedInUser.getName();
        Optional<Usuario> u = usuarioRepository.findById(Integer.valueOf(username));


        return u.get().getId();
           
}


  

}