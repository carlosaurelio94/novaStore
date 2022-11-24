package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TicketCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private long id;

    private String numeroTicket;

    private String nombreProducto;

    private int cantidadProducto;

    private Double montoTotalProducto;

    private Double precioFinal;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "ticketCompra", fetch = FetchType.EAGER)
    private Set<TicketCompra> ticketCompra = new HashSet<>();

    public TicketCompra() {
    }

    public TicketCompra(String numeroTicket, String nombreProducto, int cantidadProducto, Double montoTotalProducto, Double precioFinal, Cliente cliente) {
        this.numeroTicket = numeroTicket;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.montoTotalProducto = montoTotalProducto;
        this.precioFinal = precioFinal;
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

    public Double getMontoTotalProducto() {
        return montoTotalProducto;
    }

    public void setMontoTotalProducto(Double montoTotalProducto) {
        this.montoTotalProducto = montoTotalProducto;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
