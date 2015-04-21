
package gui;

import backend.DurationHandler;
import backend.Media;
import backend.PhysicalRelease;
import backend.SearchMedia;
import backend.TrackOrganizer;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Media model
 */
public class MediaListModel extends AbstractTableModel 
{
    
    private String[] mColumnNames = {"Icon", "Media"};
   
    private TrackOrganizer mTrackOrganizer;
    
    private ArrayList<Media> mFilteredMedia;
    private boolean mIsFiltered = false;
    
    
    public MediaListModel(TrackOrganizer trackOrganizer){
        this.mTrackOrganizer = trackOrganizer;
    }

    /**
     * Filters the content of the model.
     * @param filter The filter string
     */
    public void setFilter(String filter){
        if(filter.length() > 0){
            setMediaList(mTrackOrganizer.findMedia(new SearchMedia.ByName(filter)));
        }else{
            setMediaList(null);
        }
    }
    
    /**
     * Sets the current list of media objects to display
     * @param medialist A list of media objects to display.
     */
    public void setMediaList(ArrayList<Media> medialist){
   
        mFilteredMedia = medialist;
        mIsFiltered = medialist != null;

        this.fireTableDataChanged();
    }
    
    
    
    @Override
    public int getColumnCount() {
        return mColumnNames.length;
    }

    @Override
    public int getRowCount() {
        if(mIsFiltered){
            return mFilteredMedia.size();
        }
        return mTrackOrganizer.getMediaCount();
    }
    

    @Override
    public String getColumnName(int col) {
        return mColumnNames[col];
    }

    
    @Override
    public Object getValueAt(int row, int col) {
        
        Media media;
        
        if(mIsFiltered){
            media = mFilteredMedia.get(row);
        }else{
            media = mTrackOrganizer.getMediaList().get(row);
        }
        
        switch(col){
            case 0:
                return IconLoader.getIcon(media.getClass());
            case 1:
                if(media instanceof PhysicalRelease){
                    return ((PhysicalRelease)media).getArtistName() + " - " + media.getName();
                }
                return media.getName();
            case 2:
                if(media instanceof PhysicalRelease){
                    return ((PhysicalRelease)media).getArtistName();
                }
                return "";
            case 3:
                if(media instanceof PhysicalRelease){
                    return DurationHandler.durationToString(((PhysicalRelease)media).getTotalDuration());
                }
                return "";


        }
        return "UNKNOWN";
    }
    
}
