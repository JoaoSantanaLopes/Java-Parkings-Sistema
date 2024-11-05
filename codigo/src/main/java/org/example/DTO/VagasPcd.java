/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.util.ArrayList;
import org.example.model.VagaPCD;

/**
 *
 * @author Pedro
 */
public class VagasPcd {
            
    private ArrayList<VagaPCD> vagas;
    private static VagasPcd instancia;
    
    private VagasPcd() {
        this.vagas = new ArrayList();
    }
    
    public static VagasPcd getInstancia(){
        if(instancia == null)
            instancia = new VagasPcd();
        return instancia;
    }
    
    public void addVaga(VagaPCD obj){
        vagas.add(obj);
    }
    
    public void removerVaga(VagaPCD obj){
        vagas.remove(obj);
    }
    
    public VagaPCD pesquisarVaga(String identificador){
        for (VagaPCD obj : vagas) {
            if(obj.getIdentificador().equalsIgnoreCase(identificador))
                return obj;
        }
        return null;
    }
}
