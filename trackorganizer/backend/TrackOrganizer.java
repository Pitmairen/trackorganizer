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

    /**
     * Searches through entire collection. Returns the first Media with the
     * matching name.
     *
     * @param searchName Searchword.
     * @return The media with the corresponding name.
     */
    public Media findFirstName(String searchName) {
        String name = null;
        Media searchHit = null;
        for (Media media : medias) {
            name = media.getName();
            if (name == searchName) {
                searchHit = media;
            }
        }
        return searchHit;
    }

    /**
     * Searches through entire collection. Returns an array with the matching
     * results.
     *
     * @param searchName Searchword.
     * @return Array with the matching results.
     */
    public ArrayList<Media> findAll(String searchName) {
        String name = null;
        ArrayList<Media> searchHits = null;
        Media searchHit = null;
        for (Media media : medias) {
            name = media.getName();
            if (name == searchName) {
                searchHits.add(media);
            }
        }
        return searchHits;
    }

    /**
     * Adds a CD to the media collection.
     *
     * @param name Album title
     */
    public void addCD(String name) {
        addMedia(new CD(name));
    }

    /**
     * Adds a LP to the media collection.
     *
     * @param name Album title
     * @param format Format of the LP
     */
    public void addLP(String name, String format) {
        addMedia(new LP(name, format));
    }

    /**
     * Adds a tape cassette to the media collection.
     *
     * @param name Name of the cassette.
     * @param format Digital or analog.
     */
    public void addTape(String name, String format) {
        addMedia(new Tape(name, format));
    }

    /**
     * Adds a hard drive to the media collection.
     *
     * @param name Name of the hard drive.
     * @param format Digital or analog.
     */
    public void addTape(String name) {
        addMedia(new HD(name));
    }
    
     /**
     * Adds a media to the media collection.
     *
     * @param media The media to add
     */
    public void addMedia(Media media)
    {
        medias.add(media);
    }
    
}
