package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private double precioTotal;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="carrito_id")
    private Carrito carrito;

    private double sumaPrecios(Carrito carrito){
        return 0;
    }

    public Factura() {
    }

    public Factura(Carrito carrito) {
        this.precioTotal = this.sumaPrecios(carrito);
        this.fechaCreacion = LocalDateTime.now();
        this.carrito = carrito;
    }


    public Long getId() {
        return id;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
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

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", precioTotal=" + precioTotal +
                ", fechaCreacion=" + fechaCreacion +
                ", carrito=" + carrito +
                '}';
    }
}