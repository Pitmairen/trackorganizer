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
}