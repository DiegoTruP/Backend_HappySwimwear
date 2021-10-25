package com.PRUEBA.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody User addNewUser ( @RequestBody User user /*@RequestParam Integer id_usuario, @RequestParam String nombre
            , @RequestParam String correo, @RequestParam String direccion, @RequestParam String telefono,
                                            @RequestParam Integer compras, @RequestParam String contrasena*/) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        /*User newUser = new User();
        newUser.setNombre(user.getNombre());
        newUser.setCorreo(user.getCorreo());
        newUser.setDireccion(user.getDireccion());
        newUser.setTelefono(user.getTelefono());
        newUser.setCompras(user.getCompras());
        newUser.setContrasena(user.getContrasena());
        userRepository.save(newUser);*/
        return userRepository.save(user);
    }

    @GetMapping(path="/all") //MUESTRA TODOS LOS USUARIOS
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PutMapping(path = "update/{id}") //Actualizar registro
    public @ResponseBody String updateUser(@PathVariable int id, @RequestBody User user){
        User nuevo = new User();
        nuevo = userRepository.findById(id);
        nuevo.setId_usuario(user.getId_usuario());
        nuevo.setNombre(user.getNombre());
        nuevo.setCorreo(user.getCorreo());
        nuevo.setDireccion(user.getDireccion());
        nuevo.setTelefono(user.getTelefono());
        nuevo.setCompras(user.getCompras());
        nuevo.setContrasena(user.getContrasena());
        userRepository.save(nuevo);
        return "usuario "+userRepository.findById(id)+" Se ha actualizado al usuario";
    }


    @GetMapping( path="users/{id}" ) //MUESTRA SOLO UN USUARIO
    public @ResponseBody User getUser(@PathVariable int id )
    {
        return userRepository.findById( id );
    }

    @DeleteMapping( "users/{id}" ) //ELIMINA UN USUARIO
    public @ResponseBody String deleteUser(@PathVariable Integer id )
    {
        userRepository.deleteById( id );
        return "usuario "+userRepository.findById(id)+" Se ha borrado al usuario";
    }
}