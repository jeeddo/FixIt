
/**
 * Décrivez votre classe ChargeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ChargeCommand extends Command
{
    
    
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine ) {
        String vBeamerName = super.getSecondWord();
        if (vBeamerName == null) pGameEngine.getGui().println("charge what ?");
        else if (pPlayer.getItem(pPlayer.getBeamer().getName()) == null) pGameEngine.getGui().println("You don't own the beamer");
        else if (!vBeamerName.equals(pPlayer.getBeamer().getName())) pGameEngine.getGui().println(vBeamerName + " is not the beamer");
        else {
            pPlayer.setBeamerRoom(pPlayer.getCurrentRoom());
            pGameEngine.getGui().println("You charged the beamer");
        }
        
    }
}
