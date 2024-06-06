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
public class empleadodaoTest {
    
    public empleadodaoTest() {
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
     * Test of buscarempleadopordni method, of class empleadodao.
     */
    @Test
    public void testBuscarempleadopordni() {
        System.out.println("buscarempleadopordni");
        int dni = 0;
        empleadodao instance = new empleadodao();
        empleado expResult = null;
        empleado result = instance.buscarempleadopordni(dni);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registroempleado method, of class empleadodao.
     */
    @Test
    public void testRegistroempleado() {
        System.out.println("registroempleado");
        empleado emp = new empleado("123", "pepe", "pepe", "pepe", 0, "calle luisa maria", 0, "root", "admin");
        empleadodao instance = new empleadodao();
        
        boolean expResult = true;
        boolean result = instance.registroempleado(emp);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of listarempleados method, of class empleadodao.
     */
    @Test
    public void testListarempleados() {
        System.out.println("listarempleados");
        empleadodao instance = new empleadodao();
        List expResult = null;
        List result = instance.listarempleados();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of borrarempleado method, of class empleadodao.
     */
    @Test
    public void testBorrarempleado() {
        System.out.println("borrarempleado");
        empleado emp = new empleado("123", "pepe", "pepe", "pepe", 0, "calle luisa maria", 0, "root", "admin");
        empleadodao instance = new empleadodao();
        String dni = "123";
        boolean expResult = true;
        boolean result = instance.borrarempleado(dni);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modificarempleado method, of class empleadodao.
     */
    @Test
    public void testModificarempleado() {
        System.out.println("modificarempleado");
        empleado emp = new empleado("123", "pepe", "pepe", "pepe", 0, "calle luisa maria", 0, "root", "admin");
        empleadodao instance = new empleadodao();
        
        instance.registroempleado(emp);
        
        empleado emp2 = new empleado("123", "pepe", "pepe", "pepe", 0, "calle luisa maria", 0, "root", "admin");
        
        boolean expResult = true;
        boolean result = instance.modificarempleado(emp2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of vaciarempleaados method, of class empleadodao.
     */
    @Test
    public void testVaciarempleaados() {
        System.out.println("vaciarempleaados");
        empleadodao instance = new empleadodao();
        instance.vaciarempleaados();
        
    }

    /**
     * Test of Encriptar method, of class empleadodao.
     */
    @Test
    public void testEncriptar() {
        System.out.println("Encriptar");
        String password = "root";
        empleadodao instance = new empleadodao();
        String expResult = "4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2";
        String result = instance.Encriptar(password);
        assertEquals(expResult, result);
       
    }
    
}
