/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import org.example.DTO.AbstractDAO;
import java.util.ArrayList;
import org.example.model.Cliente;

/**
 *
 * @author Pedro
 */
public class Clientes extends AbstractDAO{
    
    private ArrayList<Cliente> clientes;
    private static Clientes instancia;
    
    private Clientes() {
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
    
    public Cliente pesquisarCliente(String cpf){
        for (Cliente obj : clientes) {
            if(obj.getCpf().equalsIgnoreCase(cpf))
                return obj;
        }
        return null;
    }
    
    public String gerarStringGravacao(Cliente obj){
        return obj.getNome() + "\t" + obj.getCpf() + "\t" + obj.getTelefone() + "\n";
    }
}
