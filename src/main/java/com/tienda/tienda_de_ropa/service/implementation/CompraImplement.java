package com.tienda.tienda_de_ropa.service.implementation;

import ch.qos.logback.core.net.server.Client;
import com.tienda.tienda_de_ropa.dtos.CompraDTO;
import com.tienda.tienda_de_ropa.models.Compra;
import com.tienda.tienda_de_ropa.repositories.ClienteRepository;
import com.tienda.tienda_de_ropa.repositories.CompraRepository;
import com.tienda.tienda_de_ropa.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompraImplement implements CompraService {
    @Autowired
    CompraRepository compraRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void guardarCompra(Compra compra) {
        compraRepository.save(compra);
    }

    public Set<CompraDTO> traerCompras (String email) {
        return clienteRepository.findByCorreo(email).getCompras().stream().map(compra -> new CompraDTO(compra)).collect(Collectors.toSet());
    }
}
