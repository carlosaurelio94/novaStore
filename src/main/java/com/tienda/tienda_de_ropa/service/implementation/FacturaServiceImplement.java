package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.dtos.FacturaDTO;
import com.tienda.tienda_de_ropa.repositories.FacturaRepository;
import com.tienda.tienda_de_ropa.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImplement implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public List<FacturaDTO> traerTodos() {
        return facturaRepository.findAll().stream().map(factura -> new FacturaDTO(factura)).collect(Collectors.toList());
    }

    @Override
    public FacturaDTO traerFacturaPorId(long id) {
        return facturaRepository.findById(id).map(factura -> new FacturaDTO(factura)).orElse(null);
    }
}
