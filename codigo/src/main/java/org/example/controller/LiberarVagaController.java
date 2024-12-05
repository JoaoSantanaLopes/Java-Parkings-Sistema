/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import Exception.VagaNaoEncontradaException;
import Exception.VagaSemUsoException;
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
    try {
        // Procurando estacionamento e vaga
        Estacionamento estacionamento = new EstacionamentoDAO().procurarEstacionamento(nome);
        int id = new EstacionamentoDAO().procurarId(nome);
        Vaga vaga = new VagaDAO().procurarVaga(identificador, id);

        // Verificando se a vaga foi encontrada
        if (vaga == null) {
            throw new VagaNaoEncontradaException("A vaga com o identificador '" + identificador + "' não foi encontrada no estacionamento '" + nome + "'.");
        }

        // Verificando se a vaga possui usos registrados
        if (vaga.getUsoDaVaga().isEmpty()) {
            throw new VagaSemUsoException("A vaga com o identificador '" + identificador + "' não possui usos registrados.");
        }

        // Processando liberação da vaga
        UsoDaVaga uso = vaga.getUltimo();
        double custo = uso.baixarUsoDaVaga();
        new UsoDaVagaDAO().atualizarUso(uso);
        estacionamento.liberarVaga(vaga.getIdentificador());
        return custo;

    } catch (VagaNaoEncontradaException e) {
        System.err.println("Erro: " + e.getMessage());
        JOptionPane.showMessageDialog(null, e.getMessage());
        return -1.0; // Retorna um valor indicativo de erro

    } catch (VagaSemUsoException e) {
        System.err.println("Erro: " + e.getMessage());
        JOptionPane.showMessageDialog(null, e.getMessage());
        return -1.0; // Retorna um valor indicativo de erro

    } catch (Exception e) {
        // Tratamento para outros erros inesperados
        System.err.println("Erro inesperado: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Erro inesperado ao liberar vaga: " + e.getMessage());
        return -1.0;
    }
}
    
}
        
    
