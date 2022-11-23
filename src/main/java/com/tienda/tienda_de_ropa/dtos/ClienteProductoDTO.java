package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.ClienteProducto;

public class ClienteProductoDTO {
    private long id;
    private String nombreProducto;
    private int cantidadProducto;

    public ClienteProductoDTO(ClienteProducto clienteProducto) {
        this.id = clienteProducto.getId();
        this.nombreProducto = clienteProducto.getNombreProducto();
        this.cantidadProducto = clienteProducto.getCantidadProducto();
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
