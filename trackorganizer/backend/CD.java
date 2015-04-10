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
     * @param artistName artist name of the release.
     * @param releaseYear release year of the release.
     * @param recordLabel record label behind the release.
     * @param archiveNR archive number where archive is stored.
     */
    public CD(String artistName, Year releaseYear, String recordLabel, int archiveNR)
    {
        super(artistName, releaseYear, recordLabel, archiveNR);
    }
}