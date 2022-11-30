package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.dtos.CompraDTO;
import com.tienda.tienda_de_ropa.models.Compra;

import java.util.Set;

public interface CompraService {
    public void guardarCompra(Compra compra);

    public Set<CompraDTO> traerCompras (String email);

    }
