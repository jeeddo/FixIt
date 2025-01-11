
/**
 * Décrivez votre classe DropCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DropCommand extends Command
{
      /**
     * Allows the player to drop an item in the current room.
     * @param pItemName The name of the item to drop.
     */
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        String vItemName = super.getSecondWord();
        Room vCurrentRoom = pPlayer.getCurrentRoom();
        Item vPlayerItem = pPlayer.getItem(vItemName); 

        if (!super.hasSecondWord()) {
            pGameEngine.getGui().println("Drop what ?");
            return;
        }
        if ( vPlayerItem == null) pGameEngine.getGui().println("You don't own " + vItemName);
        
        else if (vCurrentRoom.getItem(vItemName) != null) pGameEngine.getGui().println("You are not allowed to put the same item in the room");
        
        else {
            vCurrentRoom.addItem(vPlayerItem);
            pPlayer.setPlayerWeight(vPlayerItem.getItemWeight());
            pPlayer.removeItem(vItemName);
            pGameEngine.getGui().println("You droped " + vItemName);
            for (Character vCharacter : vCurrentRoom.getCharacters()) {
                if (vCharacter.getItem() == vCurrentRoom.getItem(vItemName)) {
                    pGameEngine.getGui().println(vCharacter.getResponseText());
                    vCurrentRoom.removeItem(vItemName);
                }
            }
        }
    }
}
