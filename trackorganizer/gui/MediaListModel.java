
package gui;

import backend.DurationHandler;
import backend.Media;
import backend.PhysicalRelease;
import backend.Predicate;
import backend.TrackOrganizer;
import java.util.ArrayList;
import java.util.Arrays;
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
     * @param filter The filter predicate
     */
    public void setFilter(Predicate filter){
        if(filter != null){
            setMediaList(mTrackOrganizer.findMedia(filter));
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
    
    /**
     * Removes the specified rows.
     * 
     * @param rows The row indexes to remove.
     */
    public void deleteRows(int[] rows){
        
         Arrays.sort(rows);
        
         for(int i=0; i < rows.length; i++){
             
             // Delete in reverse order to prevent invalid indexes.
             int deleteIndex = rows[rows.length - 1 - i];
             
             Media media;
             if(mIsFiltered){
                 media = mFilteredMedia.get(deleteIndex);
                 mFilteredMedia.remove(deleteIndex);
             }else{
                 media = mTrackOrganizer.getMediaAt(deleteIndex);
             }
             
             mTrackOrganizer.deleteMedia(media);
                    
         }
        
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
