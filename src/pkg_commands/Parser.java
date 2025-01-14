package pkg_commands;

 

import java.util.StringTokenizer;

/**
 * This class parses user input, maps it to known commands, and returns the corresponding Command object.
 * It handles single and multi-word commands and special cases, like restarting the game.
 * 
 * @author Pierre MATAR
 */
public class Parser 
{  
    private CommandWords aValidCommands;  
    private GameEngine aGameEngine;
    private Player aPlayer;

       /**
     * Initializes the parser with valid commands and the game engine.
     * 
     * @param pGameEngine The game engine.
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
     * Parses user input and returns the corresponding Command object.
     * Handles special cases like "yes" for restarting the game.
     * 
     * @param pInputLine User input.
     * @return Corresponding Command object.
     */
 public Command getCommand( final String pInputLine) 
    {
        String vWord1;
        StringBuilder vWord2 = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer( pInputLine );

       
        vWord1 = tokenizer.nextToken();     
      
            if (vWord1 != null) {
            
          
              
        if (vWord1.equals(CommandWord.BACK.getDescription()) || vWord1.equals(CommandWord.LOOK.getDescription())) {
    
             while(tokenizer.hasMoreTokens()) {
            vWord2.append(tokenizer.nextToken()).append(" ");
        }
    }
         else {
            if ( tokenizer.hasMoreTokens() )
                vWord2.append(tokenizer.nextToken()); 
        }
        
       
            
        if (vWord1.toLowerCase().equals("yes") && this.aGameEngine.getRestartGame())
            vWord2.append(vWord1.toLowerCase());
       
        else if (vWord2.length() == 0)
            vWord2 = null;
            
        }
        

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
       
        
        Command vCommand = this.aValidCommands.getCommandWord(vWord1).getCommand();
        vCommand.setSecondWord(vWord2 != null ? vWord2.toString() : null);
        return vCommand;
      
    } // getCommand(.)
    
} // Parser
