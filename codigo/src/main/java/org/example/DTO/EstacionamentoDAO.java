
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Estacionamento;

/**
 *
 * @author Pedro
 */
public class EstacionamentoDAO {
    
    public void CadastrarEstacionamento (String nome, String rua, String bairro, int numero) {
        
        String sql = "INSERT INTO estacionamento (nome, rua, bairro, numero) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, rua);
            ps.setString(3, bairro);
            ps.setInt(4, numero);
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int procurarId(String nome) {
        
        String sql = "SELECT * FROM estacionamento WHERE nome=?";
        
        PreparedStatement ps = null;
        int id = 0;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id");
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return id;
    }
    
    public Estacionamento procurarEstacionamento(String nome) {
        Estacionamento obj = null;
        
        String sql = "SELECT * FROM estacionamento WHERE nome=?";
        
        PreparedStatement ps = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                
                obj = new Estacionamento();
                obj.setNome(rs.getString("nome"));
                obj.setRua(rs.getString("rua"));
                obj.setBairro(rs.getString("bairro"));
                obj.setNumero(rs.getInt("numero"));
                obj.setVagas(new VagaDAO().procurarVagaPorEstacionamento(rs.getInt("id")));
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return obj;
    }
    
    public List<Estacionamento> procurarTodosEstacionamento() {
        List<Estacionamento> lista = new ArrayList<Estacionamento>();
        
        String sql = "SELECT * FROM estacionamento";
        
        PreparedStatement ps = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);

            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Estacionamento obj = new Estacionamento();
                obj.setNome(rs.getString("nome"));
                obj.setRua(rs.getString("rua"));
                obj.setBairro(rs.getString("bairro"));
                obj.setNumero(rs.getInt("numero"));
                obj.setVagas(new VagaDAO().procurarVagaPorEstacionamento(rs.getInt("id")));
                lista.add(obj);
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return lista;
    }
}
