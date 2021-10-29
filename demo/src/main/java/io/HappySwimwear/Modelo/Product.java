package io.HappySwimwear.Modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_producto;
    private String nombre_producto;
    private double precio;
    private String descripcion;
    private Integer id_categoria;
     private String imagen;



    public Product() {
    }

    public Product(Integer id_producto, String nombre_producto, double precio, String descripcion, String imagen) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }


    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
