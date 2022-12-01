package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.dtos.FacturaDTO;

import java.util.List;

public interface FacturaService {

    public List<FacturaDTO> traerTodos();

    public FacturaDTO traerFacturaPorId(long id);
}
