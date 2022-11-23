package com.tienda.tienda_de_ropa.dtos;

public class ClienteProductoDTO {
    private long id;
    private String nombreProducto;
    private int cantidadProducto;

    public ClienteProductoDTO(ClienteProductoDTO clienteProductoDTO) {
        this.id = clienteProductoDTO.getId();
        this.nombreProducto = clienteProductoDTO.getNombreProducto();
        this.cantidadProducto = clienteProductoDTO.getCantidadProducto();
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
