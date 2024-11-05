/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Cliente;

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
        if(instancia == null)
            instancia = new Clientes();
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
    
    public void setClientes(List obj) {
        this.clientes = (ArrayList<Cliente>) obj;
    }
    
    public Cliente pesquisarCliente(String cpf){
        for (Cliente obj : clientes) {
            if(obj.getCpf().equalsIgnoreCase(cpf))
                return obj;
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
