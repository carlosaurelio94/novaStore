package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.*;

import java.util.HashSet;
import java.util.Set;

public class ClienteDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private int puntos;

    private Set<Transaccion> transacciones = new HashSet<>();

    private Set<Contacto> contactos = new HashSet<>();

    private Set<GiftCard> giftCards = new HashSet<>();

    private Set<ClienteProducto> clienteProductos = new HashSet<>();

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.correo = cliente.getCorreo();
        this.clave = cliente.getClave();
        this.puntos = cliente.getPuntos();
        this.transacciones = cliente.getTransacciones();
        this.contactos = cliente.getContactos();
        this.giftCards = cliente.getGiftCards();
        this.clienteProductos = cliente.getClienteProductos();
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

    public Set<Transaccion> getTransacciones() {
        return transacciones;
    }

    public Set<Contacto> getContactos() {
        return contactos;
    }

    public Set<GiftCard> getGiftCards() {
        return giftCards;
    }

    public Set<ClienteProducto> getClienteProductos() {
        return clienteProductos;
    }
}
