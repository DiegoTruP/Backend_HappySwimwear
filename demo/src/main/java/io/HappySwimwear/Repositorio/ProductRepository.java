package io.HappySwimwear.Repositorio;

import io.HappySwimwear.Modelo.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findById(int id);
}
