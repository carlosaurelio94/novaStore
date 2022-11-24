package com.tienda.tienda_de_ropa.controllers;

import com.tienda.tienda_de_ropa.dtos.ClienteDTO;
import com.tienda.tienda_de_ropa.dtos.ContactoDTO;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.models.Contacto;
import com.tienda.tienda_de_ropa.service.ClienteService;
import com.tienda.tienda_de_ropa.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ContactoController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ContactoService contactoService;
    @PostMapping("/clientes/current/contactos")
    public ResponseEntity<?> crearContacto (@RequestParam String correo,
                                            @RequestParam String apodo,
                                            Authentication authentication) {

        Cliente clienteActual = clienteService.findByCorreo(authentication.getName());
        Cliente clienteContacto = clienteService.findByCorreo(correo);

        Set<Contacto> contactosSet = clienteActual.getContactos().stream()
                .filter(contacto -> contacto.getCorreo().equals(correo)).collect(Collectors.toSet());

        if(clienteActual == null) {
            return new ResponseEntity<>("Por favor, ingresa tu usuario", HttpStatus.FORBIDDEN);
        }
        if(apodo.isEmpty()) {
            return new ResponseEntity<>("Falta el dato Apodo", HttpStatus.FORBIDDEN);
        }
        if(correo.isEmpty()) {
            return new ResponseEntity<>("Falta el dato Correo", HttpStatus.FORBIDDEN);
        }
        if(clienteContacto == null) {
            return new ResponseEntity<>("Este cliente no existe", HttpStatus.FORBIDDEN);
        }
        if(contactosSet.size() >= 1) {
            return new ResponseEntity<>("Este contacto ya está guardado", HttpStatus.FORBIDDEN);
        }

        contactoService.guardarContacto(new Contacto(correo, apodo, clienteContacto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public Set<ContactoDTO> traerContactos(Authentication authentication) {
        return new ClienteDTO(clienteService.findByCorreo(authentication.getName())).getContactos();
    }

}
