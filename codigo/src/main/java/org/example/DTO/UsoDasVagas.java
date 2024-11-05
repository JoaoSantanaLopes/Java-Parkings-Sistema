/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.util.ArrayList;
import org.example.model.UsoDaVaga;

/**
 *
 * @author Pedro
 */
public class UsoDasVagas {
    
    private ArrayList<UsoDaVaga> usosDasVagas;
    private static UsoDasVagas instancia;
    
    private UsoDasVagas() {
        this.usosDasVagas = new ArrayList();
    }
    
    public static UsoDasVagas getInstancia(){
        if(instancia == null)
            instancia = new UsoDasVagas();
        return instancia;
    }
    
    public void addUsoDaVaga(UsoDaVaga obj){
        usosDasVagas.add(obj);
    }
    
    public void removerUsoDavaga(UsoDaVaga obj){
        usosDasVagas.remove(obj);
    }
    
    public UsoDaVaga pesquisarUsoDaVaga(int id){
        for (UsoDaVaga obj : usosDasVagas) {
            if(obj.getId() == id)
                return obj;
        }
        return null;
    }
}
