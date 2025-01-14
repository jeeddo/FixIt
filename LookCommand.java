
/**
 * The LookCommand class is used to handle the "look" command in the game.
 * It allows the player to examine the current room or specific items within the room.
 * 
 * If no specific item is mentioned, the description of the current room is shown.
 * If one item or severals items are mentioned, the description of each item is displayed if they exist in the room.
 *
 * @author Pierre MATAR
 */
public class LookCommand extends Command
{
     /**
     * Executes the look command.
     * If no second word is provided, displays the information of the current room.
     * If second words are provided, looks at the specified items in the room.
     * 
     * @param pPlayer The player who executed the command.
     * @param pGameEngine The game engine handling the game logic and output.
     */
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
