/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tui;

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

        System.out.print("> ");
        int selectedFunction = getUserMenuSelection(commands.getNumberOfTasks());

        if (selectedFunction == 1) {
            
        }

        if (selectedFunction == 5) {
            commands.listContent();
        }

        if (selectedFunction == 6) {
            commands.help();
        }

        if (selectedFunction == 7) {
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

}

//addmedia, removemedia, changemedia, searchmedia, listcontent, quit, help, unknown
//Search by archiveNR
//Search by Tracks by title
//Search Tracks by artist 
//List all content
