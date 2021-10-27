package io.HappySwimwear.Servicio;

import io.HappySwimwear.Modelo.User;
import io.HappySwimwear.Repositorio.UserRepository;
import io.HappySwimwear.Seguridad.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository tablaUsuario;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        User usuario = tablaUsuario.findByCorreo(correo);
        //return new org.springframew
         //org.springframework.security.core.userdetails.User(usuario.getCorreo(), usuario.getContrasena(), new ArrayList<>());

        return new MyUserDetails(usuario);

    }
}



