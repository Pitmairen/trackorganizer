package backend;

/**
 * Represents news content.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class News extends Track
{
    // Instance variables    
    private String description;
    private String journalistName;
    private int dateProduced;
    private int dateFirstAired;

    /**
     * Constructor.
     * 
     * @param title Name of the sound effect.
     * @param description A short description.
     * @param journalistName Name of the journalist.
     */
    public News(String title, String description, String journalistName)
    {
        super(title);
        this.description = description;
        this.journalistName = journalistName;
    }

    /**
     * Returns news content description.
     * 
     * @return Description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the news contents description.
     * 
     * @param description Description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Returns the name of the journalist.
     * 
     * @return Journalist name
     */
    public String getJournalistName()
    {
        return journalistName;
    }

    /**
     * Sets the name of the journalist.
     * 
     * @param journalistName Name of the journalist.
     */
    public void setJournalistName(String journalistName)
    {
        this.journalistName = journalistName;
    }
}