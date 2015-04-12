package backend;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Represents music content.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class Music extends Track
{
    // Instance variables
    private String artist;

    /**
     * Constructor.
     * 
     * @param title Title of the track.
     * @param duration Duration of the track.
     * @param lastPlayed Date track was last played.
     * @param timesPlayed Number of times track has been played.
     * @param artist Name of the artist..
     */
    public Music(String title, Duration duration, LocalDateTime lastPlayed, int timesPlayed, String artist)
    {
        super(title, duration, lastPlayed, timesPlayed);
        this.artist = artist;
    }
    
    
        /**
     * Constructor.
     * 
     * @param artist Name of the artist..
     * @param title Title of the track.
     * @param duration Duration of the track.
     */
    public Music(String artist, String title, Duration duration)
    {
        this(title, duration, null, 0, artist);
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