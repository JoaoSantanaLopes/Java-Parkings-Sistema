/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.DTO.Clientes;
import org.example.DTO.Estacionamentos;
import org.example.model.Cliente;
import org.example.model.UsoDaVaga;
import org.example.model.Vaga;
import org.example.view.HistoricoClienteView;
import org.example.view.PerguntaCpfView;

/**
 *
 * @author Pedro
 */
public class HistoricoUsuarioController {
    private Clientes clientes;
    private Estacionamentos estacionamentos;
    private PerguntaCpfView preview;
    private HistoricoClienteView view;

    public HistoricoUsuarioController(javax.swing.JDesktopPane tela) {
        clientes = Clientes.getInstancia();
        estacionamentos = Estacionamentos.getInstancia();
        
        preview = new PerguntaCpfView();
        tela.add(preview);
        int x = (tela.getWidth() - preview.getWidth()) / 2;
        int y = (tela.getHeight() - preview.getHeight()) / 2;
        preview.setLocation(x, y);
        
        preview.getBtnProsseguir().addActionListener((e)->{
            procuraCliente(tela);
            this.preview.getCpf().setText("");
        });
         preview.getBtnVoltar().addActionListener((e)->{
            preview.dispose();
        });
        
        preview.setVisible(true);
    }
    
    private void procuraCliente(javax.swing.JDesktopPane tela) {
        String cpf = preview.getCpf().getText().replaceAll("[^\\d]", "");;
        Cliente obj = this.clientes.pesquisarCliente(cpf);
        if(obj == null){
            JOptionPane.showMessageDialog(preview, "Cliente não encontrado!");
        }
        else{
            preview.dispose();
            historicoCliente(obj, tela);
        }
    }
    
    private void historicoCliente(Cliente cliente, javax.swing.JDesktopPane tela) {
        this.view = new HistoricoClienteView();
        tela.add(view);
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        ArrayList<UsoDaVaga> usos = this.estacionamentos.PesquisarUsosVagaDeClienteEspecifico(cliente);
        for(UsoDaVaga obj : usos) {
        DefaultTableModel listaUsos = (DefaultTableModel) view.getTabelaHistorico().getModel();
        Vaga vaga = obj.getVaga();
        Object[] dados = {vaga.getIdentificador(), obj.calcularTempoEstadia() + "minutos", obj.getDataHoraEntrada().toLocalDate() , obj.baixarUsoDaVaga()};
            System.out.println("chegou3");
        listaUsos.addRow(dados);
        }
        
        view.setVisible(true);
    }
}
