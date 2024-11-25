package org.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Duration;

public class UsoDaVaga implements Serializable{
    
    private static int proxId = 1;
    private int id;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private long tempo;
    private double preco;
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

    public long getTempo() {
        return tempo;
    }

    public double getPreco() {
        return preco;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public Vaga getVaga() {
        return this.vaga;
    }

    private long calcularTempoEstadia() {
        long segundos = Duration.between(this.dataHoraEntrada, this.dataHoraSaida).getSeconds();
        this.tempo = segundos;
        return tempo;
    }

    public double baixarUsoDaVaga() {
        this.dataHoraSaida = LocalDateTime.now();
        calcularTempoEstadia();
        double valor = Vaga.getValorPor15Min() * (this.tempo / 15);
        if(valor > Vaga.getValorLimite()) {
            preco = vaga.calcularPrecoVaga(Vaga.getValorLimite());
            return preco;
        }
        preco = vaga.calcularPrecoVaga(valor);
        return preco;
    }


     @Override
    public String toString() {
        return "UsoDaVaga { " +
               "ID: " + id +
               ", Data e Hora de Entrada: " + dataHoraEntrada +
               ", Data e Hora de Saida: " + (dataHoraSaida != null ? dataHoraSaida : "Ainda em uso") +
               ", Cliente: " + cliente +
               " }";
    }
}