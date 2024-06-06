/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clases;

import java.util.List;
import javax.swing.JComboBox;
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
public class productosdaoTest {
    
    
    public productosdaoTest() {
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
     * Test of registrarproductos method, of class productosdao.
     */
    @Test
    public void testRegistrarproductos() {
        System.out.println("registrarproductos");
        proovedor pro = new proovedor("1", "pepe", 0, "!", "1");
        proovedordao prdao = new proovedordao();
        prdao.registrarproovedor(pro);
        productos product = new productos(1, "pera", "verde", 0, 0, 1, 1);
        productosdao instance = new productosdao();
        boolean expResult = true;
        boolean result = instance.registrarproductos(product);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of listaproductos method, of class productosdao.
     */
    @Test
    public void testListaproductos() {
        System.out.println("listaproductos");
        productosdao instance = new productosdao();
        List expResult = null;
        List result = instance.listaproductos();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of consultar_proovedor method, of class productosdao.
     */
    @Test
    public void testConsultar_proovedor() {
        System.out.println("consultar_proovedor");
        JComboBox proovedor = null;
        productosdao instance = new productosdao();
        instance.consultar_proovedor(proovedor);
        
    }

    /**
     * Test of consultar_categorias method, of class productosdao.
     */
    @Test
    public void testConsultar_categorias() {
        System.out.println("consultar_categorias");
        JComboBox categoriasBox = null;
        productosdao instance = new productosdao();
        instance.consultar_categorias(categoriasBox);
        
    }

    /**
     * Test of modifacarpproducto method, of class productosdao.
     */
    @Test
    public void testModifacarpproducto() {
        System.out.println("modifacarpproducto");
        proovedor pro = new proovedor("2", "pepe", 0, "!", "1");
        proovedordao prdao = new proovedordao();
        prdao.registrarproovedor(pro);
        productos product = new productos(1, "pera", "verde", 0, 0, 2, 1);
        productosdao instance = new productosdao();
        instance.registrarproductos(product);
        productos product2 = new productos(1, "peera", "verde", 0, 0, 2, 1);
        boolean expResult = true;
        boolean result = instance.modifacarpproducto(product2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of busacarproductoporid method, of class productosdao.
     */
    @Test
    public void testBusacarproductoporid() {
        System.out.println("busacarproductoporid");
        productos product = new productos(1, "manzanas", "manzanas clasicas, amarillas y deliciosas", 2.29, 129, 1111111111, 1);
        int idproducto = 1;
        productosdao instance = new productosdao();
        productos expResult = product;
        productos result = instance.busacarproductoporid(idproducto);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of borrarproducto method, of class productosdao.
     */
    @Test
    public void testBorrarproducto() {
        System.out.println("borrarproducto");
        String idproducto = "2";
        productosdao instance = new productosdao();
        boolean expResult = true;
        boolean result = instance.borrarproducto(idproducto);
        assertEquals(expResult, result);
        
    }
    
}
