

package gui;

import backend.Media;
import javax.swing.JFrame;

/**
 * Abstract class for media add/edit media dialogs.
 */
public abstract class MediaDialog extends AbstractDialog {

    
    private Media mMedia;
    
    public MediaDialog(String title, JFrame frame){
        super(title, frame); 
    }
    

    
    /**
     * Set the media object
     * @param media A media object
     */
    public void setMediaObject(Media media){
        mMedia = media;
        loadMediaContent();
    }
    
    /**
     * Returns the media object created form the content in the dialog.
     * @return A media object.
     */
    public Media getMediaObject(){
        
        return mMedia;
    }
   
   
    /**
     * Creates a new media object.
     * @return A new media object.
     */
    public abstract Media createMediaObject();
   
     /**
     * Update media object
     */
    public abstract void updateMediaObject();
    
    
     /**
     * Load media content.
     */
    protected abstract void loadMediaContent();
    

}
