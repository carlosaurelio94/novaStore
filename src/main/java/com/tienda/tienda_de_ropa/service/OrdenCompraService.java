package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.models.OrdenCompra;
import com.tienda.tienda_de_ropa.service.implementation.OrdenCompraServiceImplement;

public interface OrdenCompraService {

    public void guardarOrdenCompra(OrdenCompra ordenCompra);

    public OrdenCompra buscarPorNombre(String nombre);

}
