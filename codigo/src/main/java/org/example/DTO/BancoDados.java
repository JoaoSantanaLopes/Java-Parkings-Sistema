/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class BancoDados {
    
    private static final String banco = "xulambs";
    
    private static final String usuario = "root";
    
    private static final String senha = "rootroot";
    
    private static String url = "jdbc:mysql://localhost:3306/xulambs";
    
    private static Connection conexao;

    
    public static Connection getConexao() {
        try {
            if(conexao == null) {
            conexao  = DriverManager.getConnection(url, usuario, senha);
            return conexao;
            }
            else {
                return conexao;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void desconectar() {
        
        try {
            conexao.close();
            System.out.println("Conexão Encerrada!");
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
