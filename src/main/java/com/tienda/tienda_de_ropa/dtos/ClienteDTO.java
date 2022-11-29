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
    private double puntos;
    private boolean habilitado;
    private Set<CompraDTO> compras = new HashSet<>();
    private Set<ContactoDTO> contactos = new HashSet<>();
    private Set<GiftCardDTO> giftCards = new HashSet<>();
    private Set<FacturaDTO> facturas = new HashSet<>();
    private CarritoDTO carrito;


    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.correo = cliente.getCorreo();
        this.clave = cliente.getClave();
        this.puntos = cliente.getPuntos();
        this.habilitado = cliente.isHabilitado();
        this.facturas = cliente.getCarrito().getFacturas().stream().map(factura -> new FacturaDTO(factura)).collect(Collectors.toSet());
        this.compras = cliente.getCompras().stream().map(compra -> new CompraDTO(compra)).collect(Collectors.toSet());
        this.contactos = cliente.getContactos().stream().map(contacto -> new ContactoDTO(contacto)).collect(Collectors.toSet());
        this.giftCards = cliente.getGiftCards().stream().map(giftCard -> new GiftCardDTO(giftCard)).collect(Collectors.toSet());
        this.carrito = new CarritoDTO(cliente.getCarrito());
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

    public double getPuntos() {
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

    public CarritoDTO getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDTO carrito) {
        this.carrito = carrito;
    }

    public Set<FacturaDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<FacturaDTO> facturas) {
        this.facturas = facturas;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
