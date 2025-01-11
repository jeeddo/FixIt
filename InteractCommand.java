
/**
 * Décrivez votre classe InteractCommand ici.
 *
 * @author Pierre MATAR
 * @version (un numéro de version ou une date)
 */
public class InteractCommand extends Command
{
     @Override
     public void execute(final Player pPlayer, final GameEngine pGameEngine) {
         String vCharacterName = super.getSecondWord();
        Character vCharacter = pPlayer.getCurrentRoom().getCharacter(vCharacterName);
         if (vCharacterName == null) pGameEngine.getGui().println("With which character do you want to talk ?");
         else if (vCharacter != null) {
             pGameEngine.getGui().println(vCharacter.getTextToSay());
             if (vCharacter.getItem() != null) pGameEngine.getGui().println("Give " + vCharacter.getItem().getName() + " and maybe he can help you to found your PC.");
         }
         
         else pGameEngine.getGui().println(vCharacterName + " does not exist in " + pPlayer.getCurrentRoom().getName());
     }
}
