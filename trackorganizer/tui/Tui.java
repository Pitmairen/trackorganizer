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
    private CommandWords commands;

    public Tui() {
        welcome();
        parser = new Parser();
        commands = new CommandWords();
        commands.help();

    }

    public void run() {
        boolean finished = false;
        while (!finished) {
            finished = parser.getCommand();
        }
        System.exit(0);
    }

    private void welcome() {
        System.out.println("Welcome to the media organizingsystem\n");
    }

}
