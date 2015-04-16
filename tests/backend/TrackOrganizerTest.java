package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import org.junit.Before;
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
        trackOrganizer.addCD(name, "artist", Year.of(2012), "sony");
        assertEquals(name, trackOrganizer.findFirstName(name).getName());
    }
    
    
     /**
     * Test search by title exact
     */
    @Test
    public void testSearchByTitleExact() {
        
        createTracksForSearch();
        
        ArrayList<Track> res = trackOrganizer.findTracksByTitleExact("song1");
        

        assertEquals(1, res.size());
        assertEquals("Song1", res.get(0).getTitle());
        
        res = trackOrganizer.findTracksByTitleExact("Song99");
        
        assertEquals(0, res.size());
        
    }
    
    /**
     * Test search by title contains
     */
    @Test
    public void testSearchByTitleContains() {
        
        createTracksForSearch();
        
        ArrayList<Track> res = trackOrganizer.findTracksByTitleContains("Number");
        

        assertEquals(1, res.size());
        
        assertEquals("Song number 2", res.get(0).getTitle());
        
        res = trackOrganizer.findTracksByTitleContains("Song99");
        
        assertEquals(0, res.size());
        
    }
    
    private void createTracksForSearch(){
        
        CD cd = new CD("Album1", "Artist1", Year.of(2014), "Sony", 10001);
        

        cd.addTrack(new MusicTrack("Song1", "Artist1", Duration.ofSeconds(100)));
        cd.addTrack(new MusicTrack("Song number 2", "Artist2", Duration.ofSeconds(100)));

        trackOrganizer.addMedia(cd);
        
  
    }
}
