package org.example.model;

import java.io.Serializable;

public class Veiculo implements Serializable{
    private String placa;
    private String modelo;
    private String marca;
    private static final long serialVersionUID = 1L;

    public Veiculo() {
        
    }
    
    public Veiculo(String placa, String modelo, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
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

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Veiculo { " +
               "Placa: '" + placa + '\'' +
               ", Modelo: '" + modelo + '\'' +
               ", Marca: '" + marca + '\'' +
               " }";
    }
}