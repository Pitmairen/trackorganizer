package backend;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Represents news content.
 *
 * @author Kristian Honningsvag
 * @version 0.1
 */
public class NewsTrack extends Track {

    // Instance variables    
    private String description;
    private String journalistName;
    private Date dateProduced;
    private Date dateFirstAired;

    /**
     * Constructor.
     *
     * @param title Title of the track.
     * @param duration Duration of the track.
     * @param description A short description.
     * @param journalistName Name of the journalist..
     * @param dateProduced The date the track was produced.
     * @param dateFirstAired The date the track was aired.
     */
    public NewsTrack(String title, Duration duration,  String description, String journalistName, Date dateProduced, Date dateFirstAired) {
        super(title, duration);
        this.description = description;
        this.journalistName = journalistName;
    }
    
    //Getters
    /**
     * Returns news content description.
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name of the journalist.
     *
     * @return Journalist name
     */
    public String getJournalistName() {
        return journalistName;
    }

    /**
     * Returns the date the news track was produced
     * @return dateProduced
     */
    public Date getDateProduced() {
        return dateProduced;
    }

    /**
     * Returns the date the news track first aired
     * @return 
     */
    public Date getDateFirstAired() {
        return dateFirstAired;
    }

    //Setters
    /**
     * Sets the name of the journalist.
     *
     * @param journalistName Name of the journalist.
     */
    public void setJournalistName(String journalistName) {
        this.journalistName = journalistName;
    }

    /**
     * Sets the news contents description.
     *
     * @param description Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the date the news track was first produced.
     * @param dateProduced 
     */
    public void setDateProduced(Date dateProduced) {
        this.dateProduced = dateProduced;
    }

    /**
     * Returns the date the news track first aired.
     * @param dateFirstAired 
     */
    public void setDateFirstAired(Date dateFirstAired) {
        this.dateFirstAired = dateFirstAired;
    }
}
