
/**
 * Décrivez votre classe FixCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class FixCommand extends Command
{
      /**
     * Checks if the player has fixed a bug using a specific object.
     * @param pSecondWord The keyword needed to complete the game.
     */
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine ) {
        String vSecondWord = super.getSecondWord();
        if (pPlayer.getItem(pGameEngine.getThePC().getName()) == null) pGameEngine.getGui().println("You didn't find yourPC yet ...");
        else if (pPlayer.getItem(pGameEngine.getThePC().getName()) != null && (vSecondWord == null || !vSecondWord.equals("bug"))) pGameEngine.getGui().println("ahh you were close !");
        else {
            pGameEngine.getGui().println("------------ YOUUUUUPIII you have fix the bug, you won the Game BRAVO ! ------------");
            QuitCommand vQuitCommand = new QuitCommand();
            vQuitCommand.setState(true);
            vQuitCommand.execute(pPlayer, pGameEngine);
        }
        
        
        
    }
}
