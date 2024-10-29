/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.example;

import org.example.controller.UsoDaVaga;
import org.example.controller.VagaPCD;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

/**
 *
 * @author T-Gamer
 */
public class VagaPCDTest {
    
    public VagaPCDTest() {
    }

    @Test
    public void testCalcularPrecoVaga() {
        VagaPCD vaga = new VagaPCD("A01", true, new LinkedList<UsoDaVaga>());
        assertEquals(0.87 ,vaga.calcularPrecoVaga(1), 0.0001);
    }
    
}
