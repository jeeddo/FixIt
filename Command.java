 
/**
 * Classe Command - une commande du jeu d'aventure Zuul.
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
    public void setSecondWord(final String pSecondWord) {
        this.aSecondWord = pSecondWord;
    }
    /**
 * Checks if the command has a second word.
 */

    
    public boolean hasSecondWord() {
        return this.aSecondWord != null; 
        
    }//hasSecondWord
    
    public abstract void execute(final Player pPlayer, final GameEngine pGameEngine);
} // Command
