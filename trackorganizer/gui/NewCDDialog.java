
package gui;

import backend.CD;
import backend.Media;
import java.awt.GridLayout;
import java.time.Year;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.xswingx.PromptSupport;

/**
 * Dialog for creating new CDs.
 */
public class NewCDDialog extends MediaDialog
{
    
    private JTextField mTitle = new JTextField(20);
    private JTextField mArtistName = new JTextField(20);
    private JTextField mReleaseYear = new JTextField(20);
    private JTextField mRecordLabel = new JTextField(20);
    private JTextField mArchiveNR =  new JTextField(20);
    
    private JLabel mTitleLabel = new JLabel("Title");
    private JLabel mArtistNameLabel = new JLabel("Artist");
    private JLabel mReleaseYearLabel = new JLabel("Year");
    private JLabel mRecordLabelLabel = new JLabel("Record Label");
    private JLabel mArchiveNRLabel =  new JLabel("Archive number");
    
    
    public NewCDDialog(JFrame frame){
        
        super("New CD", frame);

        // Add placeholders for the input fields.
        PromptSupport.setPrompt("CD Title", mTitle);
        PromptSupport.setPrompt("Artist", mArtistName);
        PromptSupport.setPrompt("Release year", mReleaseYear);
        PromptSupport.setPrompt("Record label", mRecordLabel);
        PromptSupport.setPrompt("Archive number (10000 <= n < 20000)", mArchiveNR);
       
    }
    
    /**
     * Creates a new CD from the user input
     * @return 
     */
    @Override
    public Media createMediaObject()
    {
        return new CD(mTitle.getText(),
                      mArtistName.getText(),
                      Year.of(Integer.parseInt(mReleaseYear.getText())),
                      mRecordLabel.getText(),
                      Integer.parseInt(mArchiveNR.getText()));
    }

    
    @Override
    protected ArrayList<String> validateInput()
    {
        ArrayList<String> errors = new ArrayList<String>();
        if(mTitle.getText().length() == 0)
            errors.add("The cd must have a title.");
        if(mArtistName.getText().length() == 0)
            errors.add("The cd must have an artist.");
        if(mRecordLabel.getText().length() == 0)
            errors.add("The cd must have an record label.");
        
        String year = mReleaseYear.getText();
        try{
            Integer.parseInt(year);
        } catch(NumberFormatException e){
            errors.add("Year must be an integer.");
        }
        
        String nrStr = mArchiveNR.getText();
        try{
            int nrInt = Integer.parseInt(nrStr);
            if(!(nrInt >= 10000 && nrInt < 20000))
                errors.add("Archive number must be in the range 10000-19999");
            
        } catch(NumberFormatException e){
            errors.add("Archive number must be an integer.");
        }

        return errors;
    } 


    @Override
    protected JPanel createDialogContent()
    {
        JPanel content = new JPanel();
        
        content.setLayout(new GridLayout(5, 2));
        content.add(mTitleLabel);
        content.add(mTitle);
        content.add(mArtistNameLabel);
        content.add(mArtistName);
        content.add(mReleaseYearLabel);

        content.add(mReleaseYear);
        content.add(mRecordLabelLabel);

        content.add(mRecordLabel);
        content.add(mArchiveNRLabel);

        content.add(mArchiveNR);
        
        return content;
        
    }
    
}
