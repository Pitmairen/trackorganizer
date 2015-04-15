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
public class NewsTrackTest {
    
    public NewsTrackTest() {
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
     * Test of getDescription method, of class NewsTrack.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        NewsTrack instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJournalistName method, of class NewsTrack.
     */
    @Test
    public void testGetJournalistName() {
        System.out.println("getJournalistName");
        NewsTrack instance = null;
        String expResult = "";
        String result = instance.getJournalistName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateProduced method, of class NewsTrack.
     */
    @Test
    public void testGetDateProduced() {
        System.out.println("getDateProduced");
        NewsTrack instance = null;
        Date expResult = null;
        Date result = instance.getDateProduced();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateFirstAired method, of class NewsTrack.
     */
    @Test
    public void testGetDateFirstAired() {
        System.out.println("getDateFirstAired");
        NewsTrack instance = null;
        Date expResult = null;
        Date result = instance.getDateFirstAired();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJournalistName method, of class NewsTrack.
     */
    @Test
    public void testSetJournalistName() {
        System.out.println("setJournalistName");
        String journalistName = "";
        NewsTrack instance = null;
        instance.setJournalistName(journalistName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class NewsTrack.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        NewsTrack instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateProduced method, of class NewsTrack.
     */
    @Test
    public void testSetDateProduced() {
        System.out.println("setDateProduced");
        Date dateProduced = null;
        NewsTrack instance = null;
        instance.setDateProduced(dateProduced);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateFirstAired method, of class NewsTrack.
     */
    @Test
    public void testSetDateFirstAired() {
        System.out.println("setDateFirstAired");
        Date dateFirstAired = null;
        NewsTrack instance = null;
        instance.setDateFirstAired(dateFirstAired);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
