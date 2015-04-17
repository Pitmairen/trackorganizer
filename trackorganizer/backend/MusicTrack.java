package backend;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Represents music content.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class MusicTrack extends Track
{
    // Instance variables
    private String artist;

    /**
     * Constructor.
     * 
     * @param title Title of the track.
     * @param duration Duration of the track.
     * @param artist Name of the artist..
     */
    public MusicTrack(String title, String artist, Duration duration)
    {
        super(title, duration);
        this.artist = artist;
    }
    
    /**
     * Returns a description of the track
     *
     * @return A description of the track.
     */
    @Override
    public String getDescription(){
        return getArtist() + " - " + getTitle() + ": " + 
            DurationHandler.durationToString(getDuration());
    }
    
    
    /**
     * Returns artist name.
     * 
     * @return Artist name
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Sets the artist name.
     * 
     * @param artist Artist name.
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
}