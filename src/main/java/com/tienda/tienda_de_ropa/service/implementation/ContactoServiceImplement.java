package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.Contacto;
import com.tienda.tienda_de_ropa.repositories.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContactoServiceImplement {

    @Autowired
    ContactoRepository contactoRepository;

    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }
}
