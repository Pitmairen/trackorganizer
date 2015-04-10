package backend;


import java.time.Duration;

/**
 * 
 * @author Tor-Martin Holen
 */
public class DurationHandler {

    private Duration duration;

    DurationHandler(long seconds) {
        this.duration = this.duration.plusSeconds(seconds);
    }

    /**
     *
     * @return formatedString Returns a string containing duration ex:
     * "04:53:21"
     */
    public String formatDuration() {
        String hourValue = "", minuteValue = "", secondValue = "";

        formatValue(hourValue, "T", "H");
        formatValue(minuteValue, "H", "M");
        formatValue(secondValue, "M", "S");

        String formatedString = hourValue + ":" + minuteValue + ":" + secondValue;
        
        return formatedString;
    }

    /**
     *  Function used to format and fill in strings containing hour, minute or second values. 
     *  The function gets the values from a duration string.
     * 
     * @param value The value we want to format
     * @param startAfterLetter A substring is started after this letter
     * @param endBeforeLetter The substring ends before this letter
     * @return value Returns the value formated
     */
    private String formatValue(String value, String startAfterLetter, String endBeforeLetter) {
        
        String unformatedString = duration.toString();  //Current format: PTnHnMnS
        
        int startIndex = unformatedString.lastIndexOf(startAfterLetter) + 1;
        int endIndex = unformatedString.lastIndexOf(endBeforeLetter) - 1;
        value = unformatedString.substring(startIndex, endIndex);
        
        if (value.length() == 1) {
            value = "0" + value;
        }
        
        if (value.length() > 2) {
            value = unformatedString.substring(0, 2);
        }
        
        return value;
    }
}
