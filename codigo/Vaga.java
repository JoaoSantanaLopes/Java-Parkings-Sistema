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
public class Vaga {
    private String identificador;
    private boolean disponibilidade;
    private List<UsoDaVaga> usoDaVaga;
    public Vaga(String identificador, boolean disponibilidade, List<UsoDaVaga> usoDaVaga) {
        this.identificador = identificador;
        this.disponibilidade = disponibilidade;
        this.usoDaVaga = usoDaVaga;
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

}
