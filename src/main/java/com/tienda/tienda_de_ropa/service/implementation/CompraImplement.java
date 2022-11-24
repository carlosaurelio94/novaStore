package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.Compra;
import com.tienda.tienda_de_ropa.repositories.CompraRepository;
import com.tienda.tienda_de_ropa.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraImplement implements CompraService {
    @Autowired
    CompraRepository compraRepository;


    @Override
    public void guardarCompra(Compra compra) {
        compraRepository.save(compra);
    }
}
