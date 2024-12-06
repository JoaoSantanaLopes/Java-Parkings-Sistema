/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.example.DTO.VeiculoDAO;
import org.example.view.ListaDeCarrosView;

/**
 *
 * @author Pedro
 */
public class ListaDeCarrosController {
    
    private ListaDeCarrosView view;
    
    public ListaDeCarrosController(javax.swing.JDesktopPane tela) {
        view = new ListaDeCarrosView();
        
        tela.add(view);
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        view.GetBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        List<Object[]> ocupacaoData = new VeiculoDAO().listarOcupacaoMedia();
        
        for (Object[] ocupacao : ocupacaoData) {
           DefaultTableModel listaCarros = (DefaultTableModel) view.GetTabelaCarros().getModel();
            listaCarros.addRow(ocupacao); 
        }
        
        view.setVisible(true);
    }
}
