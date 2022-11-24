package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.Producto;
import com.tienda.tienda_de_ropa.repositories.ProductoRepository;
import com.tienda.tienda_de_ropa.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImplement  implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }
}
