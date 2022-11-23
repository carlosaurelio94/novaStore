package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator= "native")
    @GenericGenerator(strategy= "native", name= "native")
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private int puntos;

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<Transaccion> transacciones = new HashSet<>();

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<Contacto> contactos = new HashSet<>();

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<ClienteGiftCard> clienteGiftCards = new HashSet<>();

    @OneToMany(mappedBy= "cliente", fetch = FetchType.EAGER)
    private Set<ClienteProducto> clienteProductos = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String clave, int puntos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.puntos = puntos;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Set<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Set<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public Set<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Set<ClienteGiftCard> getClienteGiftCards() {
        return clienteGiftCards;
    }

    public void setClienteGiftCards(Set<ClienteGiftCard> clienteGiftCards) {
        this.clienteGiftCards = clienteGiftCards;
    }

    public Set<ClienteProducto> getClienteProductos() {
        return clienteProductos;
    }

    public void setClienteProductos(Set<ClienteProducto> clienteProductos) {
        this.clienteProductos = clienteProductos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", puntos=" + puntos +
                ", transacciones=" + transacciones +
                ", contactos=" + contactos +
                ", clienteGiftCards=" + clienteGiftCards +
                ", clienteProductos=" + clienteProductos +
                '}';
    }
}
