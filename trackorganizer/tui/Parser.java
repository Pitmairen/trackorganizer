/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tui;

import backend.DurationHandler;
import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tor-martin
 */
public class Parser {

    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public boolean getCommand() {
        boolean result = false;

        int selectedFunction = getUserMenuSelection(commands.getNumberOfTasks());

        if (selectedFunction == 1) {
            String selectedMediaType = mediaTypeSelection(selectedFunction, "add");
            String selectedTrackType = trackTypeSelection(selectedFunction, "add");
            //Get required input
            System.out.println("Enter artist name:");
            String artistName = getTextInput();
            System.out.println("Enter song title:");
            String songTitle = getTextInput();
            System.out.println("Enter duration in seconds:");
            long timeLasting = getDurationInput();
            DurationHandler duration = new DurationHandler(timeLasting);
            System.out.println(artistName + ", " + songTitle + " , " + duration.formatDuration());

        } else if (selectedFunction == 2) {
            String selectedMediaType = mediaTypeSelection(selectedFunction, "add");
            String selectedTrackType = trackTypeSelection(selectedFunction, "add");

        } else if (selectedFunction == 3) {
            String selectedMediaType = mediaTypeSelection(selectedFunction, "add");
            String selectedTrackType = trackTypeSelection(selectedFunction, "add");

        } else if (selectedFunction == 4) {
            String selectedMediaType = mediaTypeSelection(selectedFunction, "add");
            String selectedTrackType = trackTypeSelection(selectedFunction, "add");

        } else if (selectedFunction == 5) {
            commands.listContent();

        } else if (selectedFunction == 6) {
            commands.help();

        } else if (selectedFunction == 7) {
            result = commands.quit();

        }

        return result;
    }

    private int getUserMenuSelection(int max) {
        boolean validInput = false;
        int selection = 0;

        while (!validInput) {
            try {
                selection = reader.nextInt();
                if ((selection <= max) && (selection > 0)) {
                    validInput = true;
                } else {
                    System.out.print("You must provide a number between 1 and "
                            + max + "\n>");
                }
            } catch (InputMismatchException ime) {
                System.out.print("Your input must be an integer (a positiv number)\n>");
                // Empty the Scanner
                reader.next();
            }
        }
        return selection;
    }

    private String getTextInput() {
        boolean validInput = false;
        String selection = "";
        while (!validInput) {
            try {
                selection = reader.next();
                if ((!selection.equals("")) && (selection.length() <= 50)) {
                    validInput = true;
                } else {
                    System.out.print("You must provide text in this field, no longer than 50 characters");
                }
            } catch (InputMismatchException ime) {
                System.out.print("Your input must be an integer (a positiv number)\n>");
                // Empty the Scanner
                reader.next();
            }
        }
        return selection;
    }

    private long getDurationInput() {
        boolean validInput = false;
        long selection = 0;

        while (!validInput) {
            try {
                selection = reader.nextLong();
                if ((selection <= 359999) && (selection > 0)) {
                    validInput = true;
                } else {
                    System.out.print("You must provide a number between 1 and "
                            + 359999 + "\n>");
                }
            } catch (InputMismatchException ime) {
                System.out.print("Your input must be an integer (a positiv number)\n>");
                // Empty the Scanner
                reader.next();
            }
        }
        return selection;
    }

    private String mediaTypeSelection(int selFunc, String action) {
        //Select Media type
        selFunc = getUserMenuSelection(commands.mediaStage1(action));
        return commands.typeSelected(selFunc, "HD", "CD", "LP", "Tape");
    }

    private String trackTypeSelection(int selFunc, String action) {
        //Select track type
        selFunc = getUserMenuSelection(commands.mediaStage2(action));
        return commands.typeSelected(selFunc, "Music", "SFX", "News", "Advertisement");

    }
}

//addmedia, removemedia, changemedia, searchmedia, listcontent, quit, help, unknown
//Search by archiveNR
//Search by Tracks by title
//Search Tracks by artist 
//List all content
