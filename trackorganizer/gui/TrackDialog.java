
package gui;

import backend.Media;
import backend.Track;
import javax.swing.JFrame;


public abstract class TrackDialog extends AbstractDialog {

    private Track mTrack;
    
    public TrackDialog(String title, JFrame frame){
        super(title, frame);
    }
    
    /**
     * Set the track object
     * @param track A track object
     */
    public void setMediaObject(Track track){
        mTrack = track;
        loadTrackContent();
    }
    
    /**
     * Returns the track object created form the content in the dialog.
     * @return A track object.
     */
    public Track getTrackObject(){
        
        return mTrack;
    }
    /**
     * Creates a new track object
     * @return A new track object
     */
    public abstract Track createTrackObject();
   
     /**
     * Update track object
     */
    public abstract void updateTrackObject();
    
    
     /**
     * Load tracl content.
     */
    protected abstract void loadTrackContent();
    
      
}
