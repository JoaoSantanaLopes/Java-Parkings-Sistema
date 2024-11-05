package org.example.model;

import java.util.ArrayList;


public class Vaga {
    private static int proxId = 1;
    private String identificador;
    private boolean disponibilidade;
    private ArrayList<UsoDaVaga> usoDaVaga;
    private static double valorPor15Min = 4;
    private static double valorLimite = 50;

    public Vaga(String identificador, boolean disponibilidade) {
        this.identificador = "V" + this.getProxId();
        this.disponibilidade = disponibilidade;
        this.usoDaVaga = new ArrayList<>();
    }
    
    private int getProxId(){
        return proxId++;
    }
    
    public static double getValorPor15Min() {
        return valorPor15Min;
    }

    public static double getValorLimite() {
        return valorLimite;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public boolean getDisponibilidade() {
        return this.disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public ArrayList<UsoDaVaga> getUsoDaVaga() {
        return usoDaVaga;
    }

    public void addUsoVaga(UsoDaVaga novoUso) {
        this.usoDaVaga.add(novoUso);
    }

    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial;
    }
}