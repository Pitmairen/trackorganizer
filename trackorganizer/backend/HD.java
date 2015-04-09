package backend;

import java.util.ArrayList;

/**
 * Represents a hard drive used for storing audio files.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class HD extends Media
{
    // Instance variables
    private ArrayList<File> files;

    /**
     * Constructor.
     * 
     * @param name Name of the hard drive.
     */
    public HD(String name)
    {
        super(name);
        files = new ArrayList<File>();
    }
}