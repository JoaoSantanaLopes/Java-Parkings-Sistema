/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.example;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.example.model.Cliente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author T-Gamer
 */
public class ClienteTest {
    
    public ClienteTest() {
    }

    /**
     * Test of getCpf method, of class Cliente.
     */
    @Test
    public void testGetCpf() {
        Cliente cliente = new Cliente("José Ferreira Rocha", "111.111.111-01", "(31) 99999-9999");
        assertEquals("José Ferreira Rocha", cliente.getNome());
    }

    /**
     * Test of getTelefone method, of class Cliente.
     */
    @Test
    public void testGetTelefone() {
        Cliente cliente = new Cliente("José Ferreira Rocha", "111.111.111-01", "(31) 99999-9999");
        assertEquals("(31) 99999-9999", cliente.getTelefone());
    }
}
