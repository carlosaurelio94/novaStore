package com.tienda.tienda_de_ropa.service;

import com.tienda.tienda_de_ropa.models.Contacto;
import org.springframework.stereotype.Service;

@Service
public interface ContactoService {
    public void guardarContacto(Contacto contacto);

}
