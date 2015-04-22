
package gui;

import backend.DurationHandler;
import backend.Media;
import backend.MusicTrack;
import backend.Predicate;
import backend.SearchTracks;
import backend.Track;
import backend.TrackOrganizer;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;

/**
 * Track list model
 */
public class TrackListModel extends AbstractTableModel {
    
    private String[] mColumnNames = {"Title", "Artist", "Duration"};
   
    private TrackOrganizer mTrackOrganizer;
    
    private Media mCurrentMedia;
    
    private ArrayList<Track> mFilteredTracks;
    private boolean mIsFiltered = false;

    
    
    public TrackListModel(TrackOrganizer trackOrganizer){
        this.mTrackOrganizer = trackOrganizer;
    }

    
    /**
     * Filters the content of the model.
     *
     * @param filter The filter string
     */
    public void setFilter(Predicate filter){
        if(filter != null){
            
            if(mCurrentMedia != null){
               ArrayList<Track> tracks = new ArrayList<>();
               SearchTracks.filterTrackList(mCurrentMedia.getTracks(), tracks, filter);
               setTrackList(tracks);
            }else{
               setTrackList(mTrackOrganizer.findTracks(filter));
            }
        }else{
            if(mCurrentMedia != null)
                setTrackList(mCurrentMedia.getTracks());
            else
                setTrackList(null);
        }
    }
    
    /**
     * Sets the current list of track objects to display
     *
     * @param tracks A list of track objects to display.
     */
    public void setTrackList(ArrayList<Track> tracks){
   
        mFilteredTracks = tracks;
        mIsFiltered = tracks != null;

        this.fireTableDataChanged();
    }

    /**
     * Sets the current media object to display.
     *
     * Only the tracks on the specified media will be shown.
     *
     * @param media A media object.
     */
    public void setMedia(Media media){
        this.mCurrentMedia = media;
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
             
             System.out.println(deleteIndex);
             Track track;
             if(mIsFiltered){
                 track = mFilteredTracks.get(deleteIndex);
                 mFilteredTracks.remove(deleteIndex);
             }else{
                 track = mTrackOrganizer.getTrackAt(deleteIndex);
             }
             
             track.getMedia().removeTrack(track);
             
                    
         }
        
    }
    
    
    @Override
    public int getColumnCount() {
        return mColumnNames.length;
    }

    @Override
    public int getRowCount() {
        if(mIsFiltered){
            return mFilteredTracks.size();
        }
        return mTrackOrganizer.getTrackCount();
    }
    

    @Override
    public String getColumnName(int col) {
        return mColumnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        
        Track track;
        
        if(mIsFiltered){
            track = mFilteredTracks.get(row);
        }else{
            track = mTrackOrganizer.getTrackAt(row);

        }
        
        switch(col){
            case 0:
                return track.getTitle();
            case 1:
                if(track instanceof MusicTrack){
                    return ((MusicTrack)track).getArtist();
                }
                return "";
            case 2:
                 return DurationHandler.durationToString(track.getDuration());


        }
        return "UNKNOWN";
    }
    
}
