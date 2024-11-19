/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Cliente;
import org.example.model.Estacionamento;
import org.example.model.UsoDaVaga;
import org.example.model.Vaga;


/**
 *
 * @author Pedro
 */
public class Estacionamentos extends AbstractDAO implements Serializable {
    
    private ArrayList<Estacionamento> estacionamentos;
    private static Estacionamentos instancia;
    private static final long serialVersionUID = 1L;
    
    private Estacionamentos() {
        this.estacionamentos = new ArrayList();
    }
    
    public static Estacionamentos getInstancia(){
        if(instancia == null){
            instancia = new Estacionamentos();
            instancia.setEstacionamentos(instancia.ler("estacionamentos.txt"));
        }
        return instancia;
    }
    
    public void addEstacionamento(Estacionamento obj){
        estacionamentos.add(obj);
    }
    
    public void removerEstacionamento(Estacionamento obj){
        estacionamentos.remove(obj);
    }
    
    public void setEstacionamentos(List obj) {
        this.estacionamentos = (ArrayList<Estacionamento>) obj;
    }
     
    public ArrayList<Estacionamento> getEstacionamentos(){
        return this.estacionamentos;
    }
    
    public Estacionamento pesquisarEstacionamento(String nome){
        for (Estacionamento obj : estacionamentos) {
            if(obj.getNome().equalsIgnoreCase(nome))
                return obj;
        }
        return null;
    }
    
    public Vaga pesquisarVagaEstacionamento(String identificador){
        for (Estacionamento obj : estacionamentos) {
            ArrayList<Vaga> vagas = obj.getVagas();
            for(Vaga newobj : vagas) {
                if(newobj.getIdentificador().equalsIgnoreCase(identificador))
                    return newobj;
            }
        }
        return null;
    }
    
    public ArrayList<UsoDaVaga> PesquisarUsosVagaDeClienteEspecifico(Cliente cliente){
        ArrayList<UsoDaVaga> obj = new ArrayList();
        for (Estacionamento estacionamento : estacionamentos) {
            ArrayList<Vaga> vagas = estacionamento.getVagas();
            for(Vaga vaga : vagas) {
                ArrayList<UsoDaVaga> usos = vaga.getUsoDaVaga();
                for(UsoDaVaga uso : usos) {
                    Cliente comp = uso.getCliente();
                    if(cliente.getCpf().equalsIgnoreCase(comp.getCpf())) {
                        obj.add(uso);
                    }
                }    
            }
        }
        if(obj == null)
            return null;
        else
            return obj;
    }
    
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder("Estacionamentos:\n");
    for (Estacionamento obj : estacionamentos) {
        sb.append(obj).append("\n");
    }
    return sb.toString();
}
    
}
