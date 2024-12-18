 

import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class Parser 
{  
    private CommandWords aValidCommands;  // (voir la classe CommandWords)
    private GameEngine aGameEngine;
    private Player aPlayer;

    /**
 * Default constructor that initializes the valid commands and input reader.
 */
    public Parser(final GameEngine pGameEngine) 
    {
        this.aValidCommands = new CommandWords();
        this.aGameEngine = pGameEngine;
    } // Parser()
    /**
 * Returns a list of valid command words.
 */
    
    public String getCommands() {
        return this.aValidCommands.getCommandList();
    }

   /**
 * Reads user input and returns the next command.
 */
 public Command getCommand( final String pInputLine) 
    {
        String vWord1;
        StringBuilder vWord2 = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer( pInputLine );

        if ( tokenizer.hasMoreTokens() )
            vWord1 = tokenizer.nextToken();      // get first word
        else
            vWord1 = null;
        
            if (vWord1 != null) {
            
          
              
        if (vWord1.equals("back") || vWord1.equals("look")) {
    
             while(tokenizer.hasMoreTokens()) {
            vWord2.append(tokenizer.nextToken()).append(" ");
        }
    }
         else {
            if ( tokenizer.hasMoreTokens() )
                vWord2.append(tokenizer.nextToken()); 
        }
        }
       
            
        if (vWord1.toLowerCase().equals("yes") && this.aGameEngine.getRestartGame())
            vWord2.append(vWord1.toLowerCase());
       
        else if (vWord2.length() == 0)
            vWord2 = null;
        

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        return new Command( this.aValidCommands.getCommandWord(vWord1) == null ? CommandWord.UNKNOWN : this.aValidCommands.getCommandWord(vWord1), vWord2 != null ? vWord2.toString() : null);
      
    } // getCommand(.)
    
} // Parser
