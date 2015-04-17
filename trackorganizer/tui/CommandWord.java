/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tui;

/**
 *
 * @author tor-martin
 */
public enum CommandWord {

    // A value for each command word along with its
    // corresponding user interface string.
    ADDMEDIA("addmedia"), REMOVEMEDIA("removemedia"), CHANGEMEDIA("changemedia"), SEARCHMEDIA("searchmedia"),  LISTCONTENT("listcontent"),QUIT("quit"), HELP("help"), UNKNOWN("?");

    // The command string.
    private String commandString;

    /**
     * Initialise with the corresponding command word.
     *
     * @param commandWord The command string.
     */
    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    /**
     * @return The command word as a string.
     */
    public String toString() {
        return commandString;
    }
}
