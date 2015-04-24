package gui;

import backend.Media;
import backend.Predicate;
import backend.SampleData;
import backend.SearchMedia;
import backend.SearchTracks;
import backend.TrackOrganizer;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.xswingx.PromptSupport;


/**
 * The main application window
 */
public class MainWindow extends JFrame
{

    private TrackOrganizer mTrackOrganizer;
    private MediaListModel mMediaModel;
    private TrackListModel mTrackModel;
    
    private JTextField mMediaFilter = new JTextField();
    private JTextField mTrackFilter = new JTextField();
    
    private JButton mNewMedia = new JButton("Add Media");
    private JButton mDeleteMedia = new JButton("Delete Media");
    private JButton mDeleteTrack = new JButton("Delete Track");
    private JButton mShowAllTracks = new JButton("Show All Tracks");
    
    private JComboBox mTrackFilterType;
    private JComboBox mMediaFilterType;
    
    private JPopupMenu mNewMediaMenu = new JPopupMenu("Media Menu");
    
    private JTable mMediaTable;
    private JTable mTrackTable;
    

    
    
    public MainWindow()
    {
        super("TrackOrganizer");

        createTrackOrganizerObjects();
        
        makeGUIComponents();
        setupEventHandlers();
        
        this.setVisible(true);
    }

    private void createTrackOrganizerObjects()
    {

        mTrackOrganizer = new TrackOrganizer("Track organizer");
        SampleData samples = new SampleData();
        samples.fillMedia(mTrackOrganizer);
        
        mMediaModel = new MediaListModel(mTrackOrganizer);
        mTrackModel = new TrackListModel(mTrackOrganizer);
    }

    
    private void makeGUIComponents()
    {
        // Create textfield placeholders.
        PromptSupport.setPrompt("Search media", mMediaFilter);
        PromptSupport.setPrompt("Search tracks", mTrackFilter);
        

        Filter[] trackFilters = {
            new FilterTracksByTitle(), new FilterTracksByArtist(),
        };
        
        mTrackFilterType = new JComboBox(trackFilters);
        
        Filter[] mediaFilters = {
            new FilterMediaByName(), new FilterMediaByArtist(),
        };
        
        mMediaFilterType = new JComboBox(mediaFilters);   
        
        mShowAllTracks.setEnabled(false);
        
        mTrackTable = new JTable(mTrackModel);
        
        mMediaTable = new JTable(mMediaModel){

            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }

        };
        
        mMediaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mMediaTable.setRowHeight(68);
        mMediaTable.getColumnModel().getColumn(0).setMaxWidth(72);
        mMediaTable.getColumnModel().getColumn(0).setMinWidth(72);

        // Create media list section
        JPanel mediaPanel = new JPanel();
        JPanel mediaFilterPanel = new JPanel();
        mediaFilterPanel.setLayout(new BoxLayout(mediaFilterPanel, BoxLayout.X_AXIS));
        mediaFilterPanel.add(mMediaFilter);
        mediaFilterPanel.add(mMediaFilterType);
        mediaPanel.setLayout(new BoxLayout(mediaPanel, BoxLayout.Y_AXIS));
        mediaPanel.add(mediaFilterPanel);
        mediaPanel.add(new JScrollPane(mMediaTable));
        JPanel mediaButtons = new JPanel();
        mediaButtons.setLayout(new FlowLayout(FlowLayout.LEADING));
        mediaButtons.add(mNewMedia);
        mediaButtons.add(mDeleteMedia);
        mediaPanel.add(mediaButtons);

        // Create track list section
        JPanel trackPanel = new JPanel();
        JPanel trackFilterPanel = new JPanel();
        trackFilterPanel.setLayout(new BoxLayout(trackFilterPanel, BoxLayout.X_AXIS));
        trackFilterPanel.add(mTrackFilter);
        trackFilterPanel.add(mTrackFilterType);
        trackPanel.setLayout(new BoxLayout(trackPanel, BoxLayout.Y_AXIS));
        trackPanel.add(trackFilterPanel);
        trackPanel.add(new JScrollPane(mTrackTable));
        JPanel trackButtons = new JPanel();
        trackButtons.setLayout(new FlowLayout(FlowLayout.LEADING));
        trackButtons.add(mDeleteTrack);
        trackButtons.add(mShowAllTracks);
        trackPanel.add(trackButtons);
        

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(mediaPanel);
        mainPanel.add(trackPanel);
        
        
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(mainPanel);

