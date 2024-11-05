/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Cliente;
import org.example.model.Veiculo;

/**
 *
 * @author Pedro
 */
public class Clientes extends AbstractDAO implements Serializable {
    
    private ArrayList<Cliente> clientes;
    private static Clientes instancia;
    private static final long serialVersionUID = 1L;
    
    public Clientes() {
        this.clientes = new ArrayList();
    }
    
    public static Clientes getInstancia(){
        if(instancia == null){
            instancia = new Clientes();
            instancia.setClientes(instancia.ler("clientes.txt"));
        }
        return instancia;
    }
    
    public void addCliente(Cliente obj){
        clientes.add(obj);
    }
    
    public void removerCliente(Cliente obj){
        clientes.remove(obj);
        
    }
    
    public ArrayList getClientes() {
        return this.clientes;
    }
    
    private void setClientes(List obj) {
        this.clientes = (ArrayList<Cliente>) obj;
    }
    
    public Cliente pesquisarCliente(String cpf){
        for (Cliente obj : clientes) {
            System.out.print(obj);
            if(obj.getCpf().equalsIgnoreCase(cpf))
                return obj;
        }
        return null;
    }
    
    public Veiculo pesquisarVeiculoCliente(String placa){
        for (Cliente obj : clientes) {
            ArrayList<Veiculo> carros = obj.getVeiculos();
            for(Veiculo newobj : carros){
                if(newobj.getPlaca().equalsIgnoreCase(placa))
                    return newobj;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder("Clientes:\n");
    for (Cliente cliente : clientes) {
        sb.append(cliente).append("\n");
    }
    return sb.toString();
}
    

}
