
/**
 * Décrivez votre classe QuitCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class QuitCommand extends Command
{
    private boolean aState;
    
    public void setState(final boolean pState) {
        this.aState = pState;
    }
    
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine)
    {
        if (super.hasSecondWord()) {
            pGameEngine.getGui().println("Quit what ?");
            return;
        }
        if (this.aState) {
            pGameEngine.getGui().println("Do you want to play again ?");
            pGameEngine.setRestartGame(true);
        
        }
        else {
        
            pGameEngine.getGui().println( "Thank you for playing.  Good bye." ); 
            pGameEngine.getGui().enable( false );   
        }
    }
}
