/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.DTO.EstacionamentoDAO;
import org.example.view.ListaDeVagasView;
import org.example.view.PerguntaEstacionamentoView;

/**
 *
 * @author Pedro
 */
public class ListaDeVagasController {
    
    private PerguntaEstacionamentoView preview;
    private ListaDeVagasView view;
    
    public ListaDeVagasController(javax.swing.JDesktopPane tela) {
        
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
        int id = new EstacionamentoDAO().procurarId(nome);
        
        if(id == 0) {
            JOptionPane.showMessageDialog(preview, "Estacionamento não existe!!");  
        }
        else {
            ListarVagas(tela, id);
            }    
        }

    private void ListarVagas(javax.swing.JDesktopPane tela, int id) {
        preview.dispose();
        
        view = new ListaDeVagasView();
        
        tela.add(view);
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        view.GetBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        List<Object[]> ocupacaoData = new EstacionamentoDAO().listarOcupacaoMedia(id);
        
        for (Object[] ocupacao : ocupacaoData) {
           DefaultTableModel listaVagas = (DefaultTableModel) view.GetTabelaVagas().getModel();
                listaVagas.addRow(ocupacao); 
        }
        
        view.setVisible(true);
    }
    
}
