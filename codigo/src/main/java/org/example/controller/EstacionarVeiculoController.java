/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import javax.swing.JOptionPane;
import org.example.DTO.ClienteDAO;
import org.example.DTO.EstacionamentoDAO;
import org.example.DTO.VagaDAO;
import org.example.DTO.VeiculoDAO;
import org.example.model.Cliente;
import org.example.model.ClienteAnonimo;
import org.example.model.Estacionamento;
import org.example.model.Vaga;
import org.example.model.Veiculo;
import org.example.view.EstacionarVeiculoView;

/**
 *
 * @author Pedro
 */
public class EstacionarVeiculoController {
     
    private EstacionarVeiculoView view;
    
    public EstacionarVeiculoController(javax.swing.JDesktopPane tela, String nomeEstacionamento, String id) {
        
        this.view = new EstacionarVeiculoView();
        tela.add(view);
        
        //essa codigo gera a tela no meio
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        view.getIdentificadorVaga().setText(id);
        view.getNomeEstacionamento().setText(nomeEstacionamento);
        
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        view.getBtnEstacionar().addActionListener(e -> {
            Verificação();
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
    
    private void Verificação(){
        Cliente obj;
        int idCliente;
        if(view.getCheckBoxAnonimo().isSelected()){
            obj = ClienteAnonimo.getInstancia();
            idCliente = new ClienteDAO().procurarId(obj.getCpf());
        }
        else{
            String cpf = view.getCpf().getText().replaceAll("[^\\d]", "");
            obj = new ClienteDAO().procurarCliente(cpf);
            idCliente = new ClienteDAO().procurarId(cpf);
        }
    try {
        String nome = view.getNomeEstacionamento().getText();
        Estacionamento obj2 = new EstacionamentoDAO().procurarEstacionamento(nome);
        if (obj2 == null) {
            throw new NullPointerException("Estacionamento não existe!");
        }

        int id = new EstacionamentoDAO().procurarId(nome);

        String placa = view.getPlaca().getText();
        Veiculo obj3 = new VeiculoDAO().pesquisaVeiculoPorPlaca(placa, idCliente);
        if (obj3 == null) {
            throw new NullPointerException("Veículo não existe!");
        }

        String identificador = view.getIdentificadorVaga().getText();
        int idVaga = new VagaDAO().procurarId(identificador, id);
        Vaga obj4 = new VagaDAO().procurarVaga(idVaga);
        if (obj4 == null) {
            throw new NullPointerException("Vaga não existe ou não te pertence!");
        }

        Estacionar(obj, obj2, obj4);

    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(view, e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(view, "Erro inesperado: " + e.getMessage());
    }
    }
   

     
     private void Estacionar(Cliente cliente, Estacionamento estacionamento, Vaga vaga){
         estacionamento.estacionarVeiculo(vaga, cliente);
         JOptionPane.showMessageDialog(view, "Veiculo Estacionado!");
         view.dispose();
     }
}
