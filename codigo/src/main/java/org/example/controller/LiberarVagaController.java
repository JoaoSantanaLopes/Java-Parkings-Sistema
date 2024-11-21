/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.example.DTO.Clientes;
import org.example.DTO.Estacionamentos;
import org.example.model.Estacionamento;
import org.example.model.UsoDaVaga;
import org.example.model.Vaga;
import org.example.view.*;

/**
 *
 * @author Pedro
 */
public class LiberarVagaController {
    private Clientes clientes;
    private Estacionamentos estacionamentos;
    private final String endereco = "estacionamentos.txt";

    public LiberarVagaController(String nome, String id, JFrame view) {
        
        this.clientes = Clientes.getInstancia();
        this.estacionamentos = Estacionamentos.getInstancia();
        double custo = LiberarVaga(nome, id);
        JOptionPane.showMessageDialog(view, "Valor a ser pago:" + custo);   
    }

    private double LiberarVaga(String nome, String id) {
        
        Estacionamento estacionamento = estacionamentos.pesquisarEstacionamento(nome);
        Vaga vaga = estacionamentos.pesquisarVagaEstacionamento(id);
        
        estacionamentos.removerEstacionamento(estacionamento);
        UsoDaVaga uso = vaga.getUltimo();
        double custo = uso.baixarUsoDaVaga();
        estacionamento.liberarVaga(vaga.getIdentificador());
        estacionamentos.addEstacionamento(estacionamento);
        estacionamentos.gravar(endereco, estacionamentos.getEstacionamentos());
        return custo;
    }
        
    }
