package com.tienda.tienda_de_ropa.dtos;

import com.tienda.tienda_de_ropa.models.GiftCard;

public class GiftCardDTO {
    private long id;
    private String numeroTarjeta;
    private Double monto;
    private double puntos;
    private boolean activada = true;

    public GiftCardDTO(GiftCard giftCard) {
        this.id = giftCard.getId();
        this.numeroTarjeta = giftCard.getNumeroTarjeta();
        this.monto = giftCard.getMonto();
        this.puntos = giftCard.getPuntos();
        this.activada = giftCard.isActivada();
    }

    public long getId() {
        return id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Double getMonto() {
        return monto;
    }

    public double getPuntos() {
        return puntos;
    }

    public boolean isActivada() {
        return activada;
    }

}
