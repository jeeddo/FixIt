import java.util.HashMap;
/**
 * The CommandWords class holds all the valid command words that the game recognizes.
 * It is used to validate and recognize commands as they are typed by the player.
 * 
 * @author Pierre MATAR
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private final HashMap<String, CommandWord> aValidCommands;
  
    /**
 * Constructor - initializes the list of valid command words thanks to an enumeration of commands.
 */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, CommandWord>();
       for (CommandWord command : CommandWord.values() ) {
           this.aValidCommands.put(command.getDescription(), command);
       }
    } // CommandWords()

    /**
     * Returns the CommandWord enum corresponding to the given command string.
     * If the string is not a valid command, it returns the "?" command word.
     * 
     * @param pCommandString The command string entered by the player.
     * @return The corresponding CommandWord, or the "?" command if the string is not valid.
     */
    public CommandWord getCommandWord(final String pCommandString) {
    
        return this.aValidCommands.get(pCommandString) != null ? this.aValidCommands.get(pCommandString) : this.aValidCommands.get("?");
        
    }

 /**
 * @return A string containing all valid commands separated by a space.
 */

    public String getCommandList() {
        StringBuilder vCommandList = new StringBuilder("");
        for (String command : this.aValidCommands.keySet())
            vCommandList.append(command).append(" ");
        return vCommandList.toString();
    } //getCommandList
} // CommandWords$
