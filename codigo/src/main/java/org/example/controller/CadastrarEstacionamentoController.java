package org.example.controller;

import javax.swing.JOptionPane;
import org.example.DTO.EstacionamentoDAO;
import org.example.model.Estacionamento;
import org.example.view.CadastrarEstacionamentoView;

public class CadastrarEstacionamentoController {
    
    private CadastrarEstacionamentoView view;

    public CadastrarEstacionamentoController(javax.swing.JDesktopPane tela) {
        
        this.view = new CadastrarEstacionamentoView();
        tela.add(view);
        
        //essa codigo gera a tela no meio
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        
        
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
            int normal = Integer.parseInt(view.getQtdVagasNormais().getText()); 
            int idoso = Integer.parseInt(view.getQtdVagasIdoso().getText()); 
            int PCD = Integer.parseInt(view.getQtdVagasPcd().getText()); 
            int Vip = Integer.parseInt(view.getQtdVagasVip().getText());
            String nome = view.getNomeEstacionamento().getText();
            String rua = view.getRua().getText();
            int numero = Integer.parseInt(view.getNumero().getText());
            String bairro = view.getBairro().getText();
            
            new EstacionamentoDAO().CadastrarEstacionamento(nome, rua, bairro, numero);
            int id = new EstacionamentoDAO().procurarId(nome);
            CriarVagaController vagas = new CriarVagaController(normal, idoso, PCD, Vip, id);
            Estacionamento obj = new Estacionamento(nome, rua, bairro, numero, vagas.GerarVagas());
            
            JOptionPane.showMessageDialog(view, "Estacionamento Salvo com Sucesso!");
            view.dispose();
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
