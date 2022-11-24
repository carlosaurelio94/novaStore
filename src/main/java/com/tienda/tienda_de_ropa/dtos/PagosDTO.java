package com.tienda.tienda_de_ropa.dtos;

public class PagosDTO {
    private String numeroTarjeta;
    private int cvv;
    private Double monto;
    private String descripcion;

    public PagosDTO() {
    }

    public PagosDTO(String numeroTarjeta, int cvv, Double monto, String descripcion) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getCvv() {
        return cvv;
    }

    public Double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
