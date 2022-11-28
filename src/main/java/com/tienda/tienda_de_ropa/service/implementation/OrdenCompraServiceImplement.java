package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.OrdenCompra;
import com.tienda.tienda_de_ropa.repositories.OrdenCompraRepository;
import com.tienda.tienda_de_ropa.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrdenCompraServiceImplement implements OrdenCompraService {

    @Autowired
    OrdenCompraRepository ordenCompraRepository;

    @Override
    public void eliminarTodas(Set<OrdenCompra> ordenCompra) {
        ordenCompraRepository.deleteAll(ordenCompra);
    }

    @Override
    public void guardarOrdenCompra(OrdenCompra ordenCompra) {
        ordenCompraRepository.save(ordenCompra);
    }
}
