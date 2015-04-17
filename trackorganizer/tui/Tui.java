/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tui;

import backend.SampleData;
import backend.SearchTracks;
import backend.Track;
import backend.TrackOrganizer;

/**
 *
 * @author tor-martin
 */
public class Tui {

    private Parser parser;
    private TrackOrganizer to;
    private SampleData sd;
    
    public Tui() {
        parser = new Parser();
    }

    public void run() {
        importArchive();
        info();
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

    }

    private void info() {
        System.out.println("Welcome to the media organizingsystem\n");
        printHelp();
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Unknown command");
                break;

            case HELP:
                printHelp();
                break;

            case ADDMEDIA:
                addMedia();
                break;

            case REMOVEMEDIA:
                removeMedia();
                break;

            case CHANGEMEDIA:
                changeMedia();
                break;

            case SEARCHMEDIA:
                searchMedia();
                break;

            case LISTCONTENT:
                listContent();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    private void printHelp() {
        System.out.println("Your commands are:");
        parser.showCommands();
    }

    private void addMedia() {

    }

    private void removeMedia() {

    }

    private void changeMedia() {

    }

    private void searchMedia() {

    }

    private void listContent() {

    }
    
    private void importArchive(){
        to = new TrackOrganizer("Archive");
        //Not finished
    }
}


