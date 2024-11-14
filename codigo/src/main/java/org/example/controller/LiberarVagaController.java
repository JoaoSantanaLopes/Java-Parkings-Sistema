/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

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
    private LiberarVagaView view;
    private final String endereco = "estacionamentos.txt";

    public LiberarVagaController(javax.swing.JDesktopPane tela) {
        
        view = new LiberarVagaView();
        tela.add(view);    
        this.clientes = Clientes.getInstancia();
        this.estacionamentos = Estacionamentos.getInstancia();
        
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        view.getBtnLiberarVaga().addActionListener(e -> {
            Verificação();
        });
        
        this.view.setVisible(true);
    }
    
    private void Verificação(){
        String nome = view.getNome().getText();
        Estacionamento obj = estacionamentos.pesquisarEstacionamento(nome);
        
        String identificador = view.getIndentificadorVaga().getText();
        Vaga obj2 = estacionamentos.pesquisarVagaEstacionamento(identificador);
        
        if(obj == null) {
            JOptionPane.showMessageDialog(view, "Estacionamento não existe!!");
        }
        else if(obj2 == null){
            JOptionPane.showMessageDialog(view, "Vaga não existe!!");   
        }
        else {
            LiberarVaga(obj, obj2);
        }
}

    private void LiberarVaga(Estacionamento estacionamento, Vaga vaga) {
        estacionamentos.removerEstacionamento(estacionamento);
        UsoDaVaga uso = vaga.getUltimo();
        double custo = uso.baixarUsoDaVaga();
        estacionamento.liberarVaga(vaga.getIdentificador());
        estacionamentos.addEstacionamento(estacionamento);
        estacionamentos.gravar(endereco, estacionamentos.getEstacionamentos());
        
        JOptionPane.showMessageDialog(view, "Valor a ser pago:" + custo);   
    }
        
    }
