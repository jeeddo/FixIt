package src.pkg_commands;
import src.pkg_models.Player;
import src.pkg_game.GameEngine;
import src.pkg_items.Item;

/**
 * Command that allows the player to pick up an item from the current room if they can carry it.
 * @author Pierre MATAR
 */
public class TakeCommand extends Command
{
   /**
     * Executes the command to allow the player to pick up an item if they are able to carry it.
     * Checks if the item exists in the room and if the player can carry it based on weight.
     * 
     * @param pPlayer The player attempting to take the item.
     * @param pGameEngine The game engine instance to manage output.
     */
    @Override
   public void execute(final Player pPlayer, final GameEngine pGameEngine) {
       String vItemName = super.getSecondWord();
       Item vRoomItem = pPlayer.getCurrentRoom().getItem(vItemName);
        if (!super.hasSecondWord()) {
            pGameEngine.getGui().println("Take what ?");
            return;
        }
        if (vRoomItem != null) {
            
            if (vRoomItem.getItemWeight() <= pPlayer.getPlayerWeight()) {
                 pPlayer.addItem(vRoomItem);
                pGameEngine.getGui().println("You took : " + vRoomItem.getItemString());
                pPlayer.setPlayerWeight(- vRoomItem.getItemWeight());
                pPlayer.getCurrentRoom().removeItem(vItemName);
                pGameEngine.getGui().println(pPlayer.getMyItemsList());  
            }
            else pGameEngine.getGui().println("You can't carry " + vItemName + " because you weigth available is :" + pPlayer.getPlayerWeight());
            
            
        }
           
        else 
            pGameEngine.getGui().println("this item does'nt exist in this room...");
    } 
}
