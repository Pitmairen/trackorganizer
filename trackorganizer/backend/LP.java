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
    private static int nextArchiveNumber = 20001;
    
    
    // Instance variables
    private String format;

    /**
     * Constructor.
     * 
     * @param artistName
     * @param releaseYear
     * @param recordLabel
     * @param archiveNR
     * @param format Format of the LP.
     */
    public LP(String artistName, Year releaseYear, String recordLabel, int archiveNR, String format)
    {
        super(artistName, releaseYear, recordLabel, archiveNR);
        this.format = format;
    }

    
     /**
     * Constructor.
     * 
     * @param artistName
     * @param releaseYear
     * @param recordLabel
     * @param format Format of the LP.
     */
    public LP(String artistName, Year releaseYear, String recordLabel, String format)
    {
        this(artistName, releaseYear, recordLabel, LP.nextArchiveNumber++, format);
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