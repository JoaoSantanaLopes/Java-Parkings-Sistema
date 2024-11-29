/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.example.model.Cliente;
import org.example.model.Vaga;
import org.example.model.VagaIdoso;
import org.example.model.VagaPCD;
import org.example.model.VagaVip;

/**
 *
 * @author Pedro
 */
public class VagaDAO {
    
    public void CadastrarVaga(Vaga obj) {
        
        String sql = "INSERT INTO vaga (estacionamento_id, identificador, disponibilidade, tipo_vaga) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        String tipo = obj.getClass().getSimpleName();
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, obj.getIdEstacionamento());
            ps.setString(2, obj.getIdentificador());
            ps.setBoolean(3, obj.isDisponibilidade());
            if("VagaIdoso".equals(tipo)) {
                ps.setString(4, "idoso");
            }
            else if("VagaVip".equals(tipo)) {
                ps.setString(4, "vip");
            }
            else if("VagaPCD".equals(tipo)) {
                ps.setString(4, "pcd");
            }
            else if("Vaga".equals(tipo))
            ps.setString(4, "normal");
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int procurarId(String identificador, int codEstacionamento) {
        String sql = "SELECT * FROM vaga WHERE identificador=? AND estacionamento_id=?";
        
        PreparedStatement ps = null;
        int id = 0;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, identificador);
            ps.setInt(2, codEstacionamento);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id");
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return id;
    }
    
    public Vaga procurarVaga(int id) {
        String sql = "SELECT * FROM vaga WHERE id=?";
        
        PreparedStatement ps = null;
        Vaga obj = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                if("normal".equals(rs.getString("tipo_vaga"))) {
                    obj = new Vaga();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(null);
                }
                else if("idoso".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaIdoso();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(null);
                }
                else if("pcd".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaPCD();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(null);
                }
                else if("vip".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaVip();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(null);
                }
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return obj;
    }
    
        public Vaga procurarVaga(String identificador, int codEstacionamento) {
        String sql = "SELECT * FROM vaga WHERE identificador=? AND estacionamento_id=?";
        
        PreparedStatement ps = null;
        Vaga obj = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, identificador);
            ps.setInt(2, codEstacionamento);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                if("normal".equals(rs.getString("tipo_vaga"))) {
                    obj = new Vaga();
                    obj.setIdEstacionamento(codEstacionamento);
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
                else if("idoso".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaIdoso();
                    obj.setIdEstacionamento(codEstacionamento);
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
                else if("pcd".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaPCD();
                    obj.setIdEstacionamento(codEstacionamento);
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
                else if("vip".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaVip();
                    obj.setIdEstacionamento(codEstacionamento);
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return obj;
    }
    
    public Map<String, Vaga> procurarVagaPorEstacionamento(int id) {
        Map<String, Vaga> map = new HashMap<String, Vaga>();
        
        String sql = "SELECT * FROM vaga WHERE estacionamento_id=?";
        
        PreparedStatement ps = null;
        
                try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Vaga obj = null;
                if("normal".equals(rs.getString("tipo_vaga"))) {
                    obj = new Vaga();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
                else if("idoso".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaIdoso();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
                else if("pcd".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaPCD();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
                else if("vip".equals(rs.getString("tipo_vaga"))) {
                    obj = new VagaVip();
                    obj.setIdEstacionamento(rs.getInt("estacionamento_id"));
                    obj.setIdentificador(rs.getString("identificador"));
                    obj.setDisponibilidade(rs.getBoolean("disponibilidade"));
                    obj.setUsoDaVaga(new UsoDaVagaDAO().PesquisarUsoVagapeloIdVaga(rs.getInt("id")));
                }
                map.put(obj.getIdentificador(), obj);
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return map;
    }
    
    public void atualizarVaga(String identificador, int codEstacionamento, boolean disponibilidade) {
        
        String sql = "UPDATE vaga SET disponibilidade = ? WHERE identificador = ? AND estacionamento_id = ?";
        
        PreparedStatement ps = null;
        
       try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setBoolean(1, disponibilidade);
            ps.setString(2, identificador);
            ps.setInt(3, codEstacionamento);
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
}

