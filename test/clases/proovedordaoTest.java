/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clases;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Javier
 */
public class proovedordaoTest {
    
    public proovedordaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registrarproovedor method, of class proovedordao.
     */
    @Test
    public void testRegistrarproovedor() {
        System.out.println("registrarproovedor");
        proovedor pv = new proovedor("5", "pepe", 0, "123", "1");
        proovedordao instance = new proovedordao();
        boolean expResult = true;
        boolean result = instance.registrarproovedor(pv);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of listarproovedores method, of class proovedordao.
     */
    @Test
    public void testListarproovedores() {
        System.out.println("listarproovedores");
        proovedordao instance = new proovedordao();
        List expResult = instance.listarproovedores();
        List result = instance.listarproovedores();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of borrarproovedores method, of class proovedordao.
     */
    @Test
    public void testBorrarproovedores() {
        System.out.println("borrarproovedores");
        String nif = "5";
        proovedordao instance = new proovedordao();
        boolean expResult = true;
        boolean result = instance.borrarproovedores(nif);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of actualizarproovedores method, of class proovedordao.
     */
    @Test
    public void testActualizarproovedores() {
        System.out.println("actualizarproovedores");
        proovedor pro = new proovedor("50", "pepe", 0, "123", "1");
        proovedor pro2 = new proovedor("50", "pepeepe", 0, "123", "1");
        proovedordao instance = new proovedordao();
        instance.registrarproovedor(pro);
        boolean expResult = true;
        boolean result = instance.actualizarproovedores(pro2);
        assertEquals(expResult, result);
        
    }
    
}
