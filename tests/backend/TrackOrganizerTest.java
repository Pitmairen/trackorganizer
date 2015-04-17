package backend;


import java.time.Year;
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
        trackOrganizer.addMedia(new CD(name, "artist", Year.of(2012), "sony"));
        
        assertEquals(name, trackOrganizer.findMedia(new SearchMedia.ByName(name)).get(0).getName());
    }
    
}
