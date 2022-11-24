package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.models.Factura;
import com.tienda.tienda_de_ropa.models.OrdenCompra;


import java.util.Set;

public class CarritoDTO {

    private Long id;

    private Set<Factura> facturas;

    private Set<OrdenCompra> ordenCompra;

    public CarritoDTO() {}

    public CarritoDTO(Carrito carrito) {
        this.id = carrito.getId();
        this.facturas = carrito.getFacturas();
        this.ordenCompra = carrito.getOrdenCompra();
    }

    public Long getId() {
        return id;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public Set<OrdenCompra> getOrdenCompra() {
        return ordenCompra;
    }

}
