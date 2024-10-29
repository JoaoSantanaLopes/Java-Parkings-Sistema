package org.example.model;

import java.util.List;


public class Vaga {
    private String identificador;
    private boolean disponibilidade;
    private List<UsoDaVaga> usoDaVaga;
    private static double valorPor15Min = 4;
    private static double valorLimite = 50;

    public Vaga(String identificador, boolean disponibilidade, List<UsoDaVaga> usoDaVaga) {
        this.identificador = identificador;
        this.disponibilidade = disponibilidade;
        this.usoDaVaga = usoDaVaga;
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

    public List<UsoDaVaga> getUsoDaVaga() {
        return usoDaVaga;
    }

    public void addUsoVaga(UsoDaVaga novoUso) {
        this.usoDaVaga.add(novoUso);
    }

    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial;
    }
}