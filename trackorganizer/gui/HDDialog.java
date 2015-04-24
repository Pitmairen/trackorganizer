
package gui;

import backend.HD;
import backend.Media;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.xswingx.PromptSupport;


public class HDDialog extends MediaDialog {
    
    private JTextField mName = new JTextField(20);
    private JLabel mNameLabel = new JLabel("Name");
    
    public HDDialog(JFrame frame) {

        super("New HD", frame);

        // Add placeholders for the input fields.
        PromptSupport.setPrompt("HD Name", mName);


    }
        
     /**
     * Creates a new HD object from the user input.
     * @return a new HD object.
     */
    @Override
    public Media createMediaObject()
    {
        return new HD(mName.getText());
    }
    
    /**
     * Update the media object
     */
    @Override
    public void updateMediaObject()
    {
        if(!(getMediaObject() instanceof HD))
            return;        
        
        HD hd = (HD)getMediaObject();
        
        hd.setName(mName.getText());

    }
    
    
     /**
     * Load media content.
     */
    @Override
    protected void loadMediaContent(){
        
        if(!(getMediaObject() instanceof HD))
            return;        
        
        HD hd = (HD)getMediaObject();
        
        mName.setText(hd.getName());

        
    }
    
    
    @Override
    protected ArrayList<String> validateInput()
    {
        ArrayList<String> errors = new ArrayList<String>();
        if(mName.getText().length() == 0)
            errors.add("The HD must have a name.");
        return errors;
    } 


    @Override
    protected JPanel createDialogContent()
    {
        JPanel content = new JPanel();
        
        content.setLayout(new GridLayout(1, 2));
        content.add(mNameLabel);
        content.add(mName);
        
        return content;
        
    }
    
}
