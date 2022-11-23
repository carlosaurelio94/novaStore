package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.TipoTransaccion;
import com.tienda.tienda_de_ropa.models.Transaccion;

import java.time.LocalDateTime;

public class TransaccionDTO {
    private long id;
    private LocalDateTime fecha;
    private TipoTransaccion tipoTransaccion;
    private String descripcion;
    private Double monto;

    public TransaccionDTO() {
    }

    public TransaccionDTO(Transaccion transaccion) {
        this.id = transaccion.getId();
        this.fecha = transaccion.getFecha();
        this.tipoTransaccion = transaccion.getTipoTransaccion();
        this.descripcion = transaccion.getDescripcion();
        this.monto = transaccion.getMonto();
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
