/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import org.example.model.VagaVip;

/**
 *
 * @author Pedro
 */
public class VagasVip {
      
    private ArrayList<VagaVip> vagas;
    private static VagasVip instancia;
    
    private VagasVip() {
        this.vagas = new ArrayList();
    }
    
    public static VagasVip getInstancia(){
        if(instancia == null)
            instancia = new VagasVip();
        return instancia;
    }
    
    public void addVaga(VagaVip obj){
        vagas.add(obj);
    }
    
    public void removerVaga(VagaVip obj){
        vagas.remove(obj);
    }
    
    public VagaVip pesquisarVaga(String identificador){
        for (VagaVip obj : vagas) {
            if(obj.getIdentificador().equalsIgnoreCase(identificador))
                return obj;
        }
        return null;
    }
}
