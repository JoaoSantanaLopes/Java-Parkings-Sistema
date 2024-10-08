package org.example;

import java.util.List;

public class VagaPCD extends Vaga {
    public VagaPCD(String identificador, boolean disponibilidade, List<UsoDaVaga> usoDaVaga) {
        super(identificador, disponibilidade, usoDaVaga);
    }

    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 0.87;
    }
}