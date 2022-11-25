package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private int puntos;

    private Set<CompraDTO> compras = new HashSet<>();

    private Set<ContactoDTO> contactos = new HashSet<>();

    private Set<GiftCardDTO> giftCards = new HashSet<>();

    private Carrito carrito;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.correo = cliente.getCorreo();
        this.clave = cliente.getClave();
        this.puntos = cliente.getPuntos();
        this.compras = cliente.getCompras().stream().map(compra -> new CompraDTO(compra)).collect(Collectors.toSet());
        this.contactos = cliente.getContactos().stream().map(contacto -> new ContactoDTO(contacto)).collect(Collectors.toSet());
        this.giftCards = cliente.getGiftCards().stream().map(giftCard -> new GiftCardDTO(giftCard)).collect(Collectors.toSet());
        this.carrito = cliente.getCarrito();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public int getPuntos() {
        return puntos;
    }

    public Set<CompraDTO> getCompras() {
        return compras;
    }

    public Set<ContactoDTO> getContactos() {
        return contactos;
    }

    public Set<GiftCardDTO> getGiftCards() {
        return giftCards;
    }

}
