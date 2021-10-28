package io.HappySwimwear.Controlador;


import io.HappySwimwear.Modelo.Venta;
import io.HappySwimwear.Repositorio.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin("*")
@Controller
@RequestMapping(path="/venta")
public class VentaController {

    @Autowired
    private VentaRepository tablaVenta;

    //POST  http://localhost:8080/venta/agregar
    @PostMapping(path="/agregar") // AGREGA NUEVa VENTA
    public @ResponseBody Venta addNewProduct (@RequestBody Venta venta) {
        // formato en JSON para agregar venta.  no es necesario agregar id ni fecha, se agregan automaticamente
        // {
        //    "id_usuario": 3,
        //    "id_producto": 2,
        //    "cantidad": 1
        // }

        LocalDateTime fechayHoraActual = LocalDateTime.now();
        String fyHFormateada = fechayHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        venta.setFecha(fyHFormateada);

        return tablaVenta.save(venta);
    }

    //GET  http://localhost:8080/venta/todas
    @GetMapping(path="/todas") //MUESTRA TODOS LAS VENTAS
    public @ResponseBody Iterable<Venta> getAllUsers() {
        // This returns a JSON or XML with the users
        return tablaVenta.findAll();
    }

    //PUT  http://localhost:8080/venta/modificar/2
    @PutMapping(path = "/modificar/{id}") //Actualizar registro
    public @ResponseBody String modificarVenta(@PathVariable int id, @RequestBody Venta venta){
        Venta nueva = new Venta();
        nueva = tablaVenta.findById(id);
        //nueva.setId_producto(product.getId_producto());
        nueva.setFecha(venta.getFecha());
        nueva.setId_usuario(venta.getId_usuario());
        nueva.setId_producto(venta.getId_producto());
        nueva.setCantidad(venta.getCantidad());
        tablaVenta.save(nueva);
        return "Venta con id: "+id+" Se ha actualizado";
    }

    //GET  http://localhost:8080/venta/1
    @GetMapping( path="/{id}" ) //MUESTRA SOLO UN PRODUCTO
    public @ResponseBody Venta getProduct(@PathVariable int id )
    {
        return tablaVenta.findById( id );
    }

    //DELETE  http://localhost:8080/venta/1
    @DeleteMapping( path="/{id}" ) //ELIMINA UN PRODUCTO
    public @ResponseBody String deleteProduct(@PathVariable Integer id )
    {
        tablaVenta.deleteById( id );
        return "venta con id: "+id+" Se ha borrado";
    }
}
