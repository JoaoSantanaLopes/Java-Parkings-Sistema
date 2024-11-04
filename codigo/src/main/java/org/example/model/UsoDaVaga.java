package org.example.model;

import java.time.LocalDateTime;
import java.time.Duration;

public class UsoDaVaga {
    private final LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private Veiculo veiculo;
    private Vaga vaga;

    public UsoDaVaga(Veiculo veiculo, Vaga vaga) {
        this.dataHoraEntrada = LocalDateTime.now();
        this.veiculo =  veiculo;
        this.vaga = vaga;
    }

    public LocalDateTime getDataHoraEntrada() {
        return this.dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
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
}