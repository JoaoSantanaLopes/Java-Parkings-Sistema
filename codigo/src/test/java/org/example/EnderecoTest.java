/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author T-Gamer
 */
public class EnderecoTest {
    
    public EnderecoTest() {
    }

    @Test
    public void testGetCep() {
        Endereco endereco = new Endereco("11.111-111", "Rua dos Bobos", "Bairro do Toquinho", 0);
        assertEquals("11.111-111", endereco.getCep());
    }

    @Test
    public void testGetRua() {
        Endereco endereco = new Endereco("11.111-111", "Rua dos Bobos", "Bairro do Toquinho", 0);
        assertEquals("Rua dos Bobos", endereco.getRua());
    }
}
