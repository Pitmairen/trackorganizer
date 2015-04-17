package backend;

import java.time.Year;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SearchMediaTest {

    @Test
    public void testByName() {
        TrackOrganizer trackOrganizer = new TrackOrganizer("name of organizer");
        trackOrganizer.addMedia(new CD("test", "test", Year.of(1980), "test"));
        ArrayList<Media> media;
        media = trackOrganizer.findMedia(new SearchMedia.ByName("test"));
        CD cd = (CD) media.get(0);

        assertEquals("test", cd.getName());

        media = trackOrganizer.findMedia(new SearchMedia.ByName("hallo"));
        assertEquals(0, media.size());
    }
}
