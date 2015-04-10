package backend;

import java.util.Date;

/**
 * Represents an audio track. It can be any kind of audio content.
 *
 * @author Kristian Honningsvag
 * @version 0.1
 */
public class Track {

    // Instance variable
    private String title;
    private int duration;
    private Date lastPlayed;
    private int timesPlayed;

    /**
     * Constructor.
     *
     * @param title Title of the track.
     */
    public Track(String title) {
        this.title = title;
    }

    //Getters
    /**
     * Returns track title.
     *
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the duration of the track.
     *
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the date the track was last played.
     *
     * @return lastPlayed
     */
    public Date getLastPlayed() {
        return lastPlayed;
    }

    /**
     * Returns the number of times the track has been played.
     *
     * @return timesPlayed
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    //Setters
    /**
     * Sets the track title.
     *
     * @param title Track title.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Sets the duration of the track.
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets the date the track was last played.
     *
     * @param lastPlayed
     */
    public void setLastPlayed(Date lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    /**
     * Sets the number of times the track has been played.
     *
     * @param timesPlayed
     */
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }
}
