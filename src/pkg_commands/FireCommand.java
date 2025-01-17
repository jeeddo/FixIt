package src.pkg_commands;
import src.pkg_models.Player;
import src.pkg_game.GameEngine;


/**
 * FireCommand class is a command that allows the player to fire the beamer.
 * 
 * @author Pierre MATAR
 */
public class FireCommand extends Command
{
     /**
     * Executes the "fire" command for the player.
     * It checks whether the player owns the beamer, whether the beamer is charged,
     * and whether the player is in the correct room to fire the beamer.
     *
     * @param pPlayer the player who issued the command
     * @param pGameEngine the game engine that controls the game state
     */
    
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
         if (!super.hasSecondWord()) {
             pGameEngine.getGui().println("fire what ?");  
             return;
         }  
        
        String vBeamerName = super.getSecondWord();

        if (!vBeamerName.equals(pPlayer.getBeamer().getName())) pGameEngine.getGui().println(vBeamerName + " is not the beamer");
        else if (pPlayer.getItem(pPlayer.getBeamer().getName()) == null) pGameEngine.getGui().println("You don't own the beamer");
        else if (!pPlayer.getBeamer().isBeamerCharged()) pGameEngine.getGui().println("You forget to charge the beamer !");
        else {
            if (pPlayer.getCurrentRoom() == pPlayer.getBeamerRoom()) {
                pGameEngine.getGui().println("You can not fire at the same room you charged the beamer...");
                return;
            }
            pPlayer.setCurrentRoom(pPlayer.getBeamerRoom());
            pPlayer.addRoom(pPlayer.getCurrentRoom());
            pGameEngine.printLocationInfo();
            pPlayer.removeItem(vBeamerName);
        }
    }
}
