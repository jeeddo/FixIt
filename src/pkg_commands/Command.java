package src.pkg_commands;
import src.pkg_models.Player;
import src.pkg_game.GameEngine;

 
/**
 * Command class is an abstract class that serves as a base for specific game commands.
 * 
 * @author Pierre MATAR
 */
public abstract class Command
{
    private String aSecondWord;
    

    /**
 * Returns the second word of the command.
 */
    
    public String getSecondWord(){
        return this.aSecondWord;
    }//getSecondWord
    
    /**
     * Sets the second word of the command.
     * This is used to provide additional information to the command.
     * 
     * @param pSecondWord The second word to be set for the command.
     */
    public void setSecondWord(final String pSecondWord) {
        this.aSecondWord = pSecondWord;
    }
    
   /**
     * Checks if the command has a second word.
     * 
     * @return True if the command has a second word, false otherwise.
     */
    public boolean hasSecondWord() {
        return this.aSecondWord != null; 
        
    }//hasSecondWord
    
    /**
     * Executes the command. This method must be implemented by subclasses to define
     * the specific behavior of each command in the game.
     * 
     * @param pPlayer The player who is executing the command.
     * @param pGameEngine The game engine that manages the state of the game.
     */
    
    public abstract void execute(final Player pPlayer, final GameEngine pGameEngine);
} // Command
