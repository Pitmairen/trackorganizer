
package backend;

import java.time.Duration;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HDTest {
    

    HD hd;
    
    @Before
    public void setUp() {
        
        hd = new HD("Test HD");        
    }
    
    
    @Test(expected=UnsupportedOperationException.class)
    public void testAddTrack()
    {
        Track t = new MusicTrack("Test", "Test", Duration.ZERO);
        hd.addTrack(t);
    }
    
    
    /**
     * Test of getTracks method, of class HD.
     */
    @Test
    public void testGetTracks() {
        
        Track t1 = new MusicTrack("Test1", "Test1", Duration.ZERO);
        File f1 = new File(t1, "test1.mp3", 324);
        
        Track t2 = new MusicTrack("Test2", "Test2", Duration.ZERO);
        File f2 = new File(t2, "test2.mp3", 324);
        
        hd.addFile(f1);
        hd.addFile(f2);
        
        ArrayList<Track> expected = new ArrayList<>();
        expected.add(t1);
        expected.add(t2);
        

        assertEquals(hd.getTracks(), expected);

    }


    /**
     * Test of addFile method, of class HD.
     */
    @Test
    public void testAddFile() {
        Track t = new MusicTrack("Test", "Test", Duration.ZERO);
        File file = new File(t, "test.mp3", 324);

        hd.addFile(file);

        assertEquals(hd.getFiles().get(0), file);
        
        
    }

    /**
     * Test of removeTrack method, of class HD.
     */
    @Test
    public void testRemoveTrack() {
        Track t1 = new MusicTrack("Test1", "Test1", Duration.ZERO);
        File f1 = new File(t1, "test1.mp3", 324);
        
        Track t2 = new MusicTrack("Test2", "Test2", Duration.ZERO);
        File f2 = new File(t2, "test2.mp3", 324);
        
        hd.addFile(f1);
        hd.addFile(f2);

        assertEquals(hd.getFiles().size(), 2);

        hd.removeTrack(t1);
        
        assertEquals(hd.getFiles().size(), 1);
        assertEquals(hd.getFiles().get(0), f2);


    }

    /**
     * Test of getTrackAt method, of class HD.
     */
    @Test
    public void testGetTrackAt() {
        
        Track t1 = new MusicTrack("Test1", "Test1", Duration.ZERO);
        File f1 = new File(t1, "test1.mp3", 324);
        
        Track t2 = new MusicTrack("Test2", "Test2", Duration.ZERO);
        File f2 = new File(t2, "test2.mp3", 324);
        
        hd.addFile(f1);
        hd.addFile(f2);

        
        assertEquals(hd.getTrackAt(0), t1);
        assertEquals(hd.getTrackAt(1), t2);

    }
    
}
