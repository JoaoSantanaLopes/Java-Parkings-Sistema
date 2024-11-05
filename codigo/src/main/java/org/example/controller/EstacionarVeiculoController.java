/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import javax.swing.JOptionPane;
import org.example.DTO.Clientes;
import org.example.DTO.Estacionamentos;
import org.example.model.Cliente;
import org.example.model.Estacionamento;
import org.example.model.Vaga;
import org.example.model.Veiculo;
import org.example.view.EstacionarVeiculoView;

/**
 *
 * @author Pedro
 */
public class EstacionarVeiculoController {
     
    private Clientes clientes;
    private Estacionamentos estacionamentos;
    private EstacionarVeiculoView view;
    private final String endereco = "estacionamentos.txt";
    
    public EstacionarVeiculoController() {
        
        this.view = new EstacionarVeiculoView(new javax.swing.JFrame(), true);
        
        this.clientes = Clientes.getInstancia();
        this.estacionamentos = Estacionamentos.getInstancia();
        
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        view.getBtnEstacionar().addActionListener(e -> {
            Verificação();
        });
        
        this.view.setVisible(true);
    }
    
    private void Verificação(){
        String cpf = view.getCpf().getText().replaceAll("[^\\d]", "");
        Cliente obj = clientes.pesquisarCliente(cpf);
        
        String nome = view.getNomeEstacionamento().getText();
        Estacionamento obj2 = estacionamentos.pesquisarEstacionamento(nome);
        
        String placa = view.getPlaca().getText();
        Veiculo obj3 = clientes.pesquisarVeiculoCliente(placa);
        
        String identificador = view.getIdentificadorVaga().getText();
        Vaga obj4 = estacionamentos.pesquisarVagaEstacionamento(identificador);
        
        if(obj == null) {
            JOptionPane.showMessageDialog(view, "Cliente não existe!!");
        }
        else if(obj2 == null){
            JOptionPane.showMessageDialog(view, "Estacionamento não existe!!");   
        }
        else if(obj3 == null){
            JOptionPane.showMessageDialog(view, "Veículo não existe!!");
        }
        else if(obj4 == null){
            JOptionPane.showMessageDialog(view, "Vaga não existe!!");
        }else {
            Estacionar(obj, obj2, obj3, obj4);
        }
    }
   

     
     private void Estacionar(Cliente cliente, Estacionamento estacionamento, Veiculo carro, Vaga vaga){
         estacionamentos.removerEstacionamento(estacionamento);
         estacionamento.estacionarVeiculo(vaga.getIdentificador(), carro, cliente);
         estacionamentos.addEstacionamento(estacionamento);
         estacionamentos.gravar(endereco, estacionamentos.getEstacionamentos());
         JOptionPane.showMessageDialog(view, "Veiculo Estacionado!");  
     }
}
