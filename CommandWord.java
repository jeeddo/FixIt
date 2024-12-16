/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author Pierre MATAR
 * @version 2006.03.30
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), EAT("eat"), BACK("back"), TEST("test"), TAKE("take"), DROP("drop"), ITEMS("items"), UNKNOWN("?"), FIX("fix");
    
    
    // The command string.
    private String aCommandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String pCommandString)
    {
        this.aCommandString = pCommandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String getDescription()
    {
        return this.aCommandString;
    }
}