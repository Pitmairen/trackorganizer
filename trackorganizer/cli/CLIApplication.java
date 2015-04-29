/*
 * Command line user interface
 *
 * Usage:
 * 
 *  java -cp trackorganizer.jar cli.CLIApplication [arguments]
 * 
 *  e.g:
 *  java -cp trackorganizer.jar cli.CLIApplication --help
 *  java -cp trackorganizer.jar cli.CLIApplication -stt "Track title"
 *
 */
package cli;

import backend.Media;
import backend.SampleData;
import backend.SearchTracks;
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
        
        mCommands.addCommand("lm", "list-all-media", 
            "List all the medium in the archive", false, new ListAllMediaCommand());
        
        mCommands.addCommand("lt", "list-all-tracks", 
            "List all the tracks in the archive", false, new ListAllTracksCommand());
        
        mCommands.addCommand("ste", "search-track-exact", 
            "Search by track title", true, new SearchByTitleExactCommand());
        mCommands.addCommand("stc", "search-track-contains", 
            "Search by track title contains word", true, new SearchByTitleContainsCommand());
        

    }

    
    private void formatTrackList(ArrayList<Track> tracks){
        
        System.out.println("Found " + tracks.size() + " tracks:");
        for(Track t : tracks){
            System.out.println(t.getClass().getSimpleName() + ": " + t.getDescriptionString());
        }
        
        
        
    }
    
    
    private void formatMediaList(ArrayList<Media> medialist){
        
        System.out.println("Found " + medialist.size() + " medium:");
        for(Media m : medialist){
            System.out.println(m.getClass().getSimpleName() + ": " + m.getName());
        }
        
        
        
    }
    

    private class SearchByTitleExactCommand extends Command{
    
        @Override
        public void execute(CommandLine line)
        {
                
            ArrayList<Track> match = mTrackOrganizer.findTracks(
                new SearchTracks.ByTitle(line.getOptionValue("search-track-exact", "")).exact()
            );
            
            formatTrackList(match);
            
        }
        
    }
    
    
    private class SearchByTitleContainsCommand extends Command{
    
        @Override
        public void execute(CommandLine line)
        {
                
            ArrayList<Track> match = mTrackOrganizer.findTracks(
                new SearchTracks.ByTitle(line.getOptionValue("search-track-contains", "")).contains()
            );
            
            formatTrackList(match);
            
        }
        
    }
    
    
    private class ListAllTracksCommand extends Command{
    
        @Override
        public void execute(CommandLine line)
        {
                
            ArrayList<Track> allTracks = mTrackOrganizer.findTracks((Object o) ->{
                return true;});
            
            formatTrackList(allTracks);
            
        }
        
    }
    
    
    private class ListAllMediaCommand extends Command{
    
        @Override
        public void execute(CommandLine line)
        {
                
            ArrayList<Media> mediaList = mTrackOrganizer.getMediaList();
            
            formatMediaList(mediaList);
            
        }
        
    }
}