        this.pack();

    }
    
    
    private void setupEventHandlers(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mDeleteTrack.addActionListener((ActionEvent e) -> {
            deleteSelectedTracks();
        });
        
        mDeleteMedia.addActionListener((ActionEvent e) -> {
            deleteSelectedMedias();
        });
        
        mMediaFilter.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filterMediaTable((JTextField) e.getSource());
            }
        });
        
        mTrackFilter.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filterTrackTable((JTextField) e.getSource());
            }
        });
        
        mMediaTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            
            ListSelectionModel lm = (ListSelectionModel)e.getSource();
            
            if(lm.getValueIsAdjusting())
                return;

            handlesMediaTableSelection(lm);


        });
        
        
        
        JFrame frame = this;

        mNewMediaMenu.add("CD").addActionListener((ActionEvent e) -> {
                handleNewMediaDialog(new NewCDDialog(frame));
        });
        mNewMediaMenu.add("LP").addActionListener((ActionEvent e) -> {
                handleNewMediaDialog(new NewLPDialog(frame));
        });
        mNewMediaMenu.add("Tape").addActionListener((ActionEvent e) -> {
                handleNewMediaDialog(new NewTapeDialog(frame));
        });
        mNewMediaMenu.add("HD").addActionListener((ActionEvent e) -> {
                 handleNewMediaDialog(new NewHDDialog(frame));
        });
        
        mNewMedia.addActionListener((ActionEvent e) -> {
            showNewMediaMenu();
        });

        mShowAllTracks.addActionListener((ActionEvent e) -> {
            showAllTracks();
        });

    }

    private void filterMediaTable(JTextField textField){
        
        String text = textField.getText();
        if (text.length() > 0) {
            Filter filter = (Filter) mMediaFilterType.getSelectedItem();
            mMediaModel.setFilter(filter.createPredicate(text));
        } else {
            mMediaModel.setFilter(null);
        }
        
    }
    
    
    private void filterTrackTable(JTextField textField){
        
        String text = textField.getText();
        if(text.length() > 0){
            Filter filter = (Filter) mTrackFilterType.getSelectedItem();
            mTrackModel.setFilter(filter.createPredicate(text));
        }else{
            mTrackModel.setFilter(null);
        }
    }
    
    private void handlesMediaTableSelection(ListSelectionModel lm){
        
        if (lm.isSelectionEmpty()) {
            showAllTracks();
        } else {
            int row = lm.getMinSelectionIndex();
            Media m = mTrackOrganizer.getMediaList().get(row);
            showMediaTracks(m);
        }

    }
    
    private void showMediaTracks(Media media){
        mTrackModel.setMedia(media);
        mTrackModel.setTrackList(media.getTracks());
        mShowAllTracks.setEnabled(true);
        filterTrackTable(mTrackFilter);
  
    }
    private void deleteSelectedTracks(){
        
        int[] rows = mTrackTable.getSelectedRows();
        mTrackModel.deleteRows(rows);
        mTrackModel.fireTableDataChanged();

    }
    
    private void deleteSelectedMedias(){
        
        int[] rows = mMediaTable.getSelectedRows();
        mMediaModel.deleteRows(rows);
        
        mMediaModel.fireTableDataChanged();

    }
    
    private void showAllTracks(){
        mTrackModel.setMedia(null);
        mTrackModel.setFilter(null);
        mShowAllTracks.setEnabled(false);
        mMediaTable.clearSelection();
        filterTrackTable(mTrackFilter);
    }
    
    private void showNewMediaMenu(){
        mNewMediaMenu.show(mNewMedia, mNewMedia.getWidth()/2, mNewMedia.getHeight()/2);
    }
    
    private void handleNewMediaDialog(MediaDialog dialog){
  
        dialog.show();
        if (dialog.shouldCreateMedia()) {
            Media m = dialog.createMediaObject();
            mTrackOrganizer.addMedia(m);
            mMediaModel.fireTableDataChanged();
        }
        
    }
    

    private abstract class Filter{
        
        public abstract Predicate createPredicate(String query);
    }
    
    
    private class FilterTracksByTitle extends Filter{
        @Override
        public Predicate createPredicate(String query){
            return new SearchTracks.ByTitle(query).contains();
        }
        
        @Override
        public String toString(){
            return "Title";
        }
        
    }
    
    private class FilterTracksByArtist extends Filter{
        @Override
        public Predicate createPredicate(String query){
            return new SearchTracks.ByArtist(query).contains();
        }
        
        @Override
        public String toString(){
            return "Artist";
        }
        
    }
    
    private class FilterMediaByName extends Filter{
        @Override
        public Predicate createPredicate(String query){
            return new SearchMedia.ByName(query);
        }
        
        @Override
        public String toString(){
            return "Title";
        }
        
    }
    
    private class FilterMediaByArtist extends Filter{
        @Override
        public Predicate createPredicate(String query){
            return new SearchMedia.ByArtist(query);
        }
        
        @Override
        public String toString(){
            return "Artist";
        }
        
    }
}
