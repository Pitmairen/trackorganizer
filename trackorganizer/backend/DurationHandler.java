package backend;

import java.time.Duration;

/**
 *
 * @author Tor-Martin Holen
 */
public class DurationHandler {

    private Duration duration;
    
    
    DurationHandler(long seconds) {
        duration = Duration.ofSeconds(seconds);
    }

    DurationHandler(Duration duration) {
        this.duration = duration;
    }
    
    public static String durationToString(Duration d){
        
        DurationHandler h = new DurationHandler(d);
        
        return h.formatDuration();
        
    }
    
    
    
    
    /**
     * Returns the duration in a unformatted duration
     * 
     * @return duration.toString() Returns a unformatted duration.
     */
    public String getUnformattedString() {
        return duration.toString();
    }

    /**
     * Returns a string usable to display the duration of the different medias in a easily read format,
     * ex: "04:53:21"
     *
     * @return formattedString Returns a string containing duration.
     */
    public String formatDuration() {
        String hourValue = "", minuteValue = "", secondValue = "";

        hourValue = formatValue(hourValue, "T", "H");
        minuteValue = formatValue(minuteValue, "H", "M");
        secondValue = formatValue(secondValue, "M", "S");

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
    private String formatValue(String value, String startAfterLetter, String endBeforeLetter) {

        String unformattedString = duration.toString();  //Current format: PTnHnMnS

        int startIndex = unformattedString.lastIndexOf(startAfterLetter) + 1;
        int endIndex = unformattedString.lastIndexOf(endBeforeLetter);

       // System.out.println(startIndex);
        //System.out.println(endIndex);
        value = unformattedString.substring(startIndex, endIndex);

        if (value.length() == 1) {
            value = "0" + value;
        }

        if (value.length() > 2) {
            value = unformattedString.substring(0, 2);
        }

        //System.out.println(value);
        return value;
    }
}
