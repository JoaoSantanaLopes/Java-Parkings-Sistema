/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import org.example.view.JMainView;

/**
 *
 * @author Pedro
 */
public class MainController {
    
    private JMainView view;

    public MainController() {
        this.view = new JMainView();
        
        view.getBtnCadastrarCliente().addActionListener(e ->{
            ClienteController a = new ClienteController();
        });
        
        view.getBtnCadastrarVeiculo().addActionListener(e ->{
            CadastrarVeiculoController b = new CadastrarVeiculoController();
        });
        
        view.getBtnCadastrarEstacionamento().addActionListener(e ->{
            CadastrarEstacionamentoController c = new CadastrarEstacionamentoController();
        });
        
        view.getBtnEstacionarVeiculo().addActionListener(e ->{
            EstacionarVeiculoController d = new EstacionarVeiculoController();
        });
        
        view.getBtnHistoricoCliente().addActionListener(e ->{
            
        });
        
        view.getBtnLiberarVaga().addActionListener(e ->{
            
        });
        
        view.getBtnListarEstacionamentos().addActionListener(e ->{
            
        });
        
        view.getBtnValores().addActionListener(e ->{
            
        });

        view.setVisible(true);
    }
    
   
    
}
