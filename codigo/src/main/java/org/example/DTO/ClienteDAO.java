/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.model.Cliente;

/**
 *
 * @author Pedro
 */
public class ClienteDAO {
    
    
    public void cadastrarCliente(Cliente obj) {
        
        String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1,obj.getNome());
            ps.setString(2,obj.getCpf());
            ps.setString(3,obj.getTelefone());
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
    
    public Cliente procurarCliente(String cpf) {
        
        String sql = "SELECT * FROM cliente WHERE cpf=?";
        
        PreparedStatement ps = null;
        Cliente obj = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                obj = new Cliente();
                obj.setCpf(rs.getString("cpf"));
                obj.setNome(rs.getString("nome"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setVeiculos(new VeiculoDAO().pesquisaVeiculoPorId(rs.getInt("id")));
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return obj;
    }
    
    public Cliente procurarCliente(int id) {
        
        String sql = "SELECT * FROM cliente WHERE id=?";
        
        PreparedStatement ps = null;
        Cliente obj = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                obj = new Cliente();
                obj.setCpf(rs.getString("cpf"));
                obj.setNome(rs.getString("nome"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setVeiculos(new VeiculoDAO().pesquisaVeiculoPorId(rs.getInt("id")));
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return obj;
    }
    
    public int procurarId(String cpf) {
        
        String sql = "SELECT * FROM cliente WHERE cpf=?";
        
        PreparedStatement ps = null;
        int id = 0;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id");
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return id;
    }
    
}
