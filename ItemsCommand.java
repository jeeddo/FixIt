
/**
 * ItemsCommand a class that prints the player's items.
 *
 * @author Pierre MATAR
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
