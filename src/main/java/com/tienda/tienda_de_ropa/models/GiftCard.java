package com.tienda.tienda_de_ropa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class GiftCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private long id;

    private String numeroTarjeta;
    private Double monto;
    private double puntos;
    private boolean activada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public GiftCard() {
    }

    public GiftCard(String numeroTarjeta, Double monto, double puntos, boolean activada, Cliente cliente) {
        this.numeroTarjeta = numeroTarjeta;
        this.monto = monto;
        this.puntos = puntos;
        this.activada = activada;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public boolean isActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "id=" + id +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", monto=" + monto +
                ", puntos=" + puntos +
                ", activada=" + activada +
                ", cliente=" + cliente +
                '}';
    }
}
