package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.dtos.ClienteDTO;
import com.tienda.tienda_de_ropa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired

    @GetMapping("/clientes")
    public List<ClienteDTO> listaClientesDTO(){
        return clienteService.getClientesDTO();
    }

    @GetMapping("/clientes/{id}")
    public ClienteDTO clienteDTO(@PathVariable long id) { return clienteService.clienteDTO(id); }

    @PostMapping("/clientes")
    public ResponseEntity<?> crearNuevoCliente(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String correo,
            @RequestParam String clave
    ){
        return null;
    }
}
