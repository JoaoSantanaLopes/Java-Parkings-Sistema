/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.DTO.EstacionamentoDAO;
import org.example.model.Estacionamento;
import org.example.model.Vaga;
import org.example.view.ControlarVagasView;
import org.example.view.PerguntaEstacionamentoView;

/**
 *
 * @author Pedro
 */
public class ListarVagasLivresController {
    
    private ControlarVagasView view;
    private PerguntaEstacionamentoView preview;

    public ListarVagasLivresController(javax.swing.JDesktopPane tela) {
        
        this.preview = new PerguntaEstacionamentoView();
        
        tela.add(preview);
        int x = (tela.getWidth() - preview.getWidth()) / 2;
        int y = (tela.getHeight() - preview.getHeight()) / 2;
        preview.setLocation(x, y);
        
        preview.getBtnVoltar().addActionListener(e -> {
            preview.dispose();
        });
        
        preview.getBtnProsseguir().addActionListener(e -> {
            ProcurarEstacionamento(tela); 
        });
        
        this.preview.setVisible(true);
    }

    private void ProcurarEstacionamento(javax.swing.JDesktopPane tela) {
        String nome = preview.getNomeEstacionamento().getText();
        Estacionamento obj = new EstacionamentoDAO().procurarEstacionamento(nome);
        
        if(obj == null) {
            JOptionPane.showMessageDialog(view, "Estacionamento não existe!!");  
        }
        else {
            ListarVagas(tela, obj);
            }    
        }
    
    private void ListarVagas(javax.swing.JDesktopPane tela, Estacionamento obj) {
        this.preview.dispose();
        this.view = new ControlarVagasView();
        tela.add(view);
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        ArrayList<Vaga> vagas = obj.getVagas();
        for(Vaga vaga : vagas) {
            if(vaga.isDisponibilidade() == true) {
                DefaultTableModel listaVagas = (DefaultTableModel) view.getTabelaVagas().getModel();
                Object[] dados = {vaga.getIdentificador(),vaga.getClass().getSimpleName(), vaga.getUsoDaVaga().size()};
                listaVagas.addRow(dados);
            }
        }
        
        view.getTabelaVagas().addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            view.dispose();
            String id = view.getTabelaVagas().getValueAt(view.getTabelaVagas().getSelectedRow(),0).toString();
            EstacionarVeiculoController posview = new EstacionarVeiculoController(tela, obj.getNome(), id);
        }
    }
});
        this.view.setVisible(true);
    }
    }
    
    

