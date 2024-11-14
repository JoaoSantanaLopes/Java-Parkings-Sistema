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
        
        view.getMenuCadastrarCliente().addActionListener(e ->{
            ClienteController a = new ClienteController(view.getTela());
        });
        
        view.getMenuCadastrarVeiculo().addActionListener(e ->{
            CadastrarVeiculoController b = new CadastrarVeiculoController(view.getTela());
        });
        
        view.getMenuCadastrarEstacionamento().addActionListener(e ->{
            CadastrarEstacionamentoController c = new CadastrarEstacionamentoController(view.getTela());
        });
        
        view.getMenuEstacionarVeiculo().addActionListener(e ->{
            EstacionarVeiculoController d = new EstacionarVeiculoController(view.getTela());
        });
        
        /*
        view.getBtnHistoricoCliente().addActionListener(e ->{
            
        });
        */
        
        view.getMenuLiberarVaga().addActionListener(e ->{
            LiberarVagaController f = new LiberarVagaController(view.getTela());
        });
        
        view.getMenuListarEstacionamentos().addActionListener(e ->{
            ListarEstacionamentosController g = new ListarEstacionamentosController(view.getTela());
        });
        
        /*
        view.getBtnValores().addActionListener(e ->{
            
        });
        */
        
        view.setVisible(true);
    }
    
   
    
}
