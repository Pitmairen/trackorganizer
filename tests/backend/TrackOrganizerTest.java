package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
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
        trackOrganizer.addCD(name);
        assertEquals(name, trackOrganizer.findFirstName(name).getName());
    }
    
    
     /**
     * Test search by title exact
     */
    @Test
    public void testSearchByTitleExact() {
        
        createTracksForSearch();
        
        ArrayList<Track> res = trackOrganizer.findTracksByTitleExact("Song1");
        

        assertEquals(1, res.size());
        assertEquals("Song1", res.get(0).getTitle());
        
        res = trackOrganizer.findTracksByTitleExact("Song99");
        
        assertEquals(0, res.size());
        
    }
    
    
    
    private void createTracksForSearch(){
        
        CD cd = new CD("Artist1", Year.of(2014), "Sony", 10001);
        
        Track t1 = new Music("Artist1", "Song1", Duration.ofSeconds(100));
        cd.addTrack(t1);
        
        trackOrganizer.addMedia(cd);
        
  
    }
}
