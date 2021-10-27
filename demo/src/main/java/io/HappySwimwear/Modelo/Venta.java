package io.HappySwimwear.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_venta;
    private String fecha; //date time
    private Integer id_usuario;
    private int id_producto;
    private Integer cantidad;

    //Constructores
    public Venta(Integer id_venta, String fecha, Integer id_usuario, int id_producto, Integer cantidad) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public Venta(){}

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
