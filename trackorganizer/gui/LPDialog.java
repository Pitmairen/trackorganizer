
package gui;


import backend.LP;
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
 * Dialog for creating new LPs.
 */
public class LPDialog extends MediaDialog
{
    
    private JTextField mTitle = new JTextField(20);
    private JTextField mArtistName = new JTextField(20);
    private JTextField mReleaseYear = new JTextField(20);
    private JTextField mRecordLabel = new JTextField(20);
    private JTextField mArchiveNR =  new JTextField(20);
    private JTextField mType =  new JTextField(20);
        
    private JLabel mTitleLabel = new JLabel("Title");
    private JLabel mArtistNameLabel = new JLabel("Artist");
    private JLabel mReleaseYearLabel = new JLabel("Year");
    private JLabel mRecordLabelLabel = new JLabel("Record Label");
    private JLabel mArchiveNRLabel =  new JLabel("Archive number");
    private JLabel mTypeLabel =  new JLabel("LP type");
    
    
    public LPDialog(JFrame frame){
        super("New LP", frame);
        
        PromptSupport.setPrompt("LP Title", mTitle);
        PromptSupport.setPrompt("Artist", mArtistName);
        PromptSupport.setPrompt("Release year", mReleaseYear);
        PromptSupport.setPrompt("Record label", mRecordLabel);
        PromptSupport.setPrompt("Archive number (10000 <= n < 20000)", mArchiveNR);
        PromptSupport.setPrompt("Type", mType);
    }
    
    /**
     * Creates a new LP object from the user input.
     * @return a new LP object.
     */
    @Override
    public Media createMediaObject()
    {
        return new LP(mTitle.getText(),
                      mArtistName.getText(),
                      Year.of(Integer.parseInt(mReleaseYear.getText())),
                      mRecordLabel.getText(),
                      Integer.parseInt(mArchiveNR.getText()),
                       mType.getText());
    }
    
    
    
    /**
     * Update the media object
     */
    @Override
    public void updateMediaObject()
    {
        if(!(getMediaObject() instanceof LP))
            return;        
        
        LP lp = (LP)getMediaObject();
        
        lp.setName(mTitle.getText());
        lp.setArtistName(mArtistName.getText());
        lp.setReleaseYear(Year.of(Integer.parseInt(mReleaseYear.getText())));
        lp.setRecordLabel(mRecordLabel.getText());
        lp.setArchiveNR(Integer.parseInt(mArchiveNR.getText()));
        lp.setFormat(mType.getText());
        
    }
    
     /**
     * Load media content.
     */
    @Override
    protected void loadMediaContent(){
        
        if(!(getMediaObject() instanceof LP))
            return;        
        
        LP lp = (LP)getMediaObject();
        
        mTitle.setText(lp.getName());
        mArtistName.setText(lp.getArtistName());
        mReleaseYear.setText(lp.getReleaseYear().toString());
        mRecordLabel.setText(lp.getRecordLabel());
        mArchiveNR.setText(Integer.toString(lp.getArchiveNR()));
        mType.setText(lp.getFormat());
    }
    
    @Override
    protected ArrayList<String> validateInput()
    {
        ArrayList<String> errors = new ArrayList<String>();
        if(mTitle.getText().length() == 0)
            errors.add("You must input a title.");
        if(mArtistName.getText().length() == 0)
            errors.add("The lp must have an artist.");
        if(mRecordLabel.getText().length() == 0)
            errors.add("The lp must have an record label.");
        
        String year = mReleaseYear.getText();
        try{
            Integer.parseInt(year);
        } catch(NumberFormatException e){
            errors.add("Year must be an integer.");
        }
        
        String nrStr = mArchiveNR.getText();
        try{
            int nrInt = Integer.parseInt(nrStr);
            if(!(nrInt >= 20000 && nrInt < 30000))
                errors.add("Archive number must be in the range 20000-29999");
            
        } catch(NumberFormatException e){
            errors.add("Archive number must be an integer.");
        }
        
        if(mType.getText().length() == 0)
            errors.add("The lp must have a type.");
        
        return errors;
    } 


    @Override
    protected JPanel createDialogContent()
    {
        JPanel content = new JPanel();
        
        content.setLayout(new GridLayout(6, 2));
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
        
        content.add(mTypeLabel);

        content.add(mType);
        return content;
        
    }
}
