

package gui;

import backend.Media;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Abstract class for media add/edit media dialogs.
 */
public abstract class MediaDialog {

    
    private JDialog mDialog;
    private Media mMedia;
    private JButton mCreate = new JButton("Create");
    private JButton mCancel = new JButton("Cancel");
    private boolean mIsValid = false;
    
    public MediaDialog(String title, JFrame frame){
        
        mDialog = new JDialog(frame, title, true);
        
    }
    
    /**
     * Show the dialog.
     */
    public void show(){
        
        createDefaultContent();
        attachEventListeners();
        mDialog.setVisible(true);
    }
    
    /**
     * Set the media object
     * @param media A media object
     */
    public void setMediaObject(Media media){
        mMedia = media;
    }
    
    /**
     * Returns the media object created form the content in the dialog.
     * @return A media object.
     */
    public Media getMediaObject(){
        
        return mMedia;
    }
   
    /**
     * Returns true or false depending on if the input from the user was valid.
     * @return boolean indicating if a new media object should be created.
     */
    public boolean shouldCreateMedia(){
        return mIsValid;
    }
    
    /**
     * Creates a new media object.
     * @return A new media object.
     */
    public abstract Media createMediaObject();
    
    
    /**
     * Creates the dialog GUI components
     */
    protected abstract JPanel createDialogContent();
    
    /**
     * Validate input
     */
    protected abstract ArrayList<String> validateInput();   
    
    
    
    private void createDefaultContent(){
        
        JPanel contentPane = (JPanel) mDialog.getContentPane();
        
        
        JPanel buttons= new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.add(mCreate);
        buttons.add(mCancel);

        
        contentPane.add(createDialogContent(), BorderLayout.PAGE_START);
        contentPane.add(buttons, BorderLayout.PAGE_END);
               
        
        
        mDialog.pack();

    }
    
    private void attachEventListeners(){
        
        mCreate.addActionListener((ActionEvent e) -> {
            System.out.println("Create");
            onCreate();
        });
    
    }
    
    private void onCreate(){
        
        ArrayList<String> errors = validateInput();
        
        if(errors.size() > 0){
            JOptionPane.showMessageDialog(mDialog,
                                          joinErrorString(errors),
                                          "Validation Error",
                                          JOptionPane.ERROR_MESSAGE);

            
        }else{
            mIsValid = true;
            mDialog.setVisible(false);
        }
        
        
    }
    
    private String joinErrorString(ArrayList<String> errors){
        StringBuilder sb = new StringBuilder();
        for(String s : errors)
        {
            sb.append(s);
            sb.append("\n");
        }

        return sb.toString();

    }
}
