/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DESCRIPTION NEEDED
 */
public class DurationHandlerTest {
    
    public DurationHandlerTest() {
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
     * Test of formatDuration method, of class DurationHandler.
     */
    @Test
    public void testFormatDuration() {
        System.out.println("Testing the duration handler\n");
        DurationHandler instance = new DurationHandler(0,1,0);      // PT6H30M43S
        System.out.println("Original string: " + instance.getUnformattedString());
        String expResult = "00:02:43";
        String result = instance.formatDuration();
        System.out.println("Final String: " + instance.formatDuration());
        assertEquals(expResult, result);
    }
    

    
    @Test
    public void testFormatDurationMinutes() {

        DurationHandler instance = new DurationHandler(245);
        
        String expResult = "00:04:05"; // Or maybe 04:05
        String result = instance.formatDuration();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFormatDurationSeconds() {

        DurationHandler instance = new DurationHandler(34);
        
        String expResult = "00:00:34";
        String result = instance.formatDuration();
        
        assertEquals(expResult, result);
    }
}
