package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.models.OrdenCompra;
import com.tienda.tienda_de_ropa.models.Producto;

import java.time.LocalDateTime;

public class OrdenCompraDTO {
    private Long id;
    private int cantidad;
    private double precio;
    private LocalDateTime fechaCreacion;
    private String nombreProducto;
   /* private Carrito carrito;
    private Producto producto;*/

    public OrdenCompraDTO() {
    }

    public OrdenCompraDTO(OrdenCompra ordenCompra) {
        this.id = ordenCompra.getId();
        this.cantidad = ordenCompra.getCantidad();
        this.precio = ordenCompra.getPrecio();
        this.fechaCreacion = ordenCompra.getFechaCreacion();
        this.nombreProducto = ordenCompra.getProducto().getNombre();
        /*this.carrito = ordenCompra.getCarrito();
        this.producto = ordenCompra.getProducto();*/
    }

    public Long getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }


    /*  public Carrito getCarrito() {
        return carrito;
    }

    public Producto getProducto() {
        return producto;
    }*/
}
