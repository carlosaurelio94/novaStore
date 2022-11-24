package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private long id;

    @ElementCollection
    @Column(name="URLImages")
    private List<String> images = new ArrayList<>();
    private String nombre;

    private int stock;

    private double precio;

    private ProductoTalle talle;


    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    Set<OrdenCompra> ordenCompras = new HashSet<>();

    public Producto() {
    }

    public Producto(List<String> images, String nombre, int stock, double precio, ProductoTalle talle) {
        this.images = images;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.talle = talle;
    }

    public long getId() {
        return id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ProductoTalle getTalle() {
        return talle;
    }

    public void setTalle(ProductoTalle talle) {
        this.talle = talle;
    }

    public Set<OrdenCompra> getOrdenCompras() {
        return ordenCompras;
    }

    public void setOrdenCompras(Set<OrdenCompra> ordenCompras) {
        this.ordenCompras = ordenCompras;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", talle=" + talle +
                ", ordenCompras=" + ordenCompras +
                '}';
    }
}
