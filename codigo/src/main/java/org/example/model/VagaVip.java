package org.example.model;

import java.util.List;

public class VagaVip extends Vaga{
    public VagaVip(String identificador, boolean disponibilidade) {
        super(identificador, disponibilidade);
    }

    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 1.20;
    }
}