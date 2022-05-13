/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sample;

import Comprobaciones.Comprobaciones;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DEV
 */
public class ComprobacionesTest {
    
    public ComprobacionesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of validarDNI method, of class Comprobaciones.
     */
    @Test
    public void testValidarDNI() throws Exception {
        System.out.println("validarDNI");
        String DNI = "";
        Comprobaciones.validarDNI(DNI);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarIBAN method, of class Comprobaciones.
     */
    @Test
    public void testValidarIBAN() throws Exception {
        System.out.println("validarIBAN");
        String IBAN = "";
        Comprobaciones.validarIBAN(IBAN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
