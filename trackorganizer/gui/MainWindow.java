
package gui;

import backend.SampleData;
import backend.TrackOrganizer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainWindow extends JFrame {
 
    TrackOrganizer trackOrganizer;
    MediaModel mediaModel;
    
    public MainWindow()
    {
        super("TrackOrganizer");
           
        createTrackOrganizer();

        mediaModel = new MediaModel(trackOrganizer);
        
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

        
        final JTextField searchInput = new JTextField();
        
        searchInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediaModel.setFilter(searchInput.getText());
            }
        });
        
        
        searchInput.setColumns(40);
        JButton newCDBtn = new JButton("Add CD");
        JButton deleteSelected = new JButton("Delete");

        JPanel topPane = new JPanel();
        topPane.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPane.add(searchInput);
        topPane.add(newCDBtn);
        topPane.add(deleteSelected);
        
        
        JTable tracklist = new JTable(mediaModel);
        
        
        contentPane.add(topPane, BorderLayout.PAGE_START);
        contentPane.add(new JScrollPane(tracklist));
        
        
        this.pack();
        this.setVisible(true);

    }
    
    
    
}
