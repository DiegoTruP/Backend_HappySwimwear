package com.PRUEBA.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tallas")
public class Tallas {
    @Id
    private Integer id_producto;
    private Integer talla_ch;
    private Integer talla_m;
    private Integer talla_g;

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getTalla_ch() {
        return talla_ch;
    }

    public void setTalla_ch(Integer talla_ch) {
        this.talla_ch = talla_ch;
    }

    public Integer getTalla_m() {
        return talla_m;
    }

    public void setTalla_m(Integer talla_m) {
        this.talla_m = talla_m;
    }

    public Integer getTalla_g() {
        return talla_g;
    }

    public void setTalla_g(Integer talla_g) {
        this.talla_g = talla_g;
    }

    public Tallas() {
    }


}
