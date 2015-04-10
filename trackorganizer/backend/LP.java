package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;

/**
 * Represents a vinyl LP.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class LP extends PhysicalRelease
{
    // Instance variables
    private String format;

    /**
     * Constructor.
     * 
     * @param artistName
     * @param releaseYear
     * @param recordLabel
     * @param totalDuration
     * @param tracks
     * @param archiveNR
     * @param format Format of the LP.
     */
    public LP(String artistName, Year releaseYear, String recordLabel, Duration totalDuration,  ArrayList<Track>tracks, int archiveNR, String format)
    {
        super(artistName, releaseYear, recordLabel, totalDuration,  tracks, archiveNR);
        this.format = format;
    }

    /**
     * Returns the format of the LP.
     * 
     * @return Format of the LP.
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * Sets the format of the LP.
     * 
     * @param format The format of the LP.
     */
    public void setFormat(String format)
    {
        this.format = format;
    }
}