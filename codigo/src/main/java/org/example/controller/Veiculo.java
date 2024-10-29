package org.example.controller;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private Cliente dono;

    public Veiculo(String placa, String modelo, String marca, Cliente dono) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.dono = dono;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Cliente getDono() {
        return dono;
    }
}