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
    
    private static int nextArchiveNumber = 10001;
    


    /**
     * Constructor.
     * 
     * @param title The name of the release.
     * @param artistName artist name of the release.
     * @param releaseYear release year of the release.
     * @param recordLabel record label behind the release.
     * @param archiveNR archive number where archive is stored.
     */
    public CD(String title, String artistName, Year releaseYear, String recordLabel, int archiveNR)
    {
        super(title, artistName, releaseYear, recordLabel, archiveNR);
    }
    
    /**
     * Constructor. Will auto generate the next archive number-
     * 
     * @param title The name of the release.
     * @param artistName artist name of the release.
     * @param releaseYear release year of the release.
     * @param recordLabel record label behind the release.
     */
    public CD(String title, String artistName, Year releaseYear, String recordLabel)
    {
        this(title, artistName, releaseYear, recordLabel, nextArchiveNumber++);
    }
    

}