package backend;

import java.util.ArrayList;

/**
 * Represents a track organizer.
 *
 * @author Kristian Honningsvag
 * @version 0.1
 */
public class TrackOrganizer {

    // Instance variables
    private String name;
    private ArrayList<Media> medias;

    /**
     * Constructor.
     *
     * @param name Name of track organizer.
     */
    public TrackOrganizer(String name) {
        this.name = name;
        medias = new ArrayList<Media>();
    }
}
