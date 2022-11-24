package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.Contacto;

public class ContactoDTO {

    private long id;

    private String correo;

    private String apodo;

    public ContactoDTO() {}

    public ContactoDTO(Contacto contacto) {
        this.id = contacto.getId();
        this.correo = contacto.getCorreo();
        this.apodo = contacto.getApodo();
    }

    public long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getApodo() {
        return apodo;
    }
}
