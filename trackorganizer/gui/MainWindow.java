
package gui;

import backend.SampleData;
import backend.TrackOrganizer;
import java.awt.*;
import javax.swing.*;


public class MainWindow extends JFrame {
 
    TrackOrganizer trackOrganizer;
    
    public MainWindow()
    {
        super("TrackOrganizer");
           
        createTrackOrganizer();

        makeFrame();
    }

    private void createTrackOrganizer(){
        
        trackOrganizer = new TrackOrganizer("Track organizer");
        SampleData samples = new SampleData();
        samples.addCds(trackOrganizer);
        
    }
    
    
    private void makeFrame()
    {
        JPanel contentPane = (JPanel) this.getContentPane();

        
        JTextField searchInput = new JTextField();
        searchInput.setColumns(40);
        JButton newCDBtn = new JButton("Add CD");
        JButton deleteSelected = new JButton("Delete");

        JPanel topPane = new JPanel();
        topPane.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPane.add(searchInput);
        topPane.add(newCDBtn);
        topPane.add(deleteSelected);
        
        
        JTable tracklist = new JTable(new MediaModel(trackOrganizer));
        
        
        
        contentPane.add(topPane, BorderLayout.PAGE_START);
        contentPane.add(new JScrollPane(tracklist));
        
        this.pack();
        this.setVisible(true);

    }
    
    
    
}
