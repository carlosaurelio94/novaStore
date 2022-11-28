package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.models.OrdenCompra;

import java.util.Set;

public interface OrdenCompraService {

    public void eliminarTodas(Set<OrdenCompra> ordenCompra);

    public void guardarOrdenCompra(OrdenCompra ordenCompra);

}
