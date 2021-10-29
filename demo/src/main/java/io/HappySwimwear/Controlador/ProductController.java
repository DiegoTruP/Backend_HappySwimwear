package io.HappySwimwear.Controlador;

import io.HappySwimwear.Modelo.Product;
import io.HappySwimwear.Repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Controller
@RequestMapping(path="/productos")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //POST  http://localhost:8080/productos/add
    @PostMapping(path="/add") // AGREGA NUEVO PRODUCTO
    public @ResponseBody
    Product addNewProduct (@RequestBody Product product) {
        // @ResponseBody means the returned String is the response, not a view name

        return productRepository.save(product);
    }

    //GET  http://localhost:8080/productos/all
    @GetMapping(path="/all") //MUESTRA TODOS LOS PRODUCTOS
    public @ResponseBody Iterable<Product> getAllUsers() {
        // This returns a JSON or XML with the users
        return productRepository.findAll();
    }

    //PUT  http://localhost:8080/productos/update/1
    @PutMapping(path = "/update/{id}") //Actualizar registro
    public @ResponseBody String updateProduct(@PathVariable int id, @RequestBody Product product){
        Product nuevo = new Product();
        nuevo = productRepository.findById(id);
        //nuevo.setId_producto(product.getId_producto());
        nuevo.setNombre_producto(product.getNombre_producto());
        nuevo.setDescripcion(product.getDescripcion());
        nuevo.setPrecio(product.getPrecio());
        nuevo.setId_categoria(product.getId_categoria());
         nuevo.setImagen(product.getImagen());
        productRepository.save(nuevo);
        return "Producto "+productRepository.findById(id)+" Se ha actualizado al usuario";
    }

    //GET  http://localhost:8080/productos/1
    @GetMapping( path="/{id}" ) //MUESTRA SOLO UN PRODUCTO
    public @ResponseBody Product getProduct(@PathVariable int id )
    {
        return productRepository.findById( id );
    }

    //DELETE  http://localhost:8080/productos/1
    @DeleteMapping( path="/{id}" ) //ELIMINA UN PRODUCTO
    public @ResponseBody String deleteProduct(@PathVariable Integer id )
    {
        productRepository.deleteById( id );
        return "producto con id: "+id+" Se ha borrado exitosamente";
    }
}
