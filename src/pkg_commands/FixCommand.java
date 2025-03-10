package src.pkg_commands;
import src.pkg_models.Player;
import src.pkg_game.GameEngine;


/**
 * FixCommand class is a command that allows the player to fix a bug if he finds his PC.
 * This class allows the player to win the game.
 * 
 * @author Pierre MATAR
 */
public class FixCommand extends Command
{
     /**
     * Executes the "fix" command for the player.
     * It checks if the player has the correct item (the PC) and if the second word
     * of the command is "bug". If the conditions are met, the player wins the game.
     *
     * @param pPlayer the player who issued the command
     * @param pGameEngine the game engine that controls the game state
     */
    
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine ) {
        if (pPlayer.getItem(pGameEngine.getThePC().getName()) == null) pGameEngine.getGui().println("You didn't find yourPC yet ...");
        else if (pPlayer.getItem(pGameEngine.getThePC().getName()) != null && (!super.hasSecondWord() || !super.getSecondWord().equals("bug"))) pGameEngine.getGui().println("ahh you were close !");
        else {
            pGameEngine.getGui().println("------------ YOUUUUUPIII you have fixed the bug, you won the Game BRAVO ! ------------");
            QuitCommand vQuitCommand = new QuitCommand();
            vQuitCommand.setState(true);
            vQuitCommand.execute(pPlayer, pGameEngine);
        }
        
        
        
    }
}
