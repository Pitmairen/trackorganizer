/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tui;

import java.util.HashMap;

/**
 *
 * @author tor-martin
 */
public class CommandWords {

    // A mapping between a command word and the CommandWord
    // associated with it.

    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        validCommands = new HashMap<String, CommandWord>();
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Find the CommandWord associated with a command word.
     *
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN if it is
     * not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Check whether a given String is a valid command word.
     *
     * @param aString
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() {
        validCommands.keySet().stream().forEach((command) -> {
            System.out.println("  " + command);
        });
        System.out.println();
    }
}
