package org.example.model;

import java.util.List;

public class VagaIdoso extends Vaga{
    public VagaIdoso(String identificador, boolean disponibilidade, int id) {
        super(identificador,disponibilidade, id);
    }
    public VagaIdoso() {
        
    }
    
    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 0.85;
    }
}