
/**
 * Décrivez votre classe LookCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LookCommand extends Command
{
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine){
        Room vCurrentRoom = pPlayer.getCurrentRoom();
        String vSecondWord = super.getSecondWord();
        if (vSecondWord == null)
            pGameEngine.printLocationInfo();
        else {
            String[] vItemsToLook = vSecondWord.split(" ");
            
            for (String pItemName : vItemsToLook) {
                if (vCurrentRoom.getItem(pItemName) == null) {
                    pGameEngine.getGui().println( pItemName + " does'nt exist in this room...");
                    return;

                }
            }
            for (String pItemName : vItemsToLook) {
                pGameEngine.getGui().println(vCurrentRoom.getItem(pItemName).getItemString());
            }
            
        }
        
        
            
    }
}
