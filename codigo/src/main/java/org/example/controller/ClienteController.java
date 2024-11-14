package org.example.controller;

import javax.swing.JOptionPane;
import org.example.DTO.AbstractDAO;
import org.example.DTO.Clientes;
import org.example.model.Cliente;
import org.example.view.CadastrarClienteView;

public class ClienteController {
    
    private CadastrarClienteView view;
    private Clientes clientes;
    private final String endereço = "clientes.txt";
    
    public ClienteController(javax.swing.JDesktopPane tela) {
        
        this.view = new CadastrarClienteView();
        tela.add(view);
        this.clientes = Clientes.getInstancia();
        
        this.view.getBtnCadastrar().addActionListener((e)->{
            addCliente();
            limparCampos();
        });
        
        this.view.getBtnVoltar().addActionListener((e)->{
            sair();
        });
                
        this.view.setVisible(true);
    }
    
    public void addCliente(){
        
        String nome = view.getNomeCliente().getText();
        String cpf = view.getCpf().getText().replaceAll("[^\\d]", "");
        String telefone = view.getTelefone().getText().replaceAll("[^\\d]", "");
        
       Cliente obj = new Cliente(nome, cpf, telefone);
       this.clientes.addCliente(obj);
       this.clientes.gravar(endereço, clientes.getClientes());
       
       
       JOptionPane.showMessageDialog(view, "Cliente Salvo com Sucesso!");  
    }

    private void limparCampos() {
        this.view.getNomeCliente().setText("");
        this.view.getCpf().setText("");
        this.view.getTelefone().setText("");
    }

    private void sair() {
       view.dispose();
    }
}
