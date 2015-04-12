package backend;

import java.util.ArrayList;

/**
 * Represents a hard drive used for storing audio files.
 *
 * @author Kristian Honningsvag
 * @version 0.1
 */
public class HD extends Media {

    // Instance variables

    private ArrayList<File> files;

    /**
     * Constructor.
     *
     * @param name Name of the hard drive.
     */
    public HD(String name) {
        super(name);
        files = new ArrayList<File>();
    }

    /**
     * Returns the files contained on the hard drive.
     * @return 
     */
    public ArrayList<File> getFiles() {
        return files;
    }

    /**
     * Sets the files on the hard drive.
     * @param files 
     */
    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
    
    
    /**
     * Returns the tracks associated with this media.
     * 
     * @return tracks
     */
    @Override
    public ArrayList<Track> getTracks(){
        // Dummy value for now
        return new ArrayList<>();
    }
   
    
    /**
     * Adds a track to this media.
     * 
     * @param track The track to add
     */
    @Override
    public void addTrack(Track track){
        
   
    }
    
}
