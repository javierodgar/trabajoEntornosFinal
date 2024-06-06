/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clases;

import java.util.Arrays;
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
public class clientedaoTest {
    
    public clientedaoTest() {
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
     * Test of registroCliente method, of class clientedao.
     */
    @Test
    public void testRegistroCliente() {
        System.out.println("registroCliente");
        cliente cl = new cliente("DNI127", "John", "Doe", "Smith", 1234568890, "123 Main St");
        clientedao instance = new clientedao();

        boolean expResult = true;
        boolean result = instance.registroCliente(cl);
        assertEquals(expResult, result);
    }

    /**
     * Test of listaclientes method, of class clientedao.
     */
    @Test
    public void testListaclientes() {
        System.out.println("listaclientes");
        clientedao instance = new clientedao();
        cliente cl1 = new cliente("444", "John", "Doe", "Smith", 1234567892, "123 Main St");
        cliente cl2 = new cliente("123", "Jane", "Doe", "Smith", 1234567891, "124 Main St");
        instance.registroCliente(cl1);
        instance.registroCliente(cl2);
        List<cliente> expResult = Arrays.asList(cl1, cl2);
        List result = instance.listaclientes();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of borrarcliente method, of class clientedao.
     */
    @Test
    public void testBorrarcliente() {
        System.out.println("borrarcliente");
        clientedao instance = new clientedao();
        cliente cl = new cliente("DNI159", "John", "Doe", "Smith", 1234568890, "123 Main St");
        instance.registroCliente(cl);
        String dni = "DNI159";
        boolean expResult = true;
        boolean result = instance.borrarcliente(dni);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modificarcliente method, of class clientedao.
     */
    @Test
    public void testModificarcliente() {
        System.out.println("modificarcliente");
        clientedao instance = new clientedao();
        
        cliente cl1 = new cliente("DNI423", "John", "Doe", "Smith", 1234567890, "123 Main St");
        instance.registroCliente(cl1);
    
        cliente cl2 = new cliente("DNI423", "John", "Doe", "pepe", 1234567892, "123 Main St");;
        
        boolean expResult = true;
        boolean result = instance.modificarcliente(cl2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of buscarclientepordni method, of class clientedao.
     */
    @Test
    public void testBuscarclientepordni() {
        System.out.println("buscarclientepordni");
        clientedao instance = new clientedao();
        cliente cl = new cliente("0", "John", "Doe", "Smith", 1234567890, "123 Main St");
        instance.registroCliente(cl);
        int dni = 0;
        cliente expResult = cl;
        cliente result = instance.buscarclientepordni(dni);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of vaciarclientes method, of class clientedao.
     */
    @Test
    public void testVaciarclientes() {
        System.out.println("vaciarclientes");
        clientedao instance = new clientedao();
        instance.vaciarclientes();
        
    }
    
}
