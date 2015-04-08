/**
 * Represents sound effect content.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class SoundEffect extends Track
{
    // Instance variables
    private String description;

    /**
     * Constructor.
     * 
     * @param title Name of the sound effect.
     * @param description A short description.
     */
    public SoundEffect(String title, String description)
    {
        super(title);
        this.description = description;
    }

    /**
     * Returns sound effect description.
     * 
     * @return Description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the sound effect description.
     * 
     * @param description Description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
}