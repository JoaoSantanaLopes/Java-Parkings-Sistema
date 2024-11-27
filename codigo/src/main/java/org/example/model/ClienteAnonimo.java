/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

import java.io.Serializable;

/**
 *
 * @author Joao
 */
public class ClienteAnonimo extends Cliente implements Serializable{
    private static ClienteAnonimo instancia;
    
    private ClienteAnonimo() {
        super("Anônimo", "00000000000", "00900000000");
    }
    
    public static ClienteAnonimo getInstancia() {
        if (instancia == null) {
            instancia = new ClienteAnonimo();
        }
        return instancia;
    }
}
