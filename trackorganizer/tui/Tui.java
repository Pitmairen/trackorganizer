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
public class Tui {

    private Parser parser;

    public Tui() {
        parser = new Parser();
    }

    public void run() {
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
                //Insert function here
                break;

            case REMOVEMEDIA:
                //Insert function here
                break;

            case CHANGEMEDIA:
                //Insert function here
                break;
               
            case SEARCHBYARCHIVENR:
                //Insert function here
                break;
                
            case SEARCHBYARTIST:
                //Insert function here
                break;
                
            case SEARCHBYTITLE:
                //Insert function here
                break;
                
            case LISTALLCONTENT:
                //Insert function here
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
}
