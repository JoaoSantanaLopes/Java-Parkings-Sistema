/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import org.example.model.Veiculo;

/**
 *
 * @author Pedro
 */
public class Veiculos {
          
    private ArrayList<Veiculo> veiculos;
    private static Veiculos instancia;
    
    private Veiculos() {
        this.veiculos = new ArrayList();
    }
    
    public static Veiculos getInstancia(){
        if(instancia == null)
            instancia = new Veiculos();
        return instancia;
    }
    
    public void addVaga(Veiculo obj){
        veiculos.add(obj);
    }
    
    public void removerVaga(Veiculo obj){
        veiculos.remove(obj);
    }
    
    public Veiculo pesquisarVaga(String placa){
        for (Veiculo obj : veiculos) {
            if(obj.getPlaca().equalsIgnoreCase(placa))
                return obj;
        }
        return null;
    }
}
