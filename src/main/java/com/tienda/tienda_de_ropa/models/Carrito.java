package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private Long id;

    public Carrito(Cliente cliente) {
        this.cliente = cliente;

    }

    public Carrito() {
    }

    @OneToMany(mappedBy="carrito", fetch=FetchType.EAGER)
    Set<Factura> facturas = new HashSet<>();
    @OneToMany(mappedBy="carrito", fetch=FetchType.LAZY)
    Set<OrdenCompra> ordenCompra = new HashSet<>();
    @OneToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    public Set<OrdenCompra> getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Set<OrdenCompra> ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", facturas=" + facturas +
                ", ordenCompra=" + ordenCompra +
                ", cliente=" + cliente +
                '}';
    }
}
