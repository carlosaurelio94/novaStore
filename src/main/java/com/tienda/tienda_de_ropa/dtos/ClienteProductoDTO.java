package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.TicketCompraProducto;

public class ClienteProductoDTO {
    private long id;
    private String nombreProducto;
    private int cantidadProducto;

    public ClienteProductoDTO(TicketCompraProducto ticketCompraProducto) {
        this.id = ticketCompraProducto.getId();
        this.nombreProducto = ticketCompraProducto.getNombreProducto();
        this.cantidadProducto = ticketCompraProducto.getCantidadProducto();
    }

    public long getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }
}
