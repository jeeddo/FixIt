/**
 * Representations for all the valid command words for the game
 * along with a description string.
 * 
 * @author Pierre MATAR
 * @version 2006.03.30
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go", new GoCommand()), 
    QUIT("quit", new QuitCommand()), 
    HELP("help", new HelpCommand()), 
    LOOK("look", new LookCommand()), 
    EAT("eat", new EatCommand()),
    BACK("back", new BackCommand()), 
    TEST("test", new TestCommand()), 
    TAKE("take", new TakeCommand()), 
    DROP("drop", new DropCommand()), 
    ITEMS("items", new ItemsCommand()), 
    UNKNOWN("?", new UnknownCommand()), 
    FIX("fix", new FixCommand()), 
    CHARGE("charge", new ChargeCommand()), 
    FIRE("fire", new FireCommand()), 
    ALEA("alea", new AleaCommand());
    
    
    // The command string.
    private String aCommandString;
    private Command aCommand;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(final String pCommandString, final Command pCommand)
    {
        this.aCommandString = pCommandString;
        this.aCommand = pCommand;
    }
    
    /**
     * @return The command word as a string.
     */
    public String getDescription()
    {
        return this.aCommandString;
    }
    public Command getCommand() {
        return this.aCommand;
    }
}