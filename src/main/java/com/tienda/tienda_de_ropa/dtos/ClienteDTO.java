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

    private Set<TransaccionDTO> transacciones = new HashSet<>();

    private Set<ContactoDTO> contactos = new HashSet<>();

    private Set<GiftCardDTO> giftCards = new HashSet<>();

    private Set<ClienteProductoDTO> clienteProductos = new HashSet<>();

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.correo = cliente.getCorreo();
        this.clave = cliente.getClave();
        this.puntos = cliente.getPuntos();
        this.transacciones = cliente.getTransacciones().stream().map(transaccion -> new TransaccionDTO(transaccion)).collect(Collectors.toSet());
        this.contactos = cliente.getContactos().stream().map(contacto -> new ContactoDTO(contacto)).collect(Collectors.toSet());
        this.giftCards = cliente.getGiftCards().stream().map(giftCard -> new GiftCardDTO(giftCard)).collect(Collectors.toSet());
        this.clienteProductos = cliente.getClienteProductos().stream().map(clienteProducto -> new ClienteProductoDTO(clienteProducto)).collect(Collectors.toSet());
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

    public Set<TransaccionDTO> getTransacciones() {
        return transacciones;
    }

    public Set<ContactoDTO> getContactos() {
        return contactos;
    }

    public Set<GiftCardDTO> getGiftCards() {
        return giftCards;
    }

    public Set<ClienteProductoDTO> getClienteProductos() {
        return clienteProductos;
    }
}
