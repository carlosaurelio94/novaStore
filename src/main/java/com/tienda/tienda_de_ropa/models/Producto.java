package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private long id;

    private String nombre;

    private int stock;

    private Double precio;

    private String talle;

    @OneToMany(mappedBy="producto", fetch=FetchType.EAGER)
    private Set<ClienteProducto> clienteProducto = new HashSet<>();

    public Producto() {
    }

    public Producto(long id, String nombre, int stock, Double precio, String talle) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.talle = talle;
    }

    public long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", stock='" + stock + '\'' +
                ", precio='" + precio + '\'' +
                ", talle='" + talle + '\'' +
                '}';
    }
}
