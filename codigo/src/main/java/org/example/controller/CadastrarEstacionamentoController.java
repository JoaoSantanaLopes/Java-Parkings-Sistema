package org.example.controller;

import javax.swing.JOptionPane;
import org.example.DTO.Estacionamentos;
import org.example.model.Estacionamento;
import org.example.view.CadastrarEstacionamentoView;

public class CadastrarEstacionamentoController {
    
    private CadastrarEstacionamentoView view;
    private Estacionamentos estacionamentos;
    private final String endereco = "estacionamentos.txt";

    public CadastrarEstacionamentoController(javax.swing.JDesktopPane tela) {
        
        this.view = new CadastrarEstacionamentoView();
        tela.add(view);
        
        //essa codigo gera a tela no meio
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        this.estacionamentos = Estacionamentos.getInstancia();
        
        this.view.getBtnCadastrar().addActionListener((e)->{
            addEstacionamento();
            limparCampos();
        });
        
         this.view.getBtnVoltar().addActionListener((e)->{
            view.dispose();
        });
         
        this.view.setVisible(true);
    }
    
        private void addEstacionamento() {
            int normal = Integer.valueOf(view.getQtdVagasNormais().getText()); 
            int idoso = Integer.valueOf(view.getQtdVagasIdoso().getText()); 
            int PCD = Integer.valueOf(view.getQtdVagasPcd().getText()); 
            int Vip = Integer.valueOf(view.getQtdVagasVip().getText());
            String nome = view.getNomeEstacionamento().getText();
            String rua = view.getRua().getText();
            int numero = Integer.valueOf(view.getNumero().getText());
            String bairro = view.getBairro().getText();
            
            CriarVagaController vagas = new CriarVagaController(normal, idoso, PCD, Vip);
            Estacionamento obj = new Estacionamento(nome, rua, bairro, numero, vagas.GerarVagas());
            estacionamentos.addEstacionamento(obj);
            estacionamentos.gravar(endereco, estacionamentos.getEstacionamentos());
            
            JOptionPane.showMessageDialog(view, "Estacionamento Salvo com Sucesso!");
    }
    
    
    private void limparCampos() {
        this.view.getNomeEstacionamento().setText("");
        this.view.getRua().setText("");
        this.view.getNumero().setText("");
        this.view.getBairro().setText("");
        this.view.getQtdVagasNormais().setText("");
        this.view.getQtdVagasVip().setText("");
        this.view.getQtdVagasIdoso().setText("");
        this.view.getQtdVagasPcd().setText("");
    }

}
