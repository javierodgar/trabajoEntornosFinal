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
public class LoginDaoTest {
    
    public LoginDaoTest() {
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
     * Test of log method, of class LoginDao.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        String nombre = "pepe";
        String contraseña = "4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2";
        LoginDao instance = new LoginDao();
        Login_1 expResult = instance.log(nombre, contraseña);
        Login_1 result = instance.log(nombre, contraseña);
        assertEquals(expResult, result);
    }

    /**
     * Test of Encriptar method, of class LoginDao.
     */
    @Test
    public void testEncriptar() {
        System.out.println("Encriptar");
        String password = "root";
        LoginDao instance = new LoginDao();
        String expResult = "4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2";
        String result = instance.Encriptar(password);
        assertEquals(expResult, result);

    }
    
}
