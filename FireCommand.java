
/**
 * Décrivez votre classe FireCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class FireCommand extends Command
{
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        String vBeamerName = super.getSecondWord();
         if (vBeamerName == null) pGameEngine.getGui().println("fire what ?");
        else if (pPlayer.getItem(pPlayer.getBeamer().getName()) == null) pGameEngine.getGui().println("You don't own the beamer");
        else if (pPlayer.getBeamerRoom() == null) pGameEngine.getGui().println("You forget to charge the beamer !");
        else if (!vBeamerName.equals(pPlayer.getBeamer().getName())) pGameEngine.getGui().println(vBeamerName + " is not the beamer");
        else {
            if (pPlayer.getCurrentRoom() == pPlayer.getBeamerRoom()) {
                pGameEngine.getGui().println("You can not fire at the same room you charged the beamer...");
                return;
            }
            pPlayer.setCurrentRoom(pPlayer.getBeamerRoom());
            pPlayer.addRoom(pPlayer.getCurrentRoom());
            pGameEngine.printLocationInfo();
            pPlayer.removeItem(vBeamerName);
        }
    }
}
