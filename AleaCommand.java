
/**
 * Décrivez votre classe AleaCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AleaCommand extends Command
{
    @Override
   public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        String vSecondCommandWord = super.getSecondWord();
        if (!pGameEngine.isTestMode()) pGameEngine.getGui().println("You're not in test mode");
        else if (vSecondCommandWord != null && pGameEngine.isTestMode()) {
               for (Room room : pGameEngine.getRooms()) {
                       if (room.getName().equals(vSecondCommandWord)) {
                        pGameEngine.setAleaRoom(room);
                        pGameEngine.getGui().println("The alea room is on -> " + room.getName());
                        return;
                    }
        
               }
               pGameEngine.getGui().println("We don't provide this room : " + vSecondCommandWord);
        }
     
 
    }
}
