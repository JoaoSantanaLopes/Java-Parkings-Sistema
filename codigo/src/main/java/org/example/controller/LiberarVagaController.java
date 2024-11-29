/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.example.DTO.EstacionamentoDAO;
import org.example.DTO.UsoDaVagaDAO;
import org.example.DTO.VagaDAO;
import org.example.model.Estacionamento;
import org.example.model.UsoDaVaga;
import org.example.model.Vaga;

/**
 *
 * @author Pedro
 */
public class LiberarVagaController {

    public LiberarVagaController(String nome, String id, JFrame view) {
        
        double custo = LiberarVaga(nome, id);
        JOptionPane.showMessageDialog(view, "Valor a ser pago: " + custo);   
    }

    private double LiberarVaga(String nome, String identificador) {
        
        Estacionamento estacionamento = new EstacionamentoDAO().procurarEstacionamento(nome);
        int id = new EstacionamentoDAO().procurarId(nome);
        Vaga vaga = new VagaDAO().procurarVaga(identificador, id);
                
        if (vaga == null) {
            throw new IllegalArgumentException("A vaga com o ID especificado não foi encontrada.");
        }

        if (vaga.getUsoDaVaga().isEmpty()) {
            throw new IllegalStateException("A vaga selecionada não possui usos registrados.");
        }
        
        UsoDaVaga uso = vaga.getUltimo();
        double custo = uso.baixarUsoDaVaga();
        new UsoDaVagaDAO().atualizarUso(uso);
        estacionamento.liberarVaga(vaga.getIdentificador());
        return custo;
}
    
}
        
    
