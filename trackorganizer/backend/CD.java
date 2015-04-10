package backend;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;

/**
 * Represents a CD.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class CD extends PhysicalRelease
{
    // Instance variables

    /**
     * Constructor.
     * 
     * @param name Album name
     */
    public CD(String artistName, Year releaseYear, String recordLabel, Duration totalDuration,  ArrayList<Track>tracks, int archiveNR)
    {
        super(artistName, releaseYear, recordLabel, totalDuration,  tracks, archiveNR);
    }
}