package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.models.Producto;

public interface ProductoService {
    public void guardarProducto(Producto producto);

    public Producto productoPorNombre(String nombre);

    public Producto productoPorId(Long id);

}
