package com.hibernate.Ferreteria.DTOs;

public class ArticuloDTO {
    private Long Id;
    private String nombrearticulo;

    private double precio;
    private Integer stock;

    public ArticuloDTO(Long id, String nombrearticulo, double precio, Integer stock) {
        this.Id= id;
        this.nombrearticulo = nombrearticulo;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getNombrearticulo() {
        return nombrearticulo;
    }

    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ArticuloDTO{" +
                "id=" + Id +
                ", nombrearticulo='" + nombrearticulo + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
