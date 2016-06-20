/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranay78.algorithms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pranay
 */
public class MyIntegerTest {
    
    public MyIntegerTest() {
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
     * Test of toString method, of class MyInteger.
     */
    @Test
    public void testToStringMaxInt() {
      System.out.println("toString for Max Int");
          MyInteger instance = new MyInteger(Integer.MAX_VALUE);
        String expResult = "" + Integer.MAX_VALUE;
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }
    
     @Test
    public void testToStringMinInt() {
         System.out.println("toString for Min Int");
        MyInteger instance = new MyInteger(Integer.MIN_VALUE);
        String expResult = "" + Integer.MIN_VALUE;
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }
    
     @Test
    public void testToStringZero() {
        System.out.println("toString for Zero");
        MyInteger instance = new MyInteger(0);
        String expResult = "" + 0;
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testToString125Int() {
        System.out.println("toString for 125");
        MyInteger instance = new MyInteger(125);
        String expResult = "" + 125;
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }
    
     @Test
    public void testToStringNegetive125Int() {
        System.out.println("toString for Negetive 125");
        MyInteger instance = new MyInteger(125);
        String expResult = "" + 125;
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testToString() {
        System.out.println("toString for Integer.toString");
        Integer instance = Integer.MIN_VALUE;
        String expResult = "" + Integer.MIN_VALUE;
        long startTime = System.nanoTime();
        String result = instance.toString();
        long endTime = System.nanoTime();
        System.out.println("algorithims.MyIntegerTest.testToString() " +(endTime - startTime));
        assertEquals(expResult, result);
        
    }
}
