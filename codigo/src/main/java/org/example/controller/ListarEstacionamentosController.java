/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package org.example.controller;

import javax.swing.table.DefaultTableModel;
import org.example.DTO.Estacionamentos;
import org.example.model.Estacionamento;
import org.example.view.ListarEstacionamentosView;

/**
 *
 
@author Joao*/
public class ListarEstacionamentosController {

     private Estacionamentos estacionamentos;
        private ListarEstacionamentosView view;

        public ListarEstacionamentosController(javax.swing.JDesktopPane tela) {

        this.view = new ListarEstacionamentosView();
        tela.add(view);
        
        //essa codigo gera a tela no meio
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        this.estacionamentos = estacionamentos.getInstancia();

        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });

        for (Estacionamento obj : estacionamentos.getEstacionamentos()) {
        DefaultTableModel listaEstacionamentos = (DefaultTableModel) view.getTabelaEstacionamentos().getModel();
        Object[] dados = {obj.getNome(),obj.getRua() + ", " + obj.getNumero() + ", " + obj.getBairro(), obj.getVagas().size()};
        listaEstacionamentos.addRow(dados);
        }

        this.view.setVisible(true);
    }
}