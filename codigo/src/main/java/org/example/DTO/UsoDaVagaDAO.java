/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.example.model.Cliente;
import org.example.model.UsoDaVaga;
import org.example.model.Vaga;

/**
 *
 * @author Pedro
 */
public class UsoDaVagaDAO {
    
    public void CadastrarUsoDaVaga (UsoDaVaga obj, Vaga vaga) {
        
        String sql = "INSERT INTO ticket (cliente_id, vaga_id, data_entrada) VALUES (?, ?, ?)";
        
        PreparedStatement ps = null;
        Cliente cliente = obj.getCliente();

        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, new ClienteDAO().procurarId(cliente.getCpf()));
            ps.setInt(2, new VagaDAO().procurarId(vaga.getIdentificador(), vaga.getIdEstacionamento()));
            ps.setTimestamp(3, Timestamp.valueOf(obj.getDataHoraEntrada()));
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<UsoDaVaga> PesquisarUsoVagapeloIdVaga(int id) {
        ArrayList<UsoDaVaga> lista = new ArrayList<>();
        
        String sql = "SELECT T.id, T.cliente_id, T.vaga_id, T.data_entrada, T.data_saida, T.tempo_gasto, T.preco "
           + "FROM ticket T WHERE T.vaga_id = ?";
        
        PreparedStatement ps = null;
        Vaga vaga = new VagaDAO().procurarVaga(id);
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Cliente cliente = new ClienteDAO().procurarCliente(rs.getInt("cliente_id"));
                UsoDaVaga obj = new UsoDaVaga();
                Timestamp entrada = rs.getTimestamp("data_entrada");
                Timestamp saida = rs.getTimestamp("data_saida");
                obj.setCliente(cliente);
                obj.setVaga(vaga);
                obj.setId(rs.getInt("id"));
                obj.setDataHoraEntrada(entrada.toLocalDateTime());
                if(saida != null)
                obj.setDataHoraSaida(saida.toLocalDateTime());
                else
                obj.setDataHoraSaida(null);    
                obj.setPreco(rs.getDouble("preco"));
                obj.setTempo(rs.getLong("tempo_gasto"));
                lista.add(obj);
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        
        return lista;
    }
    
    public ArrayList<UsoDaVaga> PesquisarUsoVagapeloIdCliente(int id) {
        ArrayList<UsoDaVaga> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM ticket WHERE cliente_id = ?";
        
        PreparedStatement ps = null;
        Cliente cliente = new ClienteDAO().procurarCliente(id);
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Vaga vaga = new VagaDAO().procurarVaga(rs.getInt("vaga_id"));
                UsoDaVaga obj = new UsoDaVaga();
                Timestamp entrada = rs.getTimestamp("data_entrada");
                Timestamp saida = rs.getTimestamp("data_saida");
                obj.setCliente(cliente);
                obj.setVaga(vaga);
                obj.setId(rs.getInt("id"));
                obj.setDataHoraEntrada(entrada.toLocalDateTime());
                obj.setDataHoraSaida(saida.toLocalDateTime());
                obj.setPreco(rs.getDouble("preco"));
                obj.setTempo(rs.getLong("tempo_gasto"));
                lista.add(obj);
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        
        return lista;
    }
    
    public void atualizarUso(UsoDaVaga obj) {
        
        String sql = "UPDATE ticket SET preco = ?, tempo_gasto = ?, data_saida = ? WHERE vaga_id = ? AND cliente_id = ? AND data_entrada = ?";
        Cliente cliente = obj.getCliente();
        Vaga vaga = obj.getVaga();
        int idCliente = new ClienteDAO().procurarId(cliente.getCpf());
        int idVaga = new VagaDAO().procurarId(vaga.getIdentificador(), idCliente);
        PreparedStatement ps = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setDouble(1, obj.getPreco());
            ps.setLong(2, obj.getTempo());
            ps.setTimestamp(3, Timestamp.valueOf(obj.getDataHoraSaida()));
            ps.setInt(4, idVaga);
            ps.setInt(5, idCliente);
            ps.setTimestamp(6, Timestamp.valueOf(obj.getDataHoraEntrada()));
            
            ps.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
    }
    
    }

