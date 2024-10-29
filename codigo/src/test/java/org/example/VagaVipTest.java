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
public class VagaVipTest {
    
    public VagaVipTest() {
    }

    @Test
    public void testCalcularPrecoVaga() {
        VagaVip vaga = new VagaVip("A01", true, new LinkedList<UsoDaVaga>());
        assertEquals(1.2 ,vaga.calcularPrecoVaga(1), 0.0001);
    }
    
}
