/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * DESCRIPTION NEEDED
 */
public class CDTest {
    
    private CD cd;

    @Before
    public void setUp() {
        cd = new CD("Album1", "Artist1", Year.of(2014), "Sony", 10001);
    }

    
    @Test
    public void testCDName() {

        assertEquals(cd.getName(), "Album1");
        
        cd.setName("Album2");
        
        assertEquals(cd.getName(), "Album2");
        
    }
    
    
    @Test
    public void testGettersAndSetters() {

        assertEquals(cd.getRecordLabel(), "Sony");
        assertEquals(cd.getArtistName(), "Artist1");
        assertEquals(cd.getReleaseYear(), Year.of(2014));
        
        cd.setRecordLabel("Universal");
        cd.setArtistName("Artist2");
        cd.setReleaseYear(Year.of(1971));
        
        assertEquals(cd.getRecordLabel(), "Universal");
        assertEquals(cd.getArtistName(), "Artist2");
        assertEquals(cd.getReleaseYear(), Year.of(1971));
        
    }
    
    
    @Test
    public void testCDAddTrack() {

        Track t1 = new MusicTrack("Artist1", "Song1", Duration.ofSeconds(100));
        
        cd.addTrack(t1);
        
        ArrayList<Track> want = new ArrayList<>();
        want.add(t1);
        
        assertEquals(cd.getTracks(), want);

    }
}
