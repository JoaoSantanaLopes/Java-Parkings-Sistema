/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.example.model.Veiculo;

/**
 *
 * @author Pedro
 */
public class VeiculoDAO {
    
    public void cadastrarVeiculo(Veiculo obj, String cpf) {
        
        String sql = "INSERT INTO veiculo (cliente_id, placa, modelo, marca) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        int id = new ClienteDAO().procurarId(cpf);
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, obj.getPlaca());
            ps.setString(3, obj.getModelo());
            ps.setString(4, obj.getMarca());
            
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Veiculo> pesquisaVeiculoPorId(int id) {
        
        ArrayList<Veiculo> lista = new ArrayList<>();
        
        String sql = "SELECT V.cliente_id, V.placa, V.modelo, V.marca "
           + "FROM veiculo V WHERE V.cliente_id = ?";

        PreparedStatement ps = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Veiculo obj = new Veiculo(rs.getString("placa"),rs.getString("modelo"),rs.getString("marca"));
                lista.add(obj);
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        
        return lista;
    }
    
    public Veiculo pesquisaVeiculoPorPlaca(String placa, int id) {
        
        Veiculo obj = null;
        
        String sql = "SELECT V.cliente_id, V.placa, V.modelo, V.marca "
           + "FROM veiculo V WHERE V.placa = ? AND V.cliente_id = ?";

        PreparedStatement ps = null;
        
        try {
            ps = BancoDados.getConexao().prepareStatement(sql);
            ps.setString(1, placa);
            ps.setInt(2, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                obj = new Veiculo(rs.getString("placa"),rs.getString("modelo"),rs.getString("marca"));
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        
        return obj;
    }
    
        public void listarVeiculosFrequentes() {
        String sql = """
            SELECT 
                v.placa,
                v.modelo,
                v.marca,
                COUNT(udv.id) AS vezes_utilizadas
            FROM 
                Veiculo v
            JOIN 
                UsoDaVaga udv ON v.id = udv.cliente_id
            GROUP BY 
                v.id, v.placa, v.modelo, v.marca
            ORDER BY 
                vezes_utilizadas DESC
            LIMIT 5;
        """;

        try (Connection conn = BancoDados.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int vezesUtilizadas = rs.getInt("vezes_utilizadas");

                System.out.printf("Placa: %s | Modelo: %s | Marca: %s | Utilizações: %d\n",
                        placa, modelo, marca, vezesUtilizadas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
