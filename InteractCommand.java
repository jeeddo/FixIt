
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
         for (Character vCharacter : pGameEngine.getCharacters()) {
             
             if (vCharacter.getName().equals(vCharacterName) && vCharacter instanceof MovingCharacter) {
                 ((MovingCharacter) vCharacter).move(pPlayer.getCurrentRoom());
                 break;
             }
             else if (vCharacter.getName().equals(vCharacterName) && pPlayer.getCurrentRoom().getCharacter(vCharacterName) == null) {
                
                pGameEngine.getGui().println(vCharacterName + " can't move in " + pPlayer.getCurrentRoom().getName());
                return;
             }
         }
        Character vCharacter = pPlayer.getCurrentRoom().getCharacter(vCharacterName);
         if (vCharacterName == null) pGameEngine.getGui().println("With which character do you want to talk ?");
         else if (vCharacter != null) {
             pGameEngine.getGui().println(vCharacter.getTextToSay());
             if (vCharacter.getItem() != null) pGameEngine.getGui().println("Give " + vCharacter.getItem().getName() + " and maybe "+ vCharacter.getName() +  " can help you to found your PC.");
         }
         else pGameEngine.getGui().println(vCharacterName + " doesn't exist in " + pPlayer.getCurrentRoom().getName());
         
     }
}
