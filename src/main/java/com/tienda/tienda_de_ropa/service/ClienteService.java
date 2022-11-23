package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.dtos.ClienteDTO;

import java.util.List;

public interface ClienteService {

    public List<ClienteDTO> getClientesDTO();

    public ClienteDTO clienteDTO(long id);
}
