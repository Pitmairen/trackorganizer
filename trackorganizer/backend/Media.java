package backend;

/**
 * Represents a media container.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class Media
{
    // Instance variables
    String name;

    /**
     * Constructor.
     * 
     * @param name Name of the media container.
     */
    public Media(String name)
    {
        this.name = name;
    }

    /**
     * Returns the name of the media container.
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the media container.
     * 
     * @param name Name of the media container.
     */
    public void setName(String name)
    {
        this.name = name;
    }
}