package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.dtos.ProductoDTO;
import com.tienda.tienda_de_ropa.models.Producto;
import com.tienda.tienda_de_ropa.repositories.ProductoRepository;
import com.tienda.tienda_de_ropa.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImplement  implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto productoPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public Producto productoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductoDTO> traerTodos() {
        return productoRepository.findAll().stream().map(producto -> new ProductoDTO(producto)).collect(Collectors.toList());
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepository.delete(producto);
    }
}
