/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author T-Gamer
 */
public class UsoDaVagaTest {
    
    public UsoDaVagaTest() {
    }
    
    @Test
    public void testGetVeiculo() {
        Cliente cliente = new Cliente("José Ferreira Rocha", "111.111.111-01", "(31) 99999-9999");
        Veiculo veiculo = new Veiculo("ABC1234", "Fusca", "Wolkswagen", cliente);
        Vaga vaga = new Vaga("A01", true, new LinkedList<UsoDaVaga>());
        UsoDaVaga usoDaVaga = new UsoDaVaga(veiculo, vaga);
        assertEquals(veiculo, usoDaVaga.getVeiculo());
    }

    @Test
    public void testSetVeiculo() {
        Cliente cliente = new Cliente("José Ferreira Rocha", "111.111.111-01", "(31) 99999-9999");
        Veiculo veiculo = new Veiculo("ABC1234", "Fusca", "Wolkswagen", cliente);
        Vaga vaga = new Vaga("A01", true, new LinkedList<UsoDaVaga>());
        UsoDaVaga usoDaVaga = new UsoDaVaga(veiculo, vaga);
        Veiculo veiculo2 = new Veiculo("XYZ9876", "Ferrari", "Ferrari", cliente);
        usoDaVaga.setVeiculo(veiculo2);
        assertEquals(veiculo2, usoDaVaga.getVeiculo());
    }
}
