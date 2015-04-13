
package cli;

import org.apache.commons.cli.CommandLine;


/**
 * Super class for commands that is executed by the command handler.
 * 
 * @author per Myren
 */
public abstract class Command
{
    
    /**
     * Execute the command
     * @param line The parsed arguments from the command line.
     */
    public abstract void execute(CommandLine line);
    
}
