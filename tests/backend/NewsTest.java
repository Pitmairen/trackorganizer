/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 100174
 */
public class NewsTest {
    
    public NewsTest() {
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
     * Test of getDescription method, of class News.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        News instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJournalistName method, of class News.
     */
    @Test
    public void testGetJournalistName() {
        System.out.println("getJournalistName");
        News instance = null;
        String expResult = "";
        String result = instance.getJournalistName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateProduced method, of class News.
     */
    @Test
    public void testGetDateProduced() {
        System.out.println("getDateProduced");
        News instance = null;
        Date expResult = null;
        Date result = instance.getDateProduced();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateFirstAired method, of class News.
     */
    @Test
    public void testGetDateFirstAired() {
        System.out.println("getDateFirstAired");
        News instance = null;
        Date expResult = null;
        Date result = instance.getDateFirstAired();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJournalistName method, of class News.
     */
    @Test
    public void testSetJournalistName() {
        System.out.println("setJournalistName");
        String journalistName = "";
        News instance = null;
        instance.setJournalistName(journalistName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class News.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        News instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateProduced method, of class News.
     */
    @Test
    public void testSetDateProduced() {
        System.out.println("setDateProduced");
        Date dateProduced = null;
        News instance = null;
        instance.setDateProduced(dateProduced);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateFirstAired method, of class News.
     */
    @Test
    public void testSetDateFirstAired() {
        System.out.println("setDateFirstAired");
        Date dateFirstAired = null;
        News instance = null;
        instance.setDateFirstAired(dateFirstAired);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
