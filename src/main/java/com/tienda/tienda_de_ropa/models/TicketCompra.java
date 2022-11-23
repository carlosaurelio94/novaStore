package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class TicketCompra {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator= "native")
    @GenericGenerator(strategy= "native", name= "native")
    private long id;

    private String numeroTicket;

    private String nombreProducto;

    private int cantidadProducto;

    private Double montoTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public TicketCompra() {}

    public TicketCompra(String numeroTicket, String nombreProducto, int cantidadProducto, Double montoTotal, Cliente cliente) {
        this.numeroTicket = numeroTicket;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.montoTotal = montoTotal;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
