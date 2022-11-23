package com.tienda.tienda_de_ropa.models;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ClienteProducto {
    private long id;
    private String nombreProducto;
    private int cantidadProducto;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name= "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name= "producto_id")
    private Producto producto;

    public ClienteProducto() {
    }

    public ClienteProducto(String nombreProducto, int cantidadProducto, Cliente cliente, Producto producto) {
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
                ", cliente=" + cliente +
                ", producto=" + producto +
                '}';
    }
}
