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
     */
    public LP(String name)
    {
        super(name);
    }
}