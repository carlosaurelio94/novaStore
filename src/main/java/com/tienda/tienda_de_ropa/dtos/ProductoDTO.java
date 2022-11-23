package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Producto;

public class ProductoDTO {

    private long id;

    private String nombre;

    private int stock;

    private Double precio;

    private String talle;

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

    public String getTalle() {
        return talle;
    }
}
