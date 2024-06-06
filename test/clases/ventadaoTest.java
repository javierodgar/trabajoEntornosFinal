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
public class ventadaoTest {
    
    public ventadaoTest() {
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
     * Test of registrarventa method, of class ventadao.
     */
    @Test
    public void testRegistrarventa() {
        System.out.println("registrarventa");
        venta vt = new venta();
        vt.setDnicliente("22333412");
        vt.setDniempleado("12312323");
        ventadao instance = new ventadao();
        int expResult = 0;
        int result = instance.registrarventa(vt);
        assertEquals(expResult, result);

    }

    /**
     * Test of registrarlineasfactura method, of class ventadao.
     */
    @Test
    public void testRegistrarlineasfactura() {
        System.out.println("registrarlineasfactura");
        lineasfactura linea = new lineasfactura(1, 4, 1, 10);
        ventadao instance = new ventadao();
        int expResult = 0;
        int result = instance.registrarlineasfactura(linea);
        assertEquals(expResult, result);

    }

    /**
     * Test of maxidventa method, of class ventadao.
     * es necesario comprobar el id maximo de venta en la bas de datos y sumarle 1
     * este id le colocaremos en expresult, en el primer uso de este test con los datos
     * facilitados para la base de datos este sera el numero 4
     */
    @Test
    public void testMaxidventa() {
        System.out.println("maxidventa");
        ventadao instance = new ventadao();
        int expResult = 4;
        int result = instance.maxidventa();
        assertEquals(expResult, result);

    }

    /**
     * Test of listarventas method, of class ventadao.
     */
    @Test
    public void testListarventas() {
        System.out.println("listarventas");
        ventadao instance = new ventadao();
        List expResult = null;
        List result = instance.listarventas();
        assertEquals(expResult, result);

    }

    /**
     * Test of refrescarstock method, of class ventadao.
     */
    @Test
    public void testRefrescarstock() {
        System.out.println("refrescarstock");
        int stk = 10;
        int idproducto = 1;
        ventadao instance = new ventadao();
        boolean expResult = true;
        boolean result = instance.refrescarstock(stk, idproducto);
        assertEquals(expResult, result);

    }
    
}
