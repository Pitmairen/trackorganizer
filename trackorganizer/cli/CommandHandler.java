
package cli;

import java.util.HashMap;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;



/**
 * The CommandHandler parses the arguments from command line and 
 * executes the commands.
 * 
 * @author Per Myren
 */
public class CommandHandler {
 
    final private CommandLineParser mParser = new GnuParser();
    final private Options mOptions = new Options();
    final private HashMap<String, Command> mCommands = new HashMap<>();
    

    public CommandHandler(){
        
        createDefaultCommands();
        
    }
    
    
    /**
     * Adds a command to the handler
     * 
     * @param arg The short version of the command line argument (e.g: h).
     * @param longArg The long version of the command line argument (e.g: help).
     * @param desc A description of the command.
     * @param hasArgs Whether the command has arguments.
     * @param cmd The command object.
     */
    public void addCommand(String arg, String longArg, String desc, boolean hasArgs, Command cmd)
    {
        mCommands.put(arg, cmd);
        mOptions.addOption(arg, longArg, hasArgs, desc);
    }
    
    /**
     * Adds a command that has no arguments to the handler.
     * 
     * @param arg The short version of the command line argument (e.g: h).
     * @param longArg The long version of the command line argument (e.g: help).
     * @param desc A description of the command.
     * @param cmd The command object.
     */
    public void addCommand(String arg, String longArg, String desc, Command cmd)
    {
        addCommand(arg, longArg, desc, false, cmd);
    }
    
    /**
     * Parses the arguments and executes the commands that matches
     * the arguments.
     * 
     * @param args The arguments passed from the command line.
     */
    public void execute(String[] args)
    {
        CommandLine line = parseCommandLine(args);
        if (line == null)
            return;
     
        executeCommands(line);

    }
    
    
    private void executeCommands(CommandLine line)
    {
       for(String arg: mCommands.keySet()){
           
           if(line.hasOption(arg)){
               mCommands.get(arg).execute(line);
           }
       }

    }

    
    private CommandLine parseCommandLine(String[] args){
        
        CommandLine line = null;
        try{
            line = mParser.parse(mOptions, args);
        }
        catch(ParseException exp){
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage());
        }
        return line;
    }
    
    
    private void createDefaultCommands(){
        addCommand("h", "help", "Print help info", new HelpCommand());
    }
    
    
    
    /**
     * Command to print the help info.
     */
    private class HelpCommand extends Command{
    
        @Override
        public void execute(CommandLine line)
        {
                
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("CLIApplication [args]", mOptions);
            
        }
        
    }
    
}
