
/**
 * Décrivez votre classe TakeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TakeCommand extends Command
{
          /**
     * Allows the player to pick up an item in the current room if they can carry it.
     * @param pItemName The name of the item to pick up.
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
            else pGameEngine.getGui().println("You can carry " + vItemName + " because you weigth available is :" + pPlayer.getPlayerWeight());
            
            
        }
           
        else 
            pGameEngine.getGui().println("this item does'nt exist in this room...");
    } 
}
