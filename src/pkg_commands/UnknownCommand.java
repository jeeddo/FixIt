package src.pkg_commands;
import src.pkg_models.Player;
import src.pkg_game.GameEngine;


/**
 * Command that handles unrecognized player inputs.
 * Displays a message indicating an unknown command.
 * 
 * @author Pierre MATATR
 */
public class UnknownCommand extends Command
{
    /**
     * Executes the "Unknown" command behavior by notifying the player 
     * that the input is invalid.
     * 
     * @param pPlayer      the player executing the command.
     * @param pGameEngine  the game engine managing interactions.
     */
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        pGameEngine.getGui().println("Unknown command !");

    }
}
