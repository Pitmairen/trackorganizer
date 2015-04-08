/**
 * Represents an audio track.
 * It can be any kind of audio content.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class Track
{
    // Instance variables    
    private String title;
    private int duration;
    private int lastPlayed;
    private int timesPlayed;

    /**
     * Constructor.
     * 
     * @param title Title of the track.
     */
    public Track(String title)
    {
        this.title = title;
    }

    /**
     * Returns track title.
     * 
     * @return Title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the track title.
     * 
     * @param title Track title.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
}