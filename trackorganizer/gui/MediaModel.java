
package gui;

import backend.MusicTrack;
import backend.Track;
import backend.TrackOrganizer;
import javax.swing.table.AbstractTableModel;


public class MediaModel extends AbstractTableModel {
    
    private String[] columnNames = {"Title", "Artist"};
   
    TrackOrganizer trackOrganizer;
    
    public MediaModel(TrackOrganizer trackOrganizer){
        this.trackOrganizer = trackOrganizer;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return trackOrganizer.getTrackCount();
    }
    

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        
        
        Track track = trackOrganizer.getTrackAt(row);
        switch(col){
            case 0:
                return track.getTitle();
            case 1:
                if(track instanceof MusicTrack){
                    return ((MusicTrack)track).getArtist();
                }
                return "";

        }
        return "UNKNOWN";
    }
    
}
