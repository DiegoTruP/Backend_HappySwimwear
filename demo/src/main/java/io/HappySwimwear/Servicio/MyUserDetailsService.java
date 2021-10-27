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



























//package io.HappySwimwear.Servicio;
//
//import io.HappySwimwear.Modelo.User;
//import io.HappySwimwear.Repositorio.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//
//@Service @RequiredArgsConstructor @Slf4j
//public class UserServiceImpl implements UserService{
//    private final UserRepository tablaUsuario;
//
//
//    @Override
//    public User registrarUsuario(User usuario) {
//        log.info("Registrando al usuario {} {} a la base de datos", usuario.getId_usuario(), usuario.getNombre());
//        return tablaUsuario.save(usuario);
//    }
//
//    @Override
//    public User buscarUsuario(int id) {
//        log.info("Buscando al usuario con el id: {}", id);
//        return tablaUsuario.findById(id);
//    }
//
//    @Override
//    public User buscarUsuarioPorCorreo(String correo) {
//        log.info("Buscando al usuario con el correo: {}", correo);
//        return tablaUsuario.findByCorreo(correo);
//    }
//
//    @Override
//    public Iterable<User> mostrarTodos() {
//        log.info("Buscando a todos los usuarios");
//        return tablaUsuario.findAll();
//    }
//}
