package io.HappySwimwear.Repositorio;

import io.HappySwimwear.Modelo.Venta;
import org.springframework.data.repository.CrudRepository;

public interface VentaRepository extends CrudRepository<Venta, Integer> {
    Venta findById(int id);
}
