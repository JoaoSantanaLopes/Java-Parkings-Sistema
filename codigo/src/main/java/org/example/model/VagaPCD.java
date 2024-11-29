package org.example.model;

import java.util.List;

public class VagaPCD extends Vaga {
    public VagaPCD(String identificador, boolean disponibilidade, int id) {
        super(identificador,disponibilidade, id);
    }

    public VagaPCD() {
    }
    
    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 0.87;
    }
}