package io.HappySwimwear.Repositorio;

import io.HappySwimwear.Modelo.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

//base dateos
public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(int id);
    User findByCorreo(String correo);
}
