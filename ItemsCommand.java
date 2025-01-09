
/**
 * Décrivez votre classe ItemsCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ItemsCommand extends Command
{
    /**
* Displays the list of items currently in the player's inventory.
*/
@Override
public void execute(final Player pPlayer, final GameEngine pGameEngine) {
    pGameEngine.getGui().println(pPlayer.getMyItemsList());
}
}
