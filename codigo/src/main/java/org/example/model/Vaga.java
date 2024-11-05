package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Vaga implements Serializable{
    private static int proxId = 1;
    private String identificador;
    private boolean disponibilidade;
    private ArrayList<UsoDaVaga> usoDaVaga;
    private static double valorPor15Min = 4;
    private static double valorLimite = 50;
    private static final long serialVersionUID = 1L;

    public Vaga(String identificador, boolean disponibilidade) {
        this.identificador = identificador + this.getProxId();
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
    
    public UsoDaVaga getUltimo() {
        return usoDaVaga.get(usoDaVaga.size() - 1);
    }

    public void addUsoVaga(UsoDaVaga novoUso) {
        this.usoDaVaga.add(novoUso);
    }

    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vaga { ")
          .append("Identificador: '").append(identificador).append("', ")
          .append("Disponibilidade: ").append(disponibilidade).append(", ")
          .append("UsoDaVaga: [");

        for (int i = 0; i < usoDaVaga.size(); i++) {
            sb.append(usoDaVaga.get(i));
            if (i < usoDaVaga.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("] }");
        return sb.toString();
    }

}
