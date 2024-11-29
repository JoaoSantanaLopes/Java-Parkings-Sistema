/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import javax.swing.JOptionPane;
import org.example.DTO.ClienteDAO;
import org.example.DTO.VeiculoDAO;
import org.example.model.Cliente;
import org.example.model.ClienteAnonimo;
import org.example.model.Veiculo;
import org.example.view.CadastrarVeiculoView;
import org.example.view.PerguntaCpfVeiculoView;

/**
 *
 * @author Pedro
 */
public class CadastrarVeiculoController {
    
    private PerguntaCpfVeiculoView view;
    private CadastrarVeiculoView cadastro;

    public CadastrarVeiculoController(javax.swing.JDesktopPane tela) {
        
        this.view = new PerguntaCpfVeiculoView();
        tela.add(view);
        
        //essa codigo gera a tela no meio
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        view.getBtnProsseguir().addActionListener(e -> {
            ProcurarPessoa(tela); 
        });
        
        this.view.getCheckBoxAnonimo().addActionListener((e) -> {
            if (this.view.getCheckBoxAnonimo().isSelected()) {
                view.getCpf().setText("");
                view.getCpf().setEnabled(false);
            } else {
                view.getCpf().setEnabled(true);
        }});
        
        this.view.setVisible(true);
    }
    
    private void ProcurarPessoa(javax.swing.JDesktopPane tela){
        
        Cliente obj;
        if(this.view.getCheckBoxAnonimo().isSelected()){
            obj = ClienteAnonimo.getInstancia();
        }
        else{
            String cpf = view.getCpf().getText().replaceAll("[^\\d]", "");
            obj = new ClienteDAO().procurarCliente(cpf);
        }
           
        if(obj == null) {
            JOptionPane.showMessageDialog(view, "Cliente não existe!!");  
        }
        else {
            view.dispose();
            this.cadastro = new CadastrarVeiculoView();
            tela.add(cadastro);
            
            //essa codigo gera a tela no meio
            int x = (tela.getWidth() - cadastro.getWidth()) / 2;
            int y = (tela.getHeight() - cadastro.getHeight()) / 2;
            cadastro.setLocation(x, y);
            
            cadastro.getBtnVoltar().addActionListener(e -> {
            cadastro.dispose();
            });
            cadastro.getBtnCadastrar().addActionListener(e -> {
            AdicionarCarro(obj);
            cadastro.dispose();
            });
            this.cadastro.setVisible(true);
        }
    }
    
    private void AdicionarCarro(Cliente obj) {
        String placa = cadastro.getPlaca().getText();
        String modelo = cadastro.getModelo().getText();
        String marca = cadastro.getMarca().getText();
        Veiculo veiculo = new Veiculo(placa, modelo, marca);
        new VeiculoDAO().cadastrarVeiculo(veiculo, obj.getCpf());
    }
}
