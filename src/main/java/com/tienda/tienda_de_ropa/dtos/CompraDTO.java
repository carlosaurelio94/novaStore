package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.TipoTransaccion;
import com.tienda.tienda_de_ropa.models.Compra;

import java.time.LocalDateTime;

public class CompraDTO {
    private long id;
    private LocalDateTime fecha;
    private TipoTransaccion tipoTransaccion;
    private String descripcion;
    private Double monto;

    public CompraDTO() {
    }

    public CompraDTO(Compra compra) {
        this.id = compra.getId();
        this.fecha = compra.getFecha();
        this.tipoTransaccion = compra.getTipoTransaccion();
        this.descripcion = compra.getDescripcion();
        this.monto = compra.getMonto();
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getMonto() {
        return monto;
    }
}
