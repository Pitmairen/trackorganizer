package backend;

import java.time.Year;
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
            if (name.equals(searchName)) {
                searchHit = media;
            }
        }
        return searchHit;
    }

    /**
     * Searches through entire collection. Returns an array with the matching
     * media.
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
            if (name.equals(searchName)) {
                searchHits.add(media);
            }
        }
        return searchHits;
    }
    
    
     /**
     * Searches through entire collection. Returns an array with the matching
     * tracks
     *
     * @param title The title to search for.
     * @return Array with the matching tracks
     */
    public ArrayList<Track> findTracksByTitleExact(String title) {
        ArrayList<Track> result = new ArrayList<>();
        for (Media media : medias) {
            for(Track track: media.getTracks()){
                if (track.getTitle().equals(title)){
                    result.add(track);
                }
            }
        }
        return result;
    }

    
     /**
     * Searches through entire collection by the archive number.
     *
     * @param archiveNr The archive number
     * @return The matching track or null if no track is found.
     */
    public PhysicalRelease findMediaByArchiveNumber(int archiveNr) {

        for (Media media : medias) {
            
            if(media instanceof PhysicalRelease){
                PhysicalRelease rel = (PhysicalRelease)media;
                if(rel.getArchiveNR() == archiveNr)   
                    return rel;
            }
        }
        return null;
    }
    

    /**
     * Adds a CD to the media collection.
     *
     * @param name Album title
     */
    public void addCD(String name, String artist, Year year, String label) {
        addMedia(new CD(name, artist, year, label));
    }

    /**
     * Adds a LP to the media collection.
     *
     * @param name Album title
     * @param format Format of the LP
     */
    public void addLP(String name, String format) {
        //addMedia(new LP(name, format));
    }

    /**
     * Adds a tape cassette to the media collection.
     *
     * @param name Name of the cassette.
     * @param format Digital or analog.
     */
    public void addTape(String name, String format) {
        //addMedia(new Tape(name, format));
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
