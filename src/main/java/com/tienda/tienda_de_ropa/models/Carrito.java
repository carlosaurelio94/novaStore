package com.tienda.tienda_de_ropa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany(mappedBy="carrito", fetch=FetchType.EAGER)
    Set<Factura> facturas = new HashSet<>();
    @OneToMany(mappedBy="carrito", fetch=FetchType.EAGER)
    Set<OrdenCompra> ordenCompra = new HashSet<>();
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Carrito() {
    }

    public Carrito(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
    @JsonIgnore
    public Set<OrdenCompra> getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Set<OrdenCompra> ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @JsonIgnore
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

//    @Override
//    public String toString() {
//        return "Carrito{" +
//                "id=" + id +
//                ", facturas=" + facturas +
//                ", ordenCompra=" + ordenCompra +
//                ", cliente=" + cliente +
//                '}';
//    }
}
