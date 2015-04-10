/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Per Myren
 */
public class CDTest {
    

    @Test
    public void testCDName() {

        CD cd = new CD("Test1");
        
        assertEquals(cd.getName(), "Test1");
        
        cd.setName("Test2");
        
        assertEquals(cd.getName(), "Test2");
        
    }
    
    
    @Test
    public void testGettersAndSetters() {

        CD cd = new CD("Test1");
        
        cd.setRecordLabel("Sony");
        cd.setArtistName("TestArtist");
        cd.setReleaseYear(1971);
  
        assertEquals(cd.getRecordLabel(), "Sony");
        assertEquals(cd.getArtistName(), "TestArtist");
        assertEquals(cd.getReleaseYear(), 1971);
     
        
    }
    
    
    @Test
    public void testCDAddTrack() {

        CD cd = new CD("Test");
        
        Track t1 = new Track("T1");
        
        cd.addTrack(t1);
        
        ArrayList<Track> want = new ArrayList<>();
        want.add(t1);
        
        assertEquals(cd.getTracks(), want);

    }
}
