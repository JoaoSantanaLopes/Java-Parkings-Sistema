/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.DTO.EstacionamentoDAO;
import org.example.model.Cliente;
import org.example.model.Estacionamento;
import org.example.model.UsoDaVaga;
import org.example.model.Vaga;
import org.example.view.PerguntaEstacionamentoView;
import org.example.view.ValoresView;

/**
 *
 * @author Pedro
 */
public class ValoresController {
    
    private ValoresView view;
    private PerguntaEstacionamentoView preview;
    
    public ValoresController(javax.swing.JDesktopPane tela) {
        
        this.preview = new PerguntaEstacionamentoView();
                
        tela.add(preview);
        int x = (tela.getWidth() - preview.getWidth()) / 2;
        int y = (tela.getHeight() - preview.getHeight()) / 2;
        preview.setLocation(x, y);
        
        
        preview.getBtnVoltar().addActionListener(e -> {
            preview.dispose();
        });
        
        preview.getBtnProsseguir().addActionListener(e -> {
            ProcurarEstacionamento(tela); 
        });
        
        this.preview.setVisible(true);
    }
    
     private void ProcurarEstacionamento(javax.swing.JDesktopPane tela) {
        String nome = preview.getNomeEstacionamento().getText();
        Estacionamento obj = new EstacionamentoDAO().procurarEstacionamento(nome);
        
        if(obj == null) {
            JOptionPane.showMessageDialog(preview, "Estacionamento não existe!!");  
        }
        else {
            preview.dispose();
            VizualizarView(tela, obj);
            }    
        }

    private void VizualizarView(JDesktopPane tela, Estacionamento obj) {
        this.view = new ValoresView();
        
        tela.add(view);
        int x = (tela.getWidth() - view.getWidth()) / 2;
        int y = (tela.getHeight() - view.getHeight()) / 2;
        view.setLocation(x, y);
        this.view.setVisible(true);
        
        view.getValorTotal().setText(ValorTotal(obj));
        view.getValorMedio().setText(ValorMedio(obj));
        
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
        });
        
        view.getBtnPesquisar().addActionListener(e -> {
            int ano = Integer.valueOf(view.getAno().getText());
            String mes = (String) view.getMeses().getSelectedItem();
            if(!mes.isEmpty()) {
            MostrarValores(ano, mes, obj);
            } else {
                JOptionPane.showMessageDialog(view, "Preencha os dados nas caixas de texto");
            }
        });
    }

    private void MostrarValores(int ano, String mes, Estacionamento obj) {
        Locale locale = new Locale("pt", "Br");
        DefaultTableModel listaRanking = (DefaultTableModel) view.getTabelaRanking().getModel();
        listaRanking.setRowCount(0);
        
        String mesLowerCase = mes.toLowerCase(locale);
        int mesNumerico = 0;
        for (int i = 1; i <= 12; i++) {
            String nomeMes = LocalDate.of(ano, i, 1).getMonth().getDisplayName(TextStyle.FULL, locale).toLowerCase(locale);
            if (nomeMes.equals(mesLowerCase)) {
                mesNumerico = i;
                break;
            }       
        }
        
        LocalDate primeiroDia = LocalDate.of(ano, mesNumerico, 1);
        LocalDate ultimoDia = primeiroDia.withDayOfMonth(primeiroDia.lengthOfMonth());
        view.getValorMensal().setText(ValorMensal(primeiroDia, ultimoDia, obj));
        
        Map<Cliente, Double> clientes = PreencherClientes(obj, primeiroDia, ultimoDia);
        List<Map.Entry<Cliente, Double>> entryList = new ArrayList<>(clientes.entrySet());
        quickSort(entryList, 0, entryList.size() - 1);
        for (Map.Entry<Cliente, Double> entry : entryList) {
            if(entry.getValue() >= 4){
            Object[] dados = {entry.getKey().getNome() ,  entry.getValue()};
            listaRanking.addRow(dados);
            }
        }

    }

    private String ValorTotal(Estacionamento obj) {
        ArrayList<Vaga> vagas = obj.getVagas();
        double valor = 0;
        for(Vaga vaga : vagas) {
            ArrayList<UsoDaVaga> usos = vaga.getUsoDaVaga();
                for(UsoDaVaga uso : usos) {
                    valor += uso.getPreco();
                }
        }
        String formatado = String.format("%.2f", valor);
        return "R$ " + formatado;
    }
    
    private String ValorMedio(Estacionamento obj) {
        ArrayList<Vaga> vagas = obj.getVagas();
        double valor = 0;
        int quantiUsos = 0;
        for(Vaga vaga : vagas) {
            ArrayList<UsoDaVaga> usos = vaga.getUsoDaVaga();
                for(UsoDaVaga uso : usos) {
                    valor += uso.getPreco();
                    quantiUsos++;
                }
        }
        valor /= quantiUsos;
        String formatado = String.format("%.2f", valor);
        return "R$ " + formatado;
    }

    private String ValorMensal(LocalDate dataInicio, LocalDate dataFim, Estacionamento obj) {
        ArrayList<Vaga> vagas = obj.getVagas();
        double valor = 0;
        for(Vaga vaga : vagas) {
            ArrayList<UsoDaVaga> usos = vaga.getUsoDaVaga();
                for(UsoDaVaga uso : usos) {
                    if(uso.getDataHoraSaida() != null){
                    if(!uso.getDataHoraSaida().toLocalDate().isBefore(dataInicio) && !uso.getDataHoraSaida().toLocalDate().isAfter(dataFim)) 
                    valor += uso.getPreco();
                }
                }  
        }
        String formatado = String.format("%.2f", valor);
        if(valor > 0) 
        return "R$ " + formatado;
        else
        return "R$ 0.00";
    }
    
    private Map<Cliente, Double> PreencherClientes(Estacionamento obj, LocalDate dataInicio, LocalDate dataFim) {
        Map<Cliente, Double> clientes = new HashMap();
        ArrayList<Vaga> vagas = obj.getVagas();
        for(Vaga vaga : vagas) {
            ArrayList<UsoDaVaga> usos = vaga.getUsoDaVaga();
            for(UsoDaVaga uso : usos) {
                if(uso.getDataHoraSaida() != null) {
                    if(!uso.getDataHoraSaida().toLocalDate().isBefore(dataInicio) && !uso.getDataHoraSaida().toLocalDate().isAfter(dataFim)) {
                        Cliente temp = uso.getCliente();
                        if(clientes.containsKey(temp)) {
                            double valorAtual = clientes.get(temp);
                            clientes.put(temp, valorAtual + uso.getPreco());
                        } else {
                            clientes.put(temp, uso.getPreco());
                        }
                    }    
                }
            }
        }
        return clientes;
    }
    
    public static void quickSort(List<Map.Entry<Cliente, Double>> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    public static int partition(List<Map.Entry<Cliente, Double>> list, int low, int high) {
        double pivot = list.get(high).getValue(); 
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (list.get(j).getValue() >= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    } 
    
}
