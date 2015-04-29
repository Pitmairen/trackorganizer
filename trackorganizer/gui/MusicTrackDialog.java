/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import backend.MusicTrack;
import backend.Track;
import java.awt.GridLayout;
import java.time.Duration;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.xswingx.PromptSupport;


public class MusicTrackDialog extends TrackDialog {

    private JTextField mTitle = new JTextField(20);
    private JTextField mArtistName = new JTextField(20);
    private JTextField mDuration = new JTextField(20);

    
    private JLabel mTitleLabel = new JLabel("Title");
    private JLabel mArtistNameLabel = new JLabel("Artist");
    private JLabel mDurationLabel = new JLabel("Duration (seconds)");

    
    
    public MusicTrackDialog(JFrame frame){
        
        super("New Music Track", frame);

        // Add placeholders for the input fields.
        PromptSupport.setPrompt("Title", mTitle);
        PromptSupport.setPrompt("Artist", mArtistName);
        PromptSupport.setPrompt("Duration", mDuration);

       
    }  
    
    @Override
    public Track createTrackObject() {
        return new MusicTrack(mTitle.getText(),
                      mArtistName.getText(),
                      Duration.ofSeconds(Integer.parseInt(mDuration.getText())));
    }

    
    @Override
    public void updateTrackObject() {
        if(!(getTrackObject() instanceof MusicTrack))
            return;        
        MusicTrack t = (MusicTrack)getTrackObject();
        
        t.setTitle(mTitle.getText());
        t.setArtist(mArtistName.getText());
        t.setDuration(Duration.ofSeconds(Integer.parseInt(mDuration.getText())));


    }

    @Override
    protected void loadTrackContent() {
       if(!(getTrackObject() instanceof MusicTrack))
            return;        
         
        MusicTrack t = (MusicTrack)getTrackObject();
        
        mTitle.setText(t.getTitle());
        mArtistName.setText(t.getArtist());
        mDuration.setText(Long.toString(t.getDuration().getSeconds()));
        
    }

    @Override
    protected JPanel createDialogContent() {
        JPanel content = new JPanel();
        
        content.setLayout(new GridLayout(3, 2));
        content.add(mTitleLabel);
        content.add(mTitle);
        content.add(mArtistNameLabel);
        content.add(mArtistName);
        content.add(mDurationLabel);

        content.add(mDuration);


        
        return content;
        
    }

    @Override
    protected ArrayList<String> validateInput() {
        
        ArrayList<String> errors = new ArrayList<String>();
        if(mTitle.getText().length() == 0)
            errors.add("The cd must have a title.");
        if(mArtistName.getText().length() == 0)
            errors.add("The cd must have an artist.");

        String duration = mDuration.getText();
        try{
            Integer.parseInt(duration);
        } catch(NumberFormatException e){
            errors.add("Duration must be an integer.");
        }
        
        return errors;
    }
    
}
