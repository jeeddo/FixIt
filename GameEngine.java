import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the core engine of the game, responsible for managing game elements such as rooms, items, and characters.
 * It processes player commands and controls the flow of the game.
 * 
 * @author Pierre MATAR
 */

public class GameEngine
{
    private Parser aParser;
    private UserInterface aGui;
    private Player aPlayer;
    private boolean aRestartGame;
    private List<Room> aRooms;
    private Room aAleaRoom;
    private boolean aIsTestMode;
    private ItemList aItemsToEat;
    private Item aMagicCookie, aThePC;
    private List<Character> aCharacters;
    

/**
     * Constructor for objects of class GameEngine
     */
  public GameEngine(final String pPlayerName)
    {
        this.aParser = new Parser(this);
        this.aPlayer = new Player(pPlayerName);
        this.aRooms = new ArrayList<Room>();
        this.aItemsToEat = new ItemList();
        this.aCharacters = new ArrayList<Character>();
        this.createRoomsAndItemsAndCharacters();
  
    }
     /**
     * Initializes the user interface and displays the welcome message.
     * @param pUserInterface The user interface for the game.
     */
    
       public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
       
    }
    
     /**
     * @return The UserInterface object.
     */
    
    public UserInterface getGui() {
        return this.aGui;
    }
    
    /**
     * @return The Parser object.
     */
    
    public Parser getParser() {
        return this.aParser;
    }
        /**
 * Creates the different rooms / items / characters in the game.
 */

    private void createRoomsAndItemsAndCharacters() 
    {
    Room hall, developerRoom, serverRoom, meetingRoom, cafeteria, projectManagerOffice, openSpace, presentationRoom, Wc, maintenanceRoom;
    
    hall = new TransporterRoom("hall", "in The entry hall.", "images/hall.png");
    developerRoom = new TransporterRoom("developerRoom","inside the developer room.", "images/developerRoom.png");
    serverRoom = new TransporterRoom("serverRoom","inside the server room.", "images/serverRoom.png");
    meetingRoom = new TransporterRoom("meetingRoom","inside the meeting room.", "images/meetingRoom.png");
    cafeteria = new TransporterRoom("cafeteria","inside the cafétéria,", "images/cafeteria.png");
    projectManagerOffice = new TransporterRoom("projectManagerOffice", "inside the project manager office.", "images/projectManagerOffice.png", true, this);
    openSpace = new TransporterRoom("openSpace","inside the open-space", "images/openSpace.png");
    presentationRoom = new TransporterRoom("presentationRoom","inside the presenting room", "images/presentationRoom.png");
    Wc = new TransporterRoom("Wc","In the toilet...", "images/Wc.png");
    maintenanceRoom = new TransporterRoom("maintenanceRoom","inside the maintenance room.", "images/maintenanceRoom.png");
    
    Item one = new Item("Item", "Item 1 ", 300);
    Item two = new Item("Item4", "Item 2 ", 200);
    
    Item three = new Item("Item3", "Item 3 ", 500);
    Item zero = new Item("Item0", "0", 100);
    Item magicCookie = new Item("magicCookie", "THE magic cookie !", 0);
    Item thePC = new Item("thePC", "the holy grail", 300);
    Beamer beamer = new Beamer("beamer", "the transporter room ! ", 200);
    Item key = new Item("key", "the key", 100);
    
    
    
    hall.setExit("North", null);
    hall.setExit("South", null);
    hall.setExit("East", null);
    hall.setExit("West", null);
    hall.setExit("Up", openSpace);
    hall.setExit("Down", null);
    hall.addItem(one);
    hall.addItem(zero);
    hall.addItem(key);
    Character vRim = new Character("Rim", "hi de malda", "thanks", key);
    hall.addCharacter(vRim);

    developerRoom.setExit("North", projectManagerOffice);
    developerRoom.setExit("South", null);
    developerRoom.setExit("East", null);
    developerRoom.setExit("West", serverRoom);
    developerRoom.setExit("Up", null);
    developerRoom.setExit("Down", meetingRoom);
    developerRoom.addItem(thePC);

 
    serverRoom.setExit("North", null);
    serverRoom.setExit("South", maintenanceRoom);
    serverRoom.setExit("East", developerRoom, true, key, true);
    serverRoom.setExit("West", null);
    serverRoom.setExit("Up", null);
    serverRoom.setExit("Down", null);

    
    meetingRoom.setExit("North", null);
    meetingRoom.setExit("South", null);
    meetingRoom.setExit("East", openSpace);
    meetingRoom.setExit("West", null);
    meetingRoom.setExit("Up", developerRoom);
    meetingRoom.setExit("Down", null);
    MovingCharacter vPierre = new MovingCharacter("Pierre", "Salut, je m'appelle Pierre et toi ?", "Merci", zero, meetingRoom);
    meetingRoom.addCharacter(vPierre);
    meetingRoom.addItem(two);

    
    cafeteria.setExit("North", presentationRoom);
    cafeteria.setExit("South", Wc);
    cafeteria.setExit("East", null);
    cafeteria.setExit("West", openSpace);
    cafeteria.setExit("Up", null);
    cafeteria.setExit("Down", null);
    cafeteria.addItem(beamer);
    

   
    projectManagerOffice.setExit("North", null);
    projectManagerOffice.setExit("South", developerRoom);
    projectManagerOffice.setExit("East", null);
    projectManagerOffice.setExit("West", null);
    projectManagerOffice.setExit("Up", null);
    projectManagerOffice.setExit("Down", null);
    projectManagerOffice.addItem(three);
    
    openSpace.setExit("North", null);
    openSpace.setExit("South", null);
    openSpace.setExit("East", cafeteria);
    openSpace.setExit("West", meetingRoom);
    openSpace.setExit("Up", null);
    openSpace.setExit("Down", hall);
    openSpace.addItem(three);
    

    
    presentationRoom.setExit("North", null);
    presentationRoom.setExit("South", cafeteria);
    presentationRoom.setExit("East", null);
    presentationRoom.setExit("West", null);
    presentationRoom.setExit("Up", null);
    presentationRoom.setExit("Down", null);

   
    Wc.setExit("North", cafeteria);
    Wc.setExit("South", null);
    Wc.setExit("East", null);
    Wc.setExit("West", null);
    Wc.setExit("Up", null);
    Wc.setExit("Down", null);
    
    maintenanceRoom.setExit("North", serverRoom);
    maintenanceRoom.setExit("South", null);
    maintenanceRoom.setExit("East", null);
    maintenanceRoom.setExit("West", null);
    maintenanceRoom.setExit("Up", null);
    maintenanceRoom.setExit("Down", null);
    maintenanceRoom.addItem(magicCookie);
    

    
    this.aPlayer.setCurrentRoom( hall);
    this.aPlayer.addRoom(this.aPlayer.getCurrentRoom());
    
     this.aRooms.addAll(Arrays.asList(
            hall,
            presentationRoom,
            Wc,
            maintenanceRoom,
            openSpace,
            projectManagerOffice,
            cafeteria,
            meetingRoom,
            serverRoom,
            developerRoom
        ));
        
    this.aItemsToEat.addItem(magicCookie);
    this.aItemsToEat.addItem(zero);
    this.aPlayer.setBeamer(beamer);
    this.aMagicCookie = magicCookie;
    this.aThePC = thePC;
    this.aCharacters.add(vPierre);
    this.aCharacters.add(vRim);
} // createRooms

 /**
* @return List of rooms.
*/

