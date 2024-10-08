/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.example;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author T-Gamer
 */
public class VagaTest {
    
    public VagaTest() {
    }

    @Test
    public void testGetDisponibilidade() {
        Vaga vaga = new Vaga("A01", true, new LinkedList<UsoDaVaga>());
        assertEquals(true, vaga.getDisponibilidade());
    }

    @Test
    public void testSetDisponibilidade() {
        Vaga vaga = new Vaga("A01", true, new LinkedList<UsoDaVaga>());
        vaga.setDisponibilidade(false);
        assertEquals(false, vaga.getDisponibilidade());
    }
}
