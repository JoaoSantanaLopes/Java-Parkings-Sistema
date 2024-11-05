/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import org.example.model.Vaga;

/**
 *
 * @author Pedro
 */
public class Vagas extends AbstractDAO implements Serializable{
    
    private ArrayList<Vaga> vagas;
    private static Vagas instancia;
    
    private Vagas() {
        this.vagas = new ArrayList();
    }
    
    public static Vagas getInstancia(){
        if(instancia == null)
            instancia = new Vagas();
        return instancia;
    }
    
    public void addVaga(Vaga obj){
        vagas.add(obj);
    }
    
    public void removerVaga(Vaga obj){
        vagas.remove(obj);
    }
    
    public Vaga pesquisarVaga(String identificador){
        for (Vaga obj : vagas) {
            if(obj.getIdentificador().equalsIgnoreCase(identificador))
                return obj;
        }
        return null;
    }
}
