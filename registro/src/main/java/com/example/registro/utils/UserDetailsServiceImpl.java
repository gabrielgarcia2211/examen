package com.example.registro.utils;


import com.example.registro.entities.Usuario;
import com.example.registro.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

 

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        // Buscar el usuario con el repositorio y si no existe lanzar una exepcion
        //usuarioRepository.findAll(Integer.valueOf(id));
        Usuario appUser = usuarioRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

        // Mapear nuestra lista de Authority con la de spring security

        List<GrantedAuthority> grantList = new ArrayList<>();

        String aux = "";

        if(appUser.getRolBean().getDescripcion().equalsIgnoreCase("Administrador") || appUser.getRolBean().getDescripcion().equalsIgnoreCase("Usuario")){
            aux="UFPS";
        }else{
            aux="COLPOR";
        }


        GrantedAuthority authority = new SimpleGrantedAuthority(aux);
        grantList.add(authority);

        // List<GrantedAuthority> roles = new ArrayList<>();
        // GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getEmpresaUsuario().getPerfil());
        // roles.add(authority);

        // Set <GrantedAuthority> grantList = new HashSet<>();
        // GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        // grantList.add(grantedAuthority);

        // Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        UserDetails usuario = (UserDetails) new User(String.valueOf(appUser.getId()) , appUser.getClave(), grantList);
        System.out.println(usuario);
        return usuario;
    }
}
