package src.pkg_commands;
import src.pkg_models.*;
import src.pkg_game.GameEngine;

/**
 * Represents the command to interact with a character in the game.
 * The player can attempt to talk to or move a character in the current room.
 * The command checks if the character exists, whether he can be interacted with, and if he can move.
 *
 * @author Pierre MATAR
*/
public class InteractCommand extends Command
{
    /**
     * Executes the interaction command, allowing the player to interact with a character in the room.
     * The player can either talk to the character or move the character if applicable.
     * If the character cannot be found or interacted with, appropriate messages are displayed.
     *
     * @param pPlayer The player who is executing the command.
     * @param pGameEngine The game engine.
     */
     @Override
     public void execute(final Player pPlayer, final GameEngine pGameEngine) {
         String vCharacterName = super.getSecondWord();
         for (Characterr vCharacter : pGameEngine.getCharacters()) {
             
             if (vCharacter.getName().equals(vCharacterName) && vCharacter instanceof MovingCharacter) {
                 ((MovingCharacter) vCharacter).move(pPlayer.getCurrentRoom());
                 break;
             }
             else if (vCharacter.getName().equals(vCharacterName) && pPlayer.getCurrentRoom().getCharacter(vCharacterName) == null) {
                
                pGameEngine.getGui().println(vCharacterName + " can't move in " + pPlayer.getCurrentRoom().getName());
                return;
             }
         }
        Characterr vCharacter = pPlayer.getCurrentRoom().getCharacter(vCharacterName);
         if (vCharacterName == null) pGameEngine.getGui().println("With which character do you want to talk ?");
         else if (vCharacter != null) {
             pGameEngine.getGui().println(vCharacter.getTextToSay());
             if (vCharacter.getItem() != null) pGameEngine.getGui().println("Give " + vCharacter.getItem().getName() + " and maybe "+ vCharacter.getName() +  " can help you to found your PC.");
         }
         else pGameEngine.getGui().println(vCharacterName + " doesn't exist in " + pPlayer.getCurrentRoom().getName());
         
     }
}
