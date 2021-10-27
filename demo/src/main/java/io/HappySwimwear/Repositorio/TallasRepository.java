package com.PRUEBA.demo;

import org.springframework.data.repository.CrudRepository;

public interface TallasRepository extends CrudRepository<Tallas, Integer> {
    Tallas findById(int id);
}
