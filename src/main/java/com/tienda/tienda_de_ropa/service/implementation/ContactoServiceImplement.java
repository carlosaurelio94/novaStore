package com.tienda.tienda_de_ropa.service.implementation;

import com.tienda.tienda_de_ropa.models.Contacto;
import com.tienda.tienda_de_ropa.repositories.ContactoRepository;
import com.tienda.tienda_de_ropa.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImplement implements ContactoService {

    @Autowired
    ContactoRepository contactoRepository;

    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }
}
