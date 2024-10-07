/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labzinho;

import java.util.List;

/**
 *
 * @author Pedro
 */
public class VagaVip extends Vaga{
    
    public VagaVip(String identificador, boolean disponibilidade, List<UsoDaVaga> usoDaVaga) {
        super(identificador, disponibilidade, usoDaVaga);
    }
    public double calcularPrecoVaga(double valorParcial) {
        return valorParcial * 1.20;
    } 
}
