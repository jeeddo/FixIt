 

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private final String[] aValidCommands;
  
    /**
 * Constructor - initializes the list of valid command words.
 */
    public CommandWords()
    {
       this.aValidCommands = new String[]{"go", "help", "quit", "look", "eat", "back"};
    } // CommandWords()

    /**
 * Check whether a given string is a valid command.
 * 
 * @param pString The command string to check.
 * @return true if the given string is a valid command, false otherwise.
 */
    public boolean isCommand( final String pString )
    {
        for ( int vI=0; vI<this.aValidCommands.length; vI++ ) {
            if ( this.aValidCommands[vI].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands :
        return false;
    } // isCommand()
    
    /**
 * Returns a list of all valid command words.
 * 
 * @return A string containing all valid commands separated by a space.
 */

    public String getCommandList() {
        StringBuilder vCommandList = new StringBuilder("");
        for (String command : this.aValidCommands)
            vCommandList.append(command + " ");
        return vCommandList.toString();
    } //getCommandList
} // CommandWords
