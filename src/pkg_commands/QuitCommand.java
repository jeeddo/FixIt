package src.pkg_commands;

import src.pkg_models.Player;
import src.pkg_game.GameEngine;

/**
 * Command that handles quitting the game. 
 * It can also prompt the player to restart if the game state allows.
 *
 * @author Pierre MATAR
 */
public class QuitCommand extends Command
{
    private boolean aState;
    
    /**
     * Constructor of QuitCommand that put false by default to his aState attribute.
     */
    public QuitCommand() {
        this.aState = false;
    }
    
     /**
     * Sets the state indicating whether the game can be restarted.
     * 
     * @param pState true if restart is allowed, false otherwise.
     */
    public void setState(final boolean pState) {
        this.aState = pState;
    }
     /**
     * Depending on the state, the game either 
     * ends or asks the player if they want to restart.
     * 
     * @param pPlayer      the player executing the command.
     * @param pGameEngine  the game engine managing interactions.
     */
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
