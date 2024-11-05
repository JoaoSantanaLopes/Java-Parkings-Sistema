/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.util.ArrayList;
import org.example.model.Endereco;

/**
 *
 * @author Pedro
 */
public class Enderecos {
        private ArrayList<Endereco> enderecos;
    private static Enderecos instancia;
    
    private Enderecos() {
        this.enderecos = new ArrayList();
    }
    
    public static Enderecos getInstancia(){
        if(instancia == null)
            instancia = new Enderecos();
        return instancia;
    }
    
    public void addCliente(Endereco obj){
        enderecos.add(obj);
    }
    
    public void removerCliente(Endereco obj){
        enderecos.remove(obj);
    }
    
    public Endereco pesquisarCliente(String cep){
        for (Endereco obj : enderecos) {
            if(obj.getCep().equalsIgnoreCase(cep))
                return obj;
        }
        return null;
    }
}
