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
}