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
     public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

		
     //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
     Usuario appUser = usuarioRepository.findByUsuario(user).get();
            //.orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
    //Mapear nuestra lista de Authority con la de spring security 
    
    List<GrantedAuthority> roles = new ArrayList<>();
    GrantedAuthority authority = new SimpleGrantedAuthority("Usuario");
    roles.add(authority);

    // Set <GrantedAuthority> grantList = new HashSet<>();
    // GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
    // grantList.add(grantedAuthority);

		
    //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
    UserDetails usuario = (UserDetails) new User(appUser.getUsuario(), appUser.getClave(), roles);
    System.out.println(usuario);
         return usuario;
    }
    
}
