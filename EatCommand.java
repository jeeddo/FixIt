import java.util.Set;
/**
 * Décrivez votre classe EatCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EatCommand extends Command
{
    private ItemList aItems;
    
    public void setItems(final ItemList pItems) {
        this.aItems = pItems;
    }
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
