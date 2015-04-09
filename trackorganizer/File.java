/**
 * Represents an audio file.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class File
{
    // Instance variables
    private Track track;
    private String filePath;
    private int filesize;

    /**
     * Constructor.
     * 
     * @param track The audio track.
     * @param filePath The file path.
     */
    public File(Track track, String filePath)
    {
        this.track = track;
        this.filePath = filePath;
    }

    /**
     * Returns track.
     * 
     * @return Track
     */
    public Track getTrack()
    {
        return track;
    }

    /**
     * Sets the track.
     * 
     * @param track The track..
     */
    public void setTrack(Track track)
    {
        this.track = track;
    }

    /**
     * Returns file path.
     * 
     * @return File path
     */
    public String getFilePath()
    {
        return filePath;
    }

    /**
     * Sets the file path.
     * 
     * @param filePath The file path.
     */
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
}