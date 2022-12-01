package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.models.OrdenCompra;


import java.util.List;
import java.util.stream.Collectors;

public class CarritoDTO {

    private Long id;
    private List<OrdenCompraDTO> ordenCompra;

    public CarritoDTO() {}

    public CarritoDTO(Carrito carrito) {
        this.id = carrito.getId();
        this.ordenCompra = carrito.getOrdenCompra().stream().map(orden -> new OrdenCompraDTO(orden)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public List<OrdenCompraDTO> getOrdenCompra() {
        return ordenCompra;
    }
}
