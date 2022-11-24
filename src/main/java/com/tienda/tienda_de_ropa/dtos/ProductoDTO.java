package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Producto;
import com.tienda.tienda_de_ropa.models.ProductoTalle;

public class ProductoDTO {

    private long id;

    private String nombre;

    private int stock;

    private Double precio;

    private ProductoTalle talle;

    public ProductoDTO() {}

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.stock = producto.getStock();
        this.precio = producto.getPrecio();
        this.talle = producto.getTalle();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public ProductoTalle getTalle() {
        return talle;
    }
}
