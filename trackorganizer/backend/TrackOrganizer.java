package backend;

import java.time.Year;
import java.util.ArrayList;

/**
 * Represents a track organizer.
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
     * Find media based on the predicate
     * @param pred The predicate for the search
     * @return An array with the matching media.
     */
    public ArrayList<Media> findMedia(Predicate pred) {
        
        ArrayList<Media> results = new ArrayList<>();
        for (Media media : medias) {        
            if (pred.isMatch(media)){
                results.add(media);
            }
        } 
        return results;
    }
    
    /**
     * Find tracks based on the predicate
     * @param pred The predicate for the search
     * @return An array with the matching tracks.
     */
    public ArrayList<Track> findTracks(Predicate pred) {
        
        ArrayList<Track> results = new ArrayList<>();
        for (Media media : medias) {
            for(Track track: media.getTracks()){            
                if (pred.isMatch(track)){
                    results.add(track);
                }
            }
        } 
        return results;
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
