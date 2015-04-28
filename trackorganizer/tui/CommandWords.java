/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tui;

import backend.Media;
import backend.SampleData;
import backend.Track;
import backend.TrackOrganizer;
import java.util.ArrayList;

/**
 *
 * @author tor-martin
 */
public class CommandWords {

    private ArrayList<String> tasks;
    private ArrayList<String> mediaTypes;
    private ArrayList<String> trackTypes;
    
    private TrackOrganizer to;
    private SampleData sd;
    private ArrayList<Media> tracks;
    private Track track;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        tasks = new ArrayList<String>();
        addTasks();
        mediaTypes = new ArrayList<String>();
        addMediaTypes();
        trackTypes = new ArrayList<String>();
        addTrackTypes();

        to = new TrackOrganizer("Test");
        
        sd = new SampleData();
        sd.fillMedia(to);
        
        tracks = new ArrayList<Media>();
        tracks = to.getMediaList();
        
    }

    public void addMedia() {

    }

    public void removeMedia() {

    }

    public void changeMedia() {

    }

    public void searchMedia() {

    }

    public void listContent() {
        for (int a = 0; a < tracks.size(); a++) {
            track = to.getTrackAt(a);
            System.out.println((a + 1) + ". " + track.getDescriptionString());
        }
    }

    public void help() {
        System.out.println("Type number to execute corresponding task");
        for (int a = 0; a < tasks.size(); a++) {
            System.out.println(tasks.get(a));
        }
    }

    public boolean quit() {
        System.out.println("--- Exiting archive ---");
        return true;
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }

    private void addTasks() {
        tasks.add("   1. Add Media");
        tasks.add("   2. Remove Media");
        tasks.add("   3. Change Media");
        tasks.add("   4. Search Media");
        tasks.add("   5. List Content");
        tasks.add("   6. Help");
        tasks.add("   7. Quit");
    }

    private void addMediaTypes() {
        mediaTypes.add("1. HD");
        mediaTypes.add("2. CD");
        mediaTypes.add("3. LP");
        mediaTypes.add("4. Tape");
    }
    
    private void addTrackTypes(){
        trackTypes.add("1. Music Track");
        trackTypes.add("2. Sound Effect Track");
        trackTypes.add("3. News Track");
        trackTypes.add("4. Advertisement Track");
    }
}
  