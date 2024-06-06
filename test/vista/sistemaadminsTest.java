/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vista;

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
public class sistemaadminsTest {
    
    public sistemaadminsTest() {
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
     * Test of listarclientes method, of class sistemaadmins.
     */
    @Test
    public void testListarclientes() {
        System.out.println("listarclientes");
        sistemaadmins instance = new sistemaadmins();
        instance.listarclientes();
        
    }

    /**
     * Test of listarproovedores method, of class sistemaadmins.
     */
    @Test
    public void testListarproovedores() {
        System.out.println("listarproovedores");
        sistemaadmins instance = new sistemaadmins();
        instance.listarproovedores();

    }

    /**
     * Test of listarproductos method, of class sistemaadmins.
     */
    @Test
    public void testListarproductos() {
        System.out.println("listarproductos");
        sistemaadmins instance = new sistemaadmins();
        instance.listarproductos();

    }

    /**
     * Test of listarempleados method, of class sistemaadmins.
     */
    @Test
    public void testListarempleados() {
        System.out.println("listarempleados");
        sistemaadmins instance = new sistemaadmins();
        instance.listarempleados();

    }

    /**
     * Test of limpiartabla method, of class sistemaadmins.
     */
    @Test
    public void testLimpiartabla() {
        System.out.println("limpiartabla");
        sistemaadmins instance = new sistemaadmins();
        instance.limpiartabla();

    }

    /**
     * Test of limpiarcliente method, of class sistemaadmins.
     */
    @Test
    public void testLimpiarcliente() {
        System.out.println("limpiarcliente");
        sistemaadmins instance = new sistemaadmins();
        instance.limpiarcliente();

    }

    /**
     * Test of limpiarproovedor method, of class sistemaadmins.
     */
    @Test
    public void testLimpiarproovedor() {
        System.out.println("limpiarproovedor");
        sistemaadmins instance = new sistemaadmins();
        instance.limpiarproovedor();

    }

    /**
     * Test of limpiarproducto method, of class sistemaadmins.
     */
    @Test
    public void testLimpiarproducto() {
        System.out.println("limpiarproducto");
        sistemaadmins instance = new sistemaadmins();
        instance.limpiarproducto();

    }

    /**
     * Test of limpiarventa method, of class sistemaadmins.
     */
    @Test
    public void testLimpiarventa() {
        System.out.println("limpiarventa");
        sistemaadmins instance = new sistemaadmins();
        instance.limpiarventa();

    }


    /**
     * Test of main method, of class sistemaadmins.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        sistemaadmins.main(args);

    }
    
}
