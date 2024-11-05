/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import javax.swing.JOptionPane;
import org.example.DTO.Clientes;
import org.example.model.Cliente;
import org.example.model.Veiculo;
import org.example.view.CadastrarVeiculoView;
import org.example.view.PerguntaCpfVeiculoView;

/**
 *
 * @author Pedro
 */
public class CadastrarVeiculoController {
    
    private Clientes clientes;
    private PerguntaCpfVeiculoView view;
    private CadastrarVeiculoView cadastro;
    private final String endereço = "clientes.txt";

    public CadastrarVeiculoController() {
        
        this.view = new PerguntaCpfVeiculoView(new javax.swing.JFrame(), true);
        
        this.clientes = Clientes.getInstancia();
        
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        view.getBtnProsseguir().addActionListener(e -> {
            ProcurarPessoa();
        });
        
        this.view.setVisible(true);
    }
    
    private void ProcurarPessoa(){
        String cpf = view.getCpf().getText().replaceAll("[^\\d]", "");
        Cliente obj = clientes.pesquisarCliente(cpf);
        if(obj == null) {
            JOptionPane.showMessageDialog(view, "Cliente não existe!!");  
        }
        else {
            view.dispose();
            this.cadastro = new CadastrarVeiculoView(new javax.swing.JFrame(), true);
            this.cadastro.setVisible(true);
            AdicionarCarro(obj);
        }
    }
    
    private void AdicionarCarro(Cliente obj) {
        String placa = cadastro.getPlaca().getText();
        String modelo = cadastro.getModelo().getText();
        String marca = cadastro.getMarca().getText();
        this.clientes.removerCliente(obj);
        Veiculo veiculo = new Veiculo(placa, modelo, marca);
        obj.adicionarVeiculo(veiculo);
        clientes.addCliente(obj);
        this.clientes.gravar(endereço, clientes.getClientes());
    }
}
