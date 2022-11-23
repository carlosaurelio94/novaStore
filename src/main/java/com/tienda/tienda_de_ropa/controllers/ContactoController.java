package com.tienda.tienda_de_ropa.controllers;


import com.tienda.tienda_de_ropa.dtos.ClienteDTO;
import com.tienda.tienda_de_ropa.dtos.ContactoDTO;
import com.tienda.tienda_de_ropa.models.Cliente;
import com.tienda.tienda_de_ropa.models.Contacto;
import com.tienda.tienda_de_ropa.repositories.ContactoRepository;
import com.tienda.tienda_de_ropa.service.ClienteService;
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
    ContactoRepository contactoRepository;

    @PostMapping("/clients/current/contacts")
    public ResponseEntity<?> crearContacto (@RequestParam String correo, @RequestParam String apodo,
                                            Authentication authentication) {

        Cliente clienteActual = clienteService.findByCorreo(authentication.getName());
        Cliente clienteContacto = clienteService.findByCorreo(correo);

        Set<Contacto> setContactos = clienteActual.getContactos().stream()
                .filter(contacto -> contacto.getCorreo().equals(correo)).collect(Collectors.toSet());

        if(clienteActual == null) {
            return new ResponseEntity<>("NECESITAMOS QUE INGRESE SU USUARIO", HttpStatus.FORBIDDEN);
        }
        if(apodo.isEmpty()) {
            return new ResponseEntity<>("EL CAMPO APODO ESTÁ VACÍO", HttpStatus.FORBIDDEN);
        }
        if(correo.isEmpty()) {
            return new ResponseEntity<>("EL CAMPO CORREO ESTÁ VACÍO", HttpStatus.FORBIDDEN);
        }
        if(clienteContacto == null) {
            return new ResponseEntity<>("ESTE CLIENTE NO EXISTE", HttpStatus.FORBIDDEN);
        }
        if(setContactos.size() >= 1) {
            return new ResponseEntity<>("YA TIENE AGREGADO A ESTE CONTACTO EN SU AGENDA", HttpStatus.FORBIDDEN);
        }

        contactoRepository.save(new Contacto(correo, apodo, clienteActual));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/clients/current/contacts")
    public Set<ContactoDTO> traerContactos(Authentication authentication) {
        return new ClienteDTO(clienteService.findByCorreo(authentication.getName())).getContactos();
    }

}