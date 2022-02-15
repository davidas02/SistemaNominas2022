/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author daw1
 */
public class EmpleadoEventualTest {
    
    public EmpleadoEventualTest() {
    }

    /**
     * Test of ingresos method, of class EmpleadoEventual.
     */
    @Test
    public void testIngresos() {
        System.out.println("ingresos");
        EmpleadoEventual instance = new EmpleadoEventual("21742104C","David", 10, 10);
        float expResult = 100.0F;
        float result = instance.ingresos();
        assertEquals(expResult, result, 0.0);
        
    }
    
}
