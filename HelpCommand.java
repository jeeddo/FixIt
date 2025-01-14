
/**
 * The HelpCommand class represents the command that the player can issue to get help or guidance.
 * 
 * @author Pierre MATAR
 */
public class HelpCommand extends Command
{
    /**
     * Executes the "help" command. This method prints a brief description of the game
     * and lists all the valid commands that the player can use.
     *
     * @param pPlayer The player object, representing the current player in the game.
     * @param pGameEngine The game engine, which controls the game's state and logic.
     */
    @Override
    public void  execute(final Player pPlayer, final GameEngine pGameEngine) {
        pGameEngine.getGui().println("You are lost. You are alone.");
        pGameEngine.getGui().println("You wander around at the university.\n");
        pGameEngine.getGui().println("Your command words are:");
        pGameEngine.getGui().println(pGameEngine.getParser().getCommands());
    }
}