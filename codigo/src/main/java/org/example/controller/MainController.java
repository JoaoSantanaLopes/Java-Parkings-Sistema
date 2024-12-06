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
            CadastrarClienteController a = new CadastrarClienteController(view.getTela());
        });
        
        view.getMenuCadastrarVeiculo().addActionListener(e ->{
            CadastrarVeiculoController b = new CadastrarVeiculoController(view.getTela());
        });
        
        view.getMenuCadastrarEstacionamento().addActionListener(e ->{
            CadastrarEstacionamentoController c = new CadastrarEstacionamentoController(view.getTela());
        });
        
        view.getMenuEstacionarVeiculo().addActionListener(e ->{
            ListarVagasLivresController d = new ListarVagasLivresController(view.getTela());
        });
        
        
        view.getMenuHistoricoCliente().addActionListener(e ->{
            HistoricoUsuarioController ef = new HistoricoUsuarioController(view.getTela());
        });
        
        view.getMenuLiberarVaga().addActionListener(e ->{
            ListarVagasOcupadasController g = new ListarVagasOcupadasController(view.getTela(), view);
        });
        
        view.getMenuListarEstacionamentos().addActionListener(e ->{
            ListarEstacionamentosController h = new ListarEstacionamentosController(view.getTela());
        });
        
        view.getMenuValores().addActionListener(e ->{
            ValoresController i = new ValoresController(view.getTela());
        });
        
        view.getMenuListarVagas().addActionListener(e ->{
           ListaDeVagasController j = new ListaDeVagasController(view.getTela());
        });
        
        view.getMenuListarCarros().addActionListener(e ->{
           ListaDeCarrosController j = new ListaDeCarrosController(view.getTela());
        });
        
        view.setVisible(true);
    }
    
   
    
}
