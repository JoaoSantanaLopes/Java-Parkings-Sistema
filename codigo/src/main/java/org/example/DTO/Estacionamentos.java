/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import org.example.model.Estacionamento;

/**
 *
 * @author Pedro
 */
public class Estacionamentos {
    
    private ArrayList<Estacionamento> estacionamentos;
    private static Estacionamentos instancia;
    
    private Estacionamentos() {
        this.estacionamentos = new ArrayList();
    }
    
    public static Estacionamentos getInstancia(){
        if(instancia == null)
            instancia = new Estacionamentos();
        return instancia;
    }
    
    public void addEstacionamento(Estacionamento obj){
        estacionamentos.add(obj);
    }
    
    public void removerEstacionamento(Estacionamento obj){
        estacionamentos.remove(obj);
    }
    
    public Estacionamento pesquisarEstacionamento(String nome){
        for (Estacionamento obj : estacionamentos) {
            if(obj.getNome().equalsIgnoreCase(nome))
                return obj;
        }
        return null;
    }
    
    //public String gerarStringGravacao(Estacionamento obj){
   //     return obj.getNome() + "\t"
   // }
    
}
