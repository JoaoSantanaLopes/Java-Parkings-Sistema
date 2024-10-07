/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labzinho;

import java.time.LocalTime;
import java.time.Duration;

/**
 *
 * @author Pedro
 */
public class UsoDaVaga {
    private final LocalTime dataHoraEntrada; 
    private LocalTime dataHoraSaida;
    private Veiculo veiculo;
    private Vaga vaga;
    
    public UsoDaVaga(Veiculo veiculo, Vaga vaga) {
        this.dataHoraEntrada = LocalTime.now();
        this.veiculo =  veiculo;
        this.vaga = vaga;
    }
    public LocalTime getDataHoraEntrada() {
        return this.dataHoraEntrada;
    }
   
    public LocalTime getDataHoraSaida() {
        return this.dataHoraSaida;
    }
    public Veiculo getVeiculo() {
        return this.veiculo;
    }
    public void setVeiculo(Veiculo carro) {
        this.veiculo = carro;
    }
    private long calcularTempoEstadia() {
        long segundos = Duration.between(this.dataHoraEntrada, this.dataHoraSaida).getSeconds();
        long minutos = segundos/60;
        return minutos;
    }
    public double baixaUsoDaVaga() {
        this.dataHoraSaida = LocalTime.now();
        long tempo = calcularTempoEstadia();
        double valor = Vaga.getValorPor15Min() * tempo;
        if(valor > Vaga.getPrecoMaximo()) {
            return vaga.calcularPrecoVaga(Vaga.getPrecoMaximo());
        }
        return vaga.calcularPrecoVaga(valor);
    }
}
