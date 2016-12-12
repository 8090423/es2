/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2.git;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Titi_
 */
public class Es2GitTest {

    public Es2GitTest() {
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
     * Test of getArab method, of class Es2Git.
     */
    @Test
    public void testGetArab_I() {
        System.out.println("getArab");
        String c = "I";
        int expResult = 1;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }
    

    @Test
    public void testGetArab_X() {
        System.out.println("getArab");
        String c = "X";
        int expResult = 10;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetArab_D() {
        System.out.println("getArab");
        String c = "D";
        int expResult = 500;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }

    
        @Test
    public void testGetArab_V() {
        System.out.println("getArab");
        String c = "V";
        int expResult = 5;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetArab_C() {
        System.out.println("getArab");
        String c = "C";
        int expResult = 100;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetArab_M() {
        System.out.println("getArab");
        String c = "M";
        int expResult = 1000;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetArab_L() {
        System.out.println("getArab");
        String c = "L";
        int expResult = 50;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetArab_invalid() {
        System.out.println("getArab");
        String c = "o";
        int expResult = -1;
        int result = Es2Git.getArab(c);
        assertEquals(expResult, result);

    }
    
    

    
    /**
     * Test of toUpper method, of class Es2Git.
     */
    @Test
    public void testToUpper() {
        System.out.println("toUpper");
        String c = "c";
        String expResult = "C";
        String result = Es2Git.toUpper(c);
        assertEquals(expResult, result);
        
    }

    
    
    
    

}
