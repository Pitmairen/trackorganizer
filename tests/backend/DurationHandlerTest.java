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
 *
 * @author tor-martin
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
        System.out.println("Testing the duration handler");
        DurationHandler instance = new DurationHandler(359999);
        System.out.println(instance.getUnformattedString());
        String expResult = "99:59:59";
        String result = instance.formatDuration();
        System.out.println(instance.formatDuration());
        assertEquals(expResult, result);
    }
    
}
