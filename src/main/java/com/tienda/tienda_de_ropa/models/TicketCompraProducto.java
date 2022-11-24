package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class TicketCompraProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(strategy= "native", name= "native")
    private long id;

    private String numeroTicket;
    private String nombreProducto;
    private int cantidadProducto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketCompra_id")
    private TicketCompra ticketCompra;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name= "producto_id")
    private Producto producto;

    public TicketCompraProducto() {
    }

    public TicketCompraProducto(int cantidadProducto, TicketCompra ticketCompra, Producto producto) {
        this.numeroTicket = ticketCompra.getNumeroTicket();
        this.nombreProducto = producto.getNombre();
        this.cantidadProducto = cantidadProducto;
        this.ticketCompra = ticketCompra;
        this.producto = producto;
    }

    public long getId() {
        return id;
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

    public TicketCompra getTicketCompra() {
        return ticketCompra;
    }

    public void setTicketCompra(TicketCompra ticketCompra) {
        this.ticketCompra = ticketCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ClienteProducto{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidadProducto=" + cantidadProducto +
                ", ticketCompra=" + ticketCompra +
                ", producto=" + producto +
                '}';
    }
}
