package backend;

import java.time.Year;

/**
 * Represents a vinyl LP.
 */
public class LP extends PhysicalRelease {

    // Instance variables
    private static int nextArchiveNumber = 20001;
    private String format;

    /**
     * Constructor.
     *
     * @param title The name of the LP
     * @param artistName
     * @param releaseYear
     * @param recordLabel
     * @param archiveNR
     * @param format Format of the LP.
     */
    public LP(String title, String artistName, Year releaseYear, String recordLabel, int archiveNR, String format) {
        super(title, artistName, releaseYear, recordLabel, archiveNR);
        this.format = format;
    }

    /**
     * Constructor.
     *
     * @param title The name of the LP
     * @param artistName
     * @param releaseYear
     * @param recordLabel
     * @param format Format of the LP.
     */
    public LP(String title, String artistName, Year releaseYear, String recordLabel, String format) {
        this(title, artistName, releaseYear, recordLabel, LP.nextArchiveNumber++, format);
    }

    /**
     * Returns the format of the LP.
     *
     * @return Format of the LP.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the LP.
     *
     * @param format The format of the LP.
     */
    public void setFormat(String format) {
        this.format = format;
    }
}
