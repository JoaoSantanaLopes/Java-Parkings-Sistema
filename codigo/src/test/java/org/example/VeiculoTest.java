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
public class VeiculoTest {
    
    public VeiculoTest() {
    }

    @Test
    public void testGetPlaca() {
        Cliente cliente = new Cliente("José Ferreira Rocha", "111.111.111-01", "(31) 99999-9999");
        Veiculo veiculo = new Veiculo("ABC1234", "Fusca", "Wolkswagen", cliente);
        assertEquals("ABC1234", veiculo.getPlaca());    
    }

    @Test
    public void testGetDono() {
        Cliente cliente = new Cliente("José Ferreira Rocha", "111.111.111-01", "(31) 99999-9999");
        Veiculo veiculo = new Veiculo("ABC1234", "Fusca", "Wolkswagen", cliente);
        assertEquals(cliente, veiculo.getDono()); 
    }
    
}
