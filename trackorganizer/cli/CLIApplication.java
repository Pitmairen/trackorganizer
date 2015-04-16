/*
 * Command line user interface
 */
package cli;

import backend.SampleData;
import backend.Track;
import backend.TrackOrganizer;
import java.util.ArrayList;
import org.apache.commons.cli.CommandLine;


/**
 * The main application for the text based user interface
 * 
 * @author Per Myren
 */
public class CLIApplication {
    
    CommandHandler mCommands = new CommandHandler();
    TrackOrganizer mTrackOrganizer = new TrackOrganizer("TO");
    /**
     * Run the application
     * 
     * @param args Command line arguments.
     */
    public void run(String[] args){
        
        createCommands();
        
        SampleData samples = new SampleData();
        samples.addCds(mTrackOrganizer);

        
        if(args.length == 0)
            mCommands.execute(new String[]{"-help"});
        else
            mCommands.execute(args);

    }
    
    /**
     * Main entry point for the application
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        
        CLIApplication app = new CLIApplication();
        
        app.run(args);

    }
    
    
    
    private void createCommands(){
        
        mCommands.addCommand("stt", "search-track-title", 
            "Search by track title", true, new SearchByTitleCommand());

    }

    
    private void formatTrackList(ArrayList<Track> tracks){
        
        System.out.println("Found " + tracks.size() + " tracks:");
        for(Track t : tracks){
            System.out.println(t.getTitle());
        }
        
        
        
    }
    

    private class SearchByTitleCommand extends Command{
    
        @Override
        public void execute(CommandLine line)
        {
                
            ArrayList<Track> match = mTrackOrganizer.findTracksByTitleExact(
                line.getOptionValue("search-track-title", ""));
            
            formatTrackList(match);
            
        }
        
    }
}
