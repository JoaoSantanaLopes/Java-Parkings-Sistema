package org.example.model;

import java.util.List;

public class VagaIdoso extends Vaga{
    public VagaIdoso(String identificador, boolean disponibilidade, List<UsoDaVaga> usoDaVaga) {
        super(identificador, disponibilidade, usoDaVaga);
    }
    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 0.85;
    }
}