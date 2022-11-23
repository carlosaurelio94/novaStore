package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Contacto;

public class ContactoDTO {

    private long id;

    private String email;

    private String apodo;

    public ContactoDTO() {}

    public ContactoDTO(Contacto contacto) {
        this.id = contacto.getId();
        this.email = contacto.getEmail();
        this.apodo = contacto.getApodo();
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getApodo() {
        return apodo;
    }
}
