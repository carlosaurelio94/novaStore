package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.dtos.ProductoDTO;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.models.Producto;

import java.util.List;

public interface ProductoService {
    public void guardarProducto(Producto producto);

    public Producto productoPorNombre(String nombre);

    public Producto productoPorId(Long id);

    public List<ProductoDTO> traerTodos();

    public void eliminarProducto(Producto producto);
}
