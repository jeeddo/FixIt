 
/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author Pierre MATAR
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
 * Constructor for the command, initializes the command word and second word.
 */

       
    public Command(final String pCommandWord, final String pSecondWord) {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    } //Command
    /**
 * Returns the main command word.
 */
    
    public String getCommandWord(){
        return this.aCommandWord;
    }//getCommandWord
    /**
 * Returns the second word of the command.
 */
    
    public String getSecondWord(){
        return this.aSecondWord;
    }//getSecondWord
    /**
 * Checks if the command has a second word.
 */

    
    public boolean hasSecondWord() {
        return this.aSecondWord != null; 
        
    }//hasSecondWord
    
    /**
 * Checks if the command is unknown (null).
 */

    
    public boolean isUnknown() {
        return this.aCommandWord == null;
    }//isUnknown
} // Command
