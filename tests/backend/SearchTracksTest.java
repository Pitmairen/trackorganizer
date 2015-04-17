
package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SearchTracksTest {
    
    
        // Fields
    TrackOrganizer to;

    @Before
    public void setUp() {
        to = new TrackOrganizer("testing");
    }


     /**
     * Test search by title exact
     */
    @Test
    public void testSearchByTitleExact() {
        
        createTracksForSearch();
        
        ArrayList<Track> res = to.findTracks(new SearchTracks.ByTitle("sONg1").exact());

        assertEquals(1, res.size());
        assertEquals("SoNg1", res.get(0).getTitle());
        
        res = to.findTracks(new SearchTracks.ByTitle("song99").exact());


        assertEquals(0, res.size());
        
    }
    
    /**
     * Test search by title contains
     */
    @Test
    public void testSearchByTitleContains() {
        
        createTracksForSearch();
        
        ArrayList<Track> res = to.findTracks(new SearchTracks.ByTitle("nUMber").contains());

        assertEquals(1, res.size());
 
        assertEquals("Song NuMber 2", res.get(0).getTitle());
        
        res = to.findTracks(new SearchTracks.ByTitle("sonG99").contains());

        assertEquals(0, res.size());
        
    }
    
    private void createTracksForSearch(){
        
        CD cd = new CD("Album1", "Artist1", Year.of(2014), "Sony", 10001);
        

        cd.addTrack(new MusicTrack("SoNg1", "Artist1", Duration.ofSeconds(100)));
        cd.addTrack(new MusicTrack("Song NuMber 2", "Artist2", Duration.ofSeconds(100)));

        to.addMedia(cd);
        
  
    }
    
    

}
