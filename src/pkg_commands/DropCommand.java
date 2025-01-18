package src.pkg_commands;
import src.pkg_models.Player;
import src.pkg_game.GameEngine;
import src.pkg_items.Item;
import src.pkg_rooms.Room;
import src.pkg_models.Characterr;
/**
 * Command that allows the player to drop an item in the current room.
 * 
 * @author Pierre MATAR
 */
public class DropCommand extends Command
{
    /**
     * The "Drop" command, allowing the player to remove an item 
     * from their inventory and place it in the current room.
     *
     * @param pPlayer      the player executing the command.
     * @param pGameEngine  the game engine managing interactions.
     */
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        
        if (!super.hasSecondWord()) {
            pGameEngine.getGui().println("Drop what ?");
            return;
        }
        
        String vItemName = super.getSecondWord();
        Room vCurrentRoom = pPlayer.getCurrentRoom();
        Item vPlayerItem = pPlayer.getItem(vItemName); 

        if ( vPlayerItem == null) pGameEngine.getGui().println("You don't own " + vItemName);
        
        else if (vCurrentRoom.getItem(vItemName) != null) pGameEngine.getGui().println("You are not allowed to put the same item in the room");
        
        else {
            vCurrentRoom.addItem(vPlayerItem);
            pPlayer.setPlayerWeight(vPlayerItem.getItemWeight());
            pPlayer.removeItem(vItemName);
            pGameEngine.getGui().println("You droped " + vItemName);
            for (Characterr vCharacter : vCurrentRoom.getCharacters()) {
                if (vCharacter.hasItem() && vCharacter.getItem() == vCurrentRoom.getItem(vItemName)) {
                    pGameEngine.getGui().println(vCharacter.getName() + " : " + vCharacter.getResponseText());
                    vCurrentRoom.removeItem(vItemName);
                }
            }
        }
    }
}
