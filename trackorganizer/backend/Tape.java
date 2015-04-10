package backend;

import backend.PhysicalRelease;
import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;

/**
 * Represents a cassette tape.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class Tape extends PhysicalRelease
{
    // Instance variables
    private String tapeType;

    /**
     * Constructor.
     * 
     * @param name Name of the Tape
     * @param tapeType Type of tape. Digital or analog.
     */
    public Tape(String artistName, Year releaseYear, String recordLabel, Duration totalDuration,  ArrayList<Track>tracks, int archiveNR, String tapeType)
    {
        super(artistName, releaseYear, recordLabel, totalDuration,  tracks, archiveNR);
        this.tapeType = tapeType;
    }

    /**
     * Returns tape type.
     * 
     * @return Tape type.
     */
    public String getTapeType()
    {
        return tapeType;
    }

    /**
     * Sets the tape type.
     * 
     * @param tapeType The tape type.
     */
    public void setTapeType(String tapeType)
    {
        this.tapeType = tapeType;
    }
}