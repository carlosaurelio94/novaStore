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
    private String correo;
    private String clave;
    private int puntos;

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<Compra> transacciones = new HashSet<>();

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<Contacto> contactos = new HashSet<>();

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<GiftCard> giftCards = new HashSet<>();

    @OneToOne(mappedBy="client")
    private Carrito carrito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, String clave, int puntos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public Set<Compra> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Set<Compra> transacciones) {
        this.transacciones = transacciones;
    }

    public Set<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Set<GiftCard> getGiftCards() {
        return giftCards;
    }

    public void setGiftCards(Set<GiftCard> giftCards) {
        this.giftCards = giftCards;
    }



    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", puntos=" + puntos +
                ", transacciones=" + transacciones +
                ", contactos=" + contactos +
                '}';
    }
}
