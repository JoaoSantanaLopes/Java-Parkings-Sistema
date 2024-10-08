package org.example;

import java.util.List;

public class VagaVip extends Vaga{
    public VagaVip(String identificador, boolean disponibilidade, List<UsoDaVaga> usoDaVaga) {
        super(identificador, disponibilidade, usoDaVaga);
    }

    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 1.20;
    }
}