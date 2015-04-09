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
     * @param name Album name.
     * @param format Format of the LP.
     */
    public LP(String name, String format)
    {
        super(name);
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
     * @param The format of the LP.
     */
    public void setFormat(String format)
    {
        this.format = format;
    }
}