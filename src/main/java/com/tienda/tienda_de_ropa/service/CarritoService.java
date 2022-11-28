package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.dtos.CarritoDTO;
import com.tienda.tienda_de_ropa.models.Carrito;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface CarritoService {
    public void guardarCarrito(Carrito carrito);
    public List<CarritoDTO> traerTodos();
    public CarritoDTO traerCarritoPorId (Long id);
    public CarritoDTO traerCarritoAutenticado(Authentication authentication);
    public ResponseEntity<?> crearCarrito(Authentication authentication);

    public void eliminarCarrito(Carrito carrito);
}
