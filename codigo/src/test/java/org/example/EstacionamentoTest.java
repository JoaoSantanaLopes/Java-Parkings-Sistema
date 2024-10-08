/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author T-Gamer
 */
public class EstacionamentoTest {
    
    public EstacionamentoTest() {
    }

    @Test
    public void testGetNome() {
        Map<String, Vaga> vagasMap = new HashMap<String, Vaga>();
        Endereco endereco = new Endereco("11.111-111", "Rua dos Bobos", "Bairro do Toquinho", 0);
        Estacionamento estacionamento = new Estacionamento("Xulambs Parking", endereco, vagasMap);
        assertEquals("Xulambs Parking", estacionamento.getNome());
    }

    @Test
    public void testGetEndereco() {
        Map<String, Vaga> vagasMap = new HashMap<String, Vaga>();
        Endereco endereco = new Endereco("11.111-111", "Rua dos Bobos", "Bairro do Toquinho", 0);
        Estacionamento estacionamento = new Estacionamento("Xulambs Parking", endereco, vagasMap);
        assertEquals(endereco, estacionamento.getEndereco());
    }   
}
