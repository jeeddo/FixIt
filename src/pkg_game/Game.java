package pkg_game;


 
/**
 * Game class
 * 
 * @author Pierre MATAR
 */
public class Game
{
    
    private UserInterface aGui;
    private GameEngine aEngine;
    
    /**
     * Create the game and initialise its internal map. Create the inerface and link to it.
     */
    public Game() 
    {
        
        String vPlayerName = "";
        while(vPlayerName.length() == 0) {
            vPlayerName = javax.swing.JOptionPane.showInputDialog("Enter your name to start the game : ");
        }
        
        this.aEngine = new GameEngine(vPlayerName);
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI( this.aGui );
    }
} // Game
