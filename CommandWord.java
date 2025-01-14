/**
 * Representations for all the valid command words for the game
 * along with a description string and corresponding commands.
 * 
 * @author Pierre MATAR
 */
public enum CommandWord
{
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
    ALEA("alea", new AleaCommand()),
    INTERACT("interact", new InteractCommand());
    
    
    // The command string.
    private String aCommandString;
    private Command aCommand;
    
    /**
     * Initialise with the corresponding command word and command.
     * @param commandWord The command string.
     * @param pCommand The command object.
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
    
    /**
     * @return The command instance.
    */
    public Command getCommand() {
        return this.aCommand;
    }
}