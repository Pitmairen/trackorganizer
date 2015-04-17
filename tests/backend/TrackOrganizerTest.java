package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the TrackOrganizer class.
 */
public class TrackOrganizerTest {

    // Fields
    TrackOrganizer trackOrganizer;

    @Before
    public void setUp() {
        trackOrganizer = new TrackOrganizer("My track organizer");
    }



    /**
     * Test of addCD method, of class TrackOrganizer.
     */
    @Test
    public void testAddCD() {
        String name = "Awesome mix, vol.2";
        trackOrganizer.addCD(name, "artist", Year.of(2012), "sony");
        assertEquals(name, trackOrganizer.findFirstName(name).getName());
    }
    
}
