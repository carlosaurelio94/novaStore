package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.Carrito;
import com.tienda.tienda_de_ropa.repositories.CarritoRepository;
import com.tienda.tienda_de_ropa.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImplement implements CarritoService {

    @Autowired
    CarritoRepository carritoRepository;

    @Override
    public void guardarCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }
}
