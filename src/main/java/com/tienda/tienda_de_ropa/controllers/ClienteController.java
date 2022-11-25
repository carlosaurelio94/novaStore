package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.dtos.ClienteDTO;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    PasswordEncoder passwordEncoder;

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
            @RequestParam String clave,
            @RequestParam String clave2
    ){
        if (nombre.isEmpty()) {
            return new ResponseEntity<>("Falta el dato Nombre", HttpStatus.FORBIDDEN);
        }
        if(apellido.isEmpty()){
            return new ResponseEntity<>("Falta el dato Apellido", HttpStatus.FORBIDDEN);
        }
        if(correo.isEmpty()){
            return new ResponseEntity<>("Falta el dato Correo", HttpStatus.FORBIDDEN);
        }
        if(clave.isEmpty()){
            return new ResponseEntity<>("Falta el dato contraseña", HttpStatus.FORBIDDEN);
        }
        if (clienteService.findByCorreo(correo) != null) {
            return new ResponseEntity<>("El correo ya se encuentra en uso", HttpStatus.FORBIDDEN);
        }
        if (!clave.equals(clave2)) {
            return new ResponseEntity<>("Las contraseñas no coinciden", HttpStatus.FORBIDDEN);
        }

        Cliente nuevoCliente = new Cliente(nombre, apellido, correo, passwordEncoder.encode(clave), 0);
        clienteService.guardarCliente(nuevoCliente);

        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/clientes/actual")
    public ClienteDTO traerClienteAutenticado(Authentication authentication) {
        return new ClienteDTO(clienteService.findByCorreo(authentication.getName()));
    }
}
