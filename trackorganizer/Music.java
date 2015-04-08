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
     * @param title Name of the melody.
     * @param artist Name of the srtist.
     */
    public Music(String title, String artist)
    {
        super(title);
        this.artist = artist;
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