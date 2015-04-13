/*
 * Command line user interface
 */
package cli;

import org.apache.commons.cli.CommandLine;


/**
 * The main application for the text based user interface
 * 
 * @author Per Myren
 */
public class CLIApplication {
    
    CommandHandler mCommands = new CommandHandler();

    /**
     * Run the application
     * 
     * @param args Command line arguments.
     */
    public void run(String[] args){
        
        createCommands();
        
        if(args.length == 0)
            mCommands.execute(new String[]{"-help"});
        else
            mCommands.execute(args);

    }
    
    /**
     * Main entry point for the application
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        
        CLIApplication app = new CLIApplication();
        
        app.run(args);

    }
    
    
    
    private void createCommands(){
        
        mCommands.addCommand("t", "test", "Testing", true, new TestCommand());
     
    }


    private class TestCommand extends Command{
    
        @Override
        public void execute(CommandLine line)
        {
                
            System.out.println("Test: " + line.getOptionValue("test", "default"));
            
        }
        
    }
}
