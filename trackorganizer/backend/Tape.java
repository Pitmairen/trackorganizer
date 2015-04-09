package backend;

import backend.PhysicalRelease;
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
    public Tape(String name, String tapeType)
    {
        super(name);
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