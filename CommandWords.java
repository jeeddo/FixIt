import java.util.HashMap;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Pierre MATAR
 * @version
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private final HashMap<String, CommandWord> aValidCommands;
  
    /**
 * Constructor - initializes the list of valid command words.
 */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<>();
       for (CommandWord command : CommandWord.values() ) {
           System.out.println(command.getDescription());
           this.aValidCommands.put(command.getDescription(), command);
       }
    } // CommandWords()

    
    public CommandWord getCommandWord(final String pCommandString) {
    
        return this.aValidCommands.get(pCommandString) != null ? this.aValidCommands.get(pCommandString) : this.aValidCommands.get("?");
        
    }

   /**
 * Returns a list of all valid command words.
 * 
 * @return A string containing all valid commands separated by a space.
 */

    public String getCommandList() {
        StringBuilder vCommandList = new StringBuilder("");
        for (String command : this.aValidCommands.keySet())
            vCommandList.append(command).append(" ");
        return vCommandList.toString();
    } //getCommandList
} // CommandWords$
