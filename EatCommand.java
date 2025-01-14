import java.util.Set;
/**
 * Command allowing the player to consume a specific item, 
 * adjusting their weight depending on the item consumed.
 *
 * @author Pierre MATAR
 */
public class EatCommand extends Command
{
    private ItemList aItems;
    
     /**
     * Sets the available items for the command.
     *
     * @param pItems list of consumable items.
     */
    public void setItems(final ItemList pItems) {
        this.aItems = pItems;
    }
    
      /**
     * Executes the "Eat" command by consuming an item from the current room 
     * or player's inventory and adjusting weight accordingly.
     *
     * @param pPlayer      the player executing the command.
     * @param pGameEngine  the game engine managing interactions.
     */
    
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        String vItemName = super.getSecondWord();
        System.out.println(aItems.getItem(null));
        Room vCurrentRoom = pPlayer.getCurrentRoom();
        if (this.aItems.getItem(vItemName) != null) {
               if (vCurrentRoom.getItem(vItemName) != null ) {
            
                  if (vCurrentRoom.getItem(vItemName) == pGameEngine.getMagicCookie()) {
                    pPlayer.setPlayerWeight(pPlayer.getPlayerWeight());
                  }
                  else {
                      pPlayer.setPlayerWeight(vCurrentRoom.getItem(vItemName).getItemWeight());
                  }
                    vCurrentRoom.removeItem(vItemName);
                    pGameEngine.getGui().println("Miam miam miammmmm, here is your weigth now : " + pPlayer.getPlayerWeight());
                }
        else if (pPlayer.getItem(vItemName) != null) {
                  if (pPlayer.getItem(vItemName) == pGameEngine.getMagicCookie()) {
                    pPlayer.setPlayerWeight(pPlayer.getPlayerWeight());
                  }
                  else {
                      pPlayer.setPlayerWeight(pPlayer.getItem(vItemName).getItemWeight());
                  }
                    pPlayer.removeItem(vItemName);
                pGameEngine.getGui().println("Miam miam miammmmm, here is your weigth now : " + pPlayer.getPlayerWeight());
            }
        else pGameEngine.getGui().println(vItemName + " is not here and you don't own it...");
        }
        else pGameEngine.getGui().println(this.aItems.getAllItemString(this));
    
    }
}
