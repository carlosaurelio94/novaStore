package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.models.Factura;

import java.time.LocalDateTime;

public class FacturaDTO {

    private Long id;
    private double precioTotal;
    private LocalDateTime fechaCreacion;

    public FacturaDTO() {
    }

    public FacturaDTO(Factura factura) {
        this.id = factura.getId();
        this.precioTotal = factura.getPrecioTotal();
        this.fechaCreacion = factura.getFechaCreacion();
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

}
