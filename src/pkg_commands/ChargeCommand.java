package src.pkg_commands;
import src.pkg_models.Player;
import src.pkg_game.GameEngine;


/**
 * ChargeCommand class represents a command that allows the player to charge their beamer.
 * The player can charge the beamer by specifying its name.
 * 
 * @author Pierre MATAR
 */
public class ChargeCommand extends Command
{
     /**
     * Executes the ChargeCommand, allowing the player to charge the beamer in their current room.
     * 
     * @param pPlayer The player who issued the command.
     * @param pGameEngine The game engine which contains the state of the game.
     */
    
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine ) {
        String vBeamerName = super.getSecondWord();
        if (vBeamerName == null) pGameEngine.getGui().println("charge what ?");
        else if (!vBeamerName.equals(pPlayer.getBeamer().getName())) pGameEngine.getGui().println(vBeamerName + " is not the beamer");
        else if (pPlayer.getItem(pPlayer.getBeamer().getName()) == null) pGameEngine.getGui().println("You don't own the beamer");
        else {
            pPlayer.setBeamerRoom(pPlayer.getCurrentRoom());
            pGameEngine.getGui().println("You charged the beamer");
        }
        
    }
}
