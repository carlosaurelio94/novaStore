package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.dtos.ClienteDTO;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.repositories.ClienteRepository;
import com.tienda.tienda_de_ropa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> getClientesDTO() {
        return clienteRepository.findAll().stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO clienteDTO(long id) {
        return clienteRepository.findById(id).map(cliente -> new ClienteDTO(cliente)).orElse(null);
    }

    @Override
    public Cliente findByCorreo(String correo) {
        return clienteRepository.findByCorreo(correo);
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente encontrarPorId(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
