/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import org.junit.Test;
import static org.junit.Assert.*;

    /**
     * DESCRIPTION NEEDED
     */
public class DurationHandlerTest {

     /**
     * Test of formatDuration method, of class DurationHandler.
     */
    @Test
    public void testFormatDurationHMS() {
        DurationHandler instance = new DurationHandler(5, 17, 363);
        System.out.println("Original string: " + instance.getUnformattedString());

        String expResult = "05:23:03";

        String result = instance.formatDuration();
        System.out.println("Final String: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatDurationHM() {
        DurationHandler instance = new DurationHandler(5, 17, 0);
        System.out.println("Original string: " + instance.getUnformattedString());

        String expResult = "05:17:00";

        String result = instance.formatDuration();
        System.out.println("Final String: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatDurationS() {
        DurationHandler instance = new DurationHandler(0, 0, 3663);
        System.out.println("Original string: " + instance.getUnformattedString());

        String expResult = "01:01:03";

        String result = instance.formatDuration();
        System.out.println("Final String: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatDurationMinutes() {

        DurationHandler instance = new DurationHandler(365);

        String expResult = "00:06:05"; // Or maybe 04:05
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