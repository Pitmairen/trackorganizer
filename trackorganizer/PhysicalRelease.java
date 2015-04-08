import java.util.ArrayList;

/**
 * Represents physical releases like CD's and vinyl LP's.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class PhysicalRelease extends Media
{
    // Instance variables
    private String artistName;
    private int releaseYear;
    private String recordLabel;
    private int totalDuration;
    private ArrayList<Track> tracks;
    private int archiveNR;

    /**
     * Constructor.
     * 
     * @param name Name of the physical release.
     */
    public PhysicalRelease(String name)
    {
        super(name);
        tracks = new ArrayList<Track>();
    }
}