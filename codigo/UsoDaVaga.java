/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labzinho;

/**
 *
 * @author Pedro
 */
public class UsoDaVaga {
    private String dataHoraEntrada;
    private String dataHoraSaida;
    private Veiculo veiculo;
    public UsoDaVaga(String dataHoraEntrada,String dataHoraSaida, Veiculo veiculo) {
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.veiculo =  veiculo;
    }
    public String getDataHoraEntrada() {
        return this.dataHoraEntrada;
    }
    
    public void setDataHoraEntrada(String dataHora) {
       this.dataHoraEntrada = dataHora;
    }
   
    public String getDataHoraSaida() {
        return this.dataHoraSaida;
    }
    public void setDataHoraSaida(String dataHora) {
       this.dataHoraSaida = dataHora;
    }
    public Veiculo getVeiculo() {
        return this.veiculo;
    }
    public void setVeiculo(Veiculo carro) {
        this.veiculo = carro;
    }
}
