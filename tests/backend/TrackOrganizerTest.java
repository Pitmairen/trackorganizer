package backend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the TrackOrganizer class.
 *
 * @author hasirak
 */
public class TrackOrganizerTest {

    // Fields
    TrackOrganizer trackOrganizer;

    // Constructor
    public TrackOrganizerTest() {
        trackOrganizer = new TrackOrganizer("My track organizer");
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
     * Test of addCD method, of class TrackOrganizer.
     */
    @Test
    public void testAddCD() {
        String name = "Awesome mix, vol.2";
        trackOrganizer.addCD(name);
        assertEquals(name, trackOrganizer.findFirstName(name).getName());
    }
}
