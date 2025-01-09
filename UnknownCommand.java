
/**
 * Décrivez votre classe UnknownCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UnknownCommand extends Command
{
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        pGameEngine.getGui().println("Unknown command !");

    }
}
