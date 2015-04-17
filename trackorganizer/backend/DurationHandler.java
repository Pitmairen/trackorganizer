package backend;

import java.time.Duration;

/**
 *
 * @author Tor-Martin Holen
 */
public class DurationHandler {

    private Duration duration;
    
    /**
     * Constructor
     *
     * @param hours The number of hours the track/media lasts.
     * @param minutes The number of minutes the track/media lasts, which has not
     * been taken in account in the hour parameter.
     * @param seconds The number of seconds the track/media lasts, which has not
     * been taken in account in the hour or minute parameter.
     */
    DurationHandler(long hours, long minutes, long seconds) {
        duration = Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

    /**
     * Constructor
     *
     * @param seconds The duration of the track/media in second.
     * @param minutes The number of seconds the track/media lasts which has not
     * been taken in account in the minute parameter.
     */
    DurationHandler(long minutes, long seconds) {
        duration = Duration.ofMinutes(minutes).plusSeconds(seconds);
    }

    /**
     * Constructor
     *
     * @param seconds The duration of the track/media in seconds.
     */
    DurationHandler(long seconds) {
        duration = Duration.ofSeconds(seconds);
    }

    /**
     * Constructor
     * @param duration Takes a already existing duration.
     */
    DurationHandler(Duration duration) {
        this.duration = duration;
    }
    
    public static String durationToString(Duration d){
        
        DurationHandler h = new DurationHandler(d);
        
        return h.formatDuration();
        
    }
    
    
    
    
    /**
     * Returns the duration in a unformatted duration.
     *
     * @return duration.toString() Returns a unformatted duration.
     */
    public String getUnformattedString() {
        return duration.toString();
    }

    /**
     * Returns a string usable to display the duration of the different medias
     * in a easily read format, ex: "04:53:21"
     *
     * @return formattedString Returns a string containing duration.
     */
    public String formatDuration() {
        String hourValue = "", minuteValue = "", secondValue = "";

        hourValue = formatValue(hourValue, "H");
        minuteValue = formatValue(minuteValue, "M");
        secondValue = formatValue(secondValue, "S");

        String formattedString = hourValue + ":" + minuteValue + ":" + secondValue;

        return formattedString;
    }

    /**
     * Function used to format and fill in strings containing hour, minute or
     * second values. The function gets the values from a duration string.
     *
     * @param value The value we want to format
     * @param startAfterLetter A substring is started after this letter
     * @param endBeforeLetter The substring ends before this letter
     * @return value Returns the value formatted
     */
    private String formatValue(String value, String endBeforeLetter) {

        String unformattedString = duration.toString();  //Current format: PTnHnMnS

        int endIndex = unformattedString.lastIndexOf(endBeforeLetter);

        if (endIndex != -1) {
            value = unformattedString.substring(endIndex-2, endIndex);
            System.out.println(value);
            if(value.contains("T")||value.contains("H")||value.contains("M")||value.contains("S")){
                value = "0" + unformattedString.substring(2, 3);
            }
        } else {
            value = "00";
        }

        return value;
    }
}
