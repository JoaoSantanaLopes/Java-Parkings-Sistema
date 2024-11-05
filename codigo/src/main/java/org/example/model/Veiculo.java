package org.example.model;

import java.io.Serializable;

public class Veiculo implements Serializable{
    private String placa;
    private String modelo;
    private String marca;
    private Cliente dono;
    private static final long serialVersionUID = 1L;

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
    @Override
    public String toString() {
        return "Veículo { " +
               "Placa: '" + placa + '\'' +
               ", Modelo: '" + modelo + '\'' +
               ", Marca: '" + marca + '\'' +
               ", Dono: " + (dono != null ? dono.getNome() : "Nenhum") +
               " }";
    }
}