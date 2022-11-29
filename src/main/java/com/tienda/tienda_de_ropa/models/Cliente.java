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
    private double puntos;
    private boolean habilitado = false;

    private String token;

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<Compra> compras = new HashSet<>();

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<Contacto> contactos = new HashSet<>();

    @OneToMany(mappedBy= "cliente", fetch= FetchType.EAGER)
    private Set<GiftCard> giftCards = new HashSet<>();

    @OneToOne(mappedBy = "cliente", fetch = FetchType.EAGER)
    private Carrito carrito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, String clave, double puntos) {
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

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
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

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
                ", habilitado=" + habilitado +
                ", token='" + token + '\'' +
                ", compras=" + compras +
                ", contactos=" + contactos +
                ", giftCards=" + giftCards +
                ", carrito=" + carrito +
                '}';
    }
}
