/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
 *
 * @author pitmairen
 */
public abstract class AbstractDialog {
    
    
    private JDialog mDialog;
    private JButton mCreate = new JButton("Save");
    private JButton mCancel = new JButton("Cancel");
    private boolean mIsValid = false;
    
    
    public AbstractDialog(String title, JFrame frame){
        
        mDialog = new JDialog(frame, title, true);
        mDialog.setLocationRelativeTo(frame);
    }
    
    
    /**
     * Creates the dialog GUI components
     */
    protected abstract JPanel createDialogContent();
    
    /**
     * Validate input
     * @return A list of errors.
     */
    protected abstract ArrayList<String> validateInput();   
    
    
    /**
     * Show the dialog.
     */
    public void show(){
        
        createDefaultContent();
        attachEventListeners();
        mDialog.setVisible(true);
    }
    
        /**
     * Returns true or false depending on if the input from the user was valid.
     * @return boolean indicating if the user input is valid.
     */
    public boolean inputIsValid(){
        return mIsValid;
    }
    
    
    
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
    
    
    private void attachEventListeners() {

        mCreate.addActionListener((ActionEvent e) -> {
            onCreate();
        });
        mCancel.addActionListener((ActionEvent e) -> {
            mDialog.setVisible(false);
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