public List<Room> getRooms() {
    return this.aRooms;
}

    /**
     * @return List of characters.
     */
    
public List<Character> getCharacters() {
    return this.aCharacters;
}

    /**
     * @return The PC item.
     */
    
public Item getThePC() {
    return this.aThePC;
}

/**  
* @return The magic cookie item.
*/

public Item getMagicCookie() {
    return this.aMagicCookie;
}
    
    /**
 * Displays the welcome message to the player.
 */
    private void printWelcome() {
        this.aGui.println("Welcome " + this.aPlayer.getName().toUpperCase() + " to FixIt");
        this.aGui.println("World of Zuul is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help. \n");
        this.printLocationInfo();
    } //printWelcome

    /**
 * Displays the current room's description and its image.
 */

    
    public void printLocationInfo() {
        Room vRoom = this.aPlayer.getCurrentRoom();
        this.aGui.println(vRoom.getLongDescription());
        if ( vRoom.getImageName() != null )
            this.aGui.showImage( vRoom.getImageName() );
        
        
    } //printLocationInfo
    
   /**
     * @return The alea room.
     */
    public Room getAleaRoom() {
        return this.aAleaRoom;
    }
    
   
 
 /**
 * Sets the test mode flag for the game.
 * 
 * @param pBool True if the game is in test mode, false otherwise.
 */

public void setTestMode(final boolean pBool) {
    this.aIsTestMode = pBool;
}

 /**
 * Checks if the game is in test mode.
 * 
 * @return True if the game is in test mode, false otherwise.
 */
    

public boolean isTestMode() {
    return this.aIsTestMode;
}

 /**
 * Sets the alea room used in the game.
 * 
 * @param pRoom The alea room.
 */

public void setAleaRoom(final Room pRoom) {
    this.aAleaRoom = pRoom;
}

 /**
 * Interprets and executes a given command line string.
 * If the command ends the game, the game terminates.
 * 
 * @param pCommandLine The command line string entered by the player.
 */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );

        Command vCommand = this.aParser.getCommand( pCommandLine);
        
   
        if ( vCommand instanceof UnknownCommand ) {
    
            if (this.aRestartGame) {
                String vSecondWord = vCommand.getSecondWord();
                vCommand = CommandWord.QUIT.getCommand();
                if (vSecondWord == null || !vSecondWord.equals("yes")) {
                    ((QuitCommand)vCommand).setState(false);
                    vCommand.execute(this.aPlayer, this);
                }
                else {
                    this.aGui.closeWindow();
                    new Game();
                    
                }
            }
            else {
                this.aGui.println( "I don't know what you mean..." );
                
            }
            return;
        }
        else if (vCommand instanceof EatCommand) {
            ((EatCommand)vCommand).setItems(this.aItemsToEat);
        }
        
        if (this.aPlayer.getNbMoves() == this.aPlayer.getMaxMoves()) {
            this.aGui.println("you've reached the maximum number of attempts ( " + this.aPlayer.getMaxMoves() + " )... ");
            
            vCommand = CommandWord.QUIT.getCommand();
            ((QuitCommand)vCommand).setState(true);
            vCommand.execute(this.aPlayer, this);
            return;
            
        }
        

        
        vCommand.execute(this.aPlayer, this);
        this.aPlayer.addOneMove();
}
        
    
      /**
     * @return True if the game is ready to restart, false otherwise.
     */
    
    public boolean getRestartGame() {
        return this.aRestartGame;
    }
    
      /**
     * Sets the restart game flag.
     * 
     * @param pBool True if the game should restart, false otherwise.
     */
    
    public void setRestartGame(final boolean pBool) {
        this.aRestartGame = pBool;
    }
    

}