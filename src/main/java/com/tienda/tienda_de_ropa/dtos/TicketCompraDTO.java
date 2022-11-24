package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.TicketCompra;

public class TicketCompraDTO {

    private long id;

    private String numeroTicket;

    private String nombreProducto;

    private int cantidadProducto;

    private Double montoTotal;

    public TicketCompraDTO() {}

    public TicketCompraDTO(TicketCompra ticketCompra) {
        this.id = ticketCompra.getId();
        this.numeroTicket = ticketCompra.getNumeroTicket();
        this.nombreProducto = ticketCompra.getNombreProducto();
        this.cantidadProducto = ticketCompra.getCantidadProducto();
        this.montoTotal = ticketCompra.getMontoTotalProducto();
    }

    public long getId() {
        return id;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }


}
