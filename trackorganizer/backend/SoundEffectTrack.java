package backend;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Represents sound effect content.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class SoundEffectTrack extends Track
{
    // Instance variables
    private String description;

    /**
     * Constructor.
      * @param title Title of the track.
     * @param duration Duration of the track.
     * @param lastPlayed Date track was last played.
     * @param timesPlayed Number of times track has been played.
     * @param description A short description.
     */
    public SoundEffectTrack(String title, Duration duration, String description)
    {
        super(title, duration);
        this.description = description;
    }
    
    
     /**
     * Returns a description of the track
     *
     * @return A description of the track.
     */
    @Override
    public String getDescriptionString(){
        return getTitle() + " - " + getDescription() + ": " + 
            DurationHandler.durationToString(getDuration());
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