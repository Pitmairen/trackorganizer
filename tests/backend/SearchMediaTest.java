package backend;

import java.time.Year;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for search media classes.
 */
public class SearchMediaTest {

    // Variables
    TrackOrganizer trackOrganizer;

    @Before
    public void setUp() {
        trackOrganizer = new TrackOrganizer("name of track organizer");
    }

    /**
     * Testing searchMedia.ByName
     */
    @Test
    public void testByName() {
        addMedia();
        ArrayList<Media> media;

        media = trackOrganizer.findMedia(new SearchMedia.ByName("testTitle"));
        CD cd = (CD) media.get(0);
        assertEquals("testTitle", cd.getName());

        media = trackOrganizer.findMedia(new SearchMedia.ByName("random string"));
        assertEquals(0, media.size());
    }

    /**
     * Testing searchMedia.ByArtist
     */
    @Test
    public void testByArtist() {
        addMedia();
        ArrayList<Media> media;

        media = trackOrganizer.findMedia(new SearchMedia.ByArtist("testArtist"));
        CD cd = (CD) media.get(0);
        assertEquals("testArtist", cd.getArtistName());

        media = trackOrganizer.findMedia(new SearchMedia.ByArtist("random string"));
        assertEquals(0, media.size());
    }

    /**
     * Testing searchMedia.ByNR
     */
    @Test
    public void testByNR() {
        addMedia();
        ArrayList<Media> media;

        media = trackOrganizer.findMedia(new SearchMedia.ByNR(12));
        CD cd = (CD) media.get(0);
        assertEquals(12, cd.getArchiveNR());
    }

    /**
     * Adds some media to trackOrganizer for testing purposes.
     */
    private void addMedia() {
        trackOrganizer.addMedia(new CD("testTitle", "testArtist", Year.of(1980), "testRecordLabel", 12));
    }
}
