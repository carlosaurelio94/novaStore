package com.tienda.tienda_de_ropa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        List<Double> monto = carrito.getOrdenCompra().stream().map(compra -> compra.getPrecio()).collect(Collectors.toList());
        double total = 0.0;
        for (double precio : monto) {
            total = total + precio;
        }
        return total;
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

    @JsonIgnore
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
