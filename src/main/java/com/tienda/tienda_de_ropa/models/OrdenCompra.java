package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private int cantidad;
    private double precio;
    private LocalDateTime fechaCreacion;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="carrito_id")
    private Carrito carrito;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="producto_id")
    private Producto producto;

    public OrdenCompra() {
    }

    public OrdenCompra(int cantidad, double precio, LocalDateTime fechaCreacion, Carrito carrito, Producto producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.carrito = carrito;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", fechaCreacion=" + fechaCreacion +
                ", carrito=" + carrito +
                ", producto=" + producto +
                '}';
    }
}
