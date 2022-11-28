package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.models.OrdenCompra;
import com.tienda.tienda_de_ropa.repositories.ClienteRepository;
import com.tienda.tienda_de_ropa.repositories.OrdenCompraRepository;
import com.tienda.tienda_de_ropa.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrdenCompraServiceImplement implements OrdenCompraService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    OrdenCompraRepository ordenCompraRepository;

    public void guardarOrdenCompra(OrdenCompra ordenCompra) {
        ordenCompraRepository.save(ordenCompra);
    }

    public OrdenCompra buscarPorNombre(String nombre) {
        return ordenCompraRepository.findByNombre(nombre);
    }


}
