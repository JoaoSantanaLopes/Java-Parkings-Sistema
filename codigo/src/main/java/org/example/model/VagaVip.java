package org.example.model;

import java.util.List;

public class VagaVip extends Vaga{
    public VagaVip(String identificador, boolean disponibilidade, int id) {
        super(identificador,disponibilidade, id);
    }

    public VagaVip() {
    }
    
    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 1.20;
    }
}