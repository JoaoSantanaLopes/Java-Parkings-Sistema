package org.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Duration;

public class UsoDaVaga implements Serializable{
    
    private static int proxId = 1;
    private int id;
    private final LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private Cliente cliente;
    private Vaga vaga;
    private static final long serialVersionUID = 1L;

    public UsoDaVaga(Vaga vaga, Cliente cliente) {
        this.dataHoraEntrada = LocalDateTime.now();
        this.vaga = vaga;
        this.cliente = cliente;
        this.id = getProxId();
    }
    
    private int getProxId(){
        return proxId++;
    }
    
    public int getId() {
        return this.id;
    }
    
    public LocalDateTime getDataHoraEntrada() {
        return this.dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return this.dataHoraSaida;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }

    private long calcularTempoEstadia() {
        long segundos = Duration.between(this.dataHoraEntrada, this.dataHoraSaida).getSeconds();
        long minutos = segundos/60;
        return minutos;
    }

    public double baixarUsoDaVaga() {
        this.dataHoraSaida = LocalDateTime.now();
        long tempo = calcularTempoEstadia();
        double valor = Vaga.getValorPor15Min() * (tempo / 15);
        if(valor > Vaga.getValorLimite()) {
            return vaga.calcularPrecoVaga(Vaga.getValorLimite());
        }
        return vaga.calcularPrecoVaga(valor);
    }

    public double calcularPrecoEstadia() {
        long tempo = calcularTempoEstadia();
        double valor = Vaga.getValorPor15Min() * (tempo / 15);
        if(valor > Vaga.getValorLimite()) {
            return vaga.calcularPrecoVaga(Vaga.getValorLimite());
        }
        return vaga.calcularPrecoVaga(valor); 
    }
     @Override
    public String toString() {
        return "UsoDaVaga { " +
               "ID: " + id +
               ", Data e Hora de Entrada: " + dataHoraEntrada +
               ", Data e Hora de Saída: " + (dataHoraSaida != null ? dataHoraSaida : "Ainda em uso") +
               ", Cliente: " + cliente +
               " }";
    }
}