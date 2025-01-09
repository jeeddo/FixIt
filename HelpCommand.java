
/**
 * Décrivez votre classe HelpCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class HelpCommand extends Command
{
    @Override
    public void  execute(final Player pPlayer, final GameEngine pGameEngine) {
        pGameEngine.getGui().println("You are lost. You are alone.");
        pGameEngine.getGui().println("You wander around at the university.\n");
        pGameEngine.getGui().println("Your command words are:");
        pGameEngine.getGui().println(pGameEngine.getParser().getCommands());
    }
}