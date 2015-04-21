
package gui;

import backend.CD;
import backend.HD;
import backend.LP;
import backend.Tape;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 * Loads application icons
 * 
 */
public class IconLoader
{
    
    private final static IconLoader mInstance;
    
    static
    {
        mInstance = new IconLoader();
    }
    
    /**
     * Returns an icon for a associated with a class
     * @param cls The class to get an icon for
     * @return An icon
     */
    public static ImageIcon getIcon(Class cls){
        return mInstance.loadIcon(cls);
    }
    
    
    
    
    private HashMap<Class, ImageIcon> mIcons = new HashMap<>();

    private IconLoader(){
        
        Class cls = getClass();
        
        mIcons.put(CD.class, new ImageIcon(cls.getResource("icons/cd.png")));
        mIcons.put(Tape.class, new ImageIcon(cls.getResource("icons/tape.png")));
        mIcons.put(LP.class, new ImageIcon(cls.getResource("icons/lp.png")));
        mIcons.put(HD.class, new ImageIcon(cls.getResource("icons/hd.png")));
    }
    
    private ImageIcon loadIcon(Class cls){
        return mIcons.get(cls);
    }
    
}
