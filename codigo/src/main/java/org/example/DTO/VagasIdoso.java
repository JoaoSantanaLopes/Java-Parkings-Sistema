/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import org.example.model.VagaIdoso;

/**
 *
 * @author Pedro
 */
public class VagasIdoso {
        
    private ArrayList<VagaIdoso> vagas;
    private static VagasIdoso instancia;
    
    private VagasIdoso() {
        this.vagas = new ArrayList();
    }
    
    public static VagasIdoso getInstancia(){
        if(instancia == null)
            instancia = new VagasIdoso();
        return instancia;
    }
    
    public void addVaga(VagaIdoso obj){
        vagas.add(obj);
    }
    
    public void removerVaga(VagaIdoso obj){
        vagas.remove(obj);
    }
    
    public VagaIdoso pesquisarVaga(String identificador){
        for (VagaIdoso obj : vagas) {
            if(obj.getIdentificador().equalsIgnoreCase(identificador))
                return obj;
        }
        return null;
    }
}
