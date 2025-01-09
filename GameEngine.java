import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author Pierre MATAR
 * @version 2
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
    

/**
     * Constructor for objects of class GameEngine
     */
  public GameEngine(final String pPlayerName)
    {
        this.aParser = new Parser(this);
        this.aPlayer = new Player(pPlayerName);
        this.aRooms = new ArrayList<Room>();
        this.aItemsToEat = new ItemList();
        this.createRoomsAndItems();
  
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
    
    public UserInterface getGui() {
        return this.aGui;
    }
    
    public Parser getParser() {
        return this.aParser;
    }
        /**
 * Creates the different rooms in the game, along with their exits and items.
 */

    private void createRoomsAndItems() 
    {
    Room hall, developerRoom, serverRoom, meetingRoom, cafeteria, projectManagerOffice, openSpace, presentationRoom, Wc, maintenanceRoom;
    
    hall = new TransporterRoom("hall", "in The entry hall.", "Images/hall.png");
    developerRoom = new TransporterRoom("developerRoom","inside the developer room.", "Images/developerRoom.png");
    serverRoom = new TransporterRoom("serverRoom","inside the server room.", "Images/serverRoom.png");
    meetingRoom = new TransporterRoom("meetingRoom","inside the meeting room.", "Images/meetingRoom.png");
    cafeteria = new TransporterRoom("cafeteria","inside the cafétéria,", "Images/cafeteria.png");
    projectManagerOffice = new TransporterRoom("projectManagerOffice", "inside the project manager office.", "Images/projectManagerOffice.png", true, this);
    openSpace = new TransporterRoom("openSpace","inside the open-space", "Images/openSpace.png");
    presentationRoom = new TransporterRoom("presentationRoom","inside the presenting room", "Images/presentationRoom.png");
    Wc = new TransporterRoom("Wc","In the toilet...", "Images/Wc.png");
    maintenanceRoom = new TransporterRoom("maintenanceRoom","inside the maintenance room.", "Images/maintenanceRoom.png");
    
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
} // createRooms

public List<Room> getRooms() {
    return this.aRooms;
}

public Item getThePC() {
    return this.aThePC;
}

public Item getMagicCookie() {
    return this.aMagicCookie;
}
    
    /**
 * Displays the welcome message to the player.
 */
    private void printWelcome() {
        this.aGui.println("Welcome " + this.aPlayer.getName().toUpperCase() + " to 404 : Pc not found !");
        this.aGui.println("World of Zuul is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help. \n");
        this.printLocationInfo();
    } //printWelcome
  
    
    /**
 * Displays help with the list of available commands.
 */
 

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
 * Displays the detailed description of the current room or examines one or more objects in the current room.
 * @param pSecondWord The name of the object or list of objects separated by spaces.
 */

   
    
    /**
 * Displays a message indicating the player has eaten or allows to eat the magicCookie.
 * @param pItemName The name of the item to eat.
 */
 
    
     /**
     * Checks if the player has fixed a bug using a specific object.
     * @param pSecondWord The keyword needed to complete the game.
     */
    
 
    
   
      /** 
     * Allows the player to pick up an item in the current room if they can carry it.
     * @param pItemName The name of the item to pick up.
     */
 
    
     /**
     * Allows the player to drop an item in the current room.
     * @param pItemName The name of the item to drop.
     */
  
       /**
     * Moves the player back to the previous room(s), depending on the command.
     * If a specific number of "back" commands is provided, it goes back that many times.
     * @param pXTime The number of times "back" is specified, or null for a single back.
     */
    

    
 
    
    
   
    public Room getAleaRoom() {
        return this.aAleaRoom;
    }
    
    /**
     * Executes a series of commands from a test file located in the "./tests" directory.
     * @param pUneCommande The command specifying the test file to execute.
     */
 

/**
* Displays the list of items currently in the player's inventory.
*/


public void setTestMode(final boolean pBool) {
    this.aIsTestMode = pBool;
}

public boolean isTestMode() {
    return this.aIsTestMode;
}

public void setAleaRoom(final Room pRoom) {
    this.aAleaRoom = pRoom;
}

 /**
     * Interprets and executes a given command line string.
     * If the command ends the game, the game terminates.
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
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */

    
      /**
     * Retrieves the state of the restart game flag.
     * @return True if the game is ready to restart, false otherwise.
     */
    
    public boolean getRestartGame() {
        return this.aRestartGame;
    }
    public void setRestartGame(final boolean pBool) {
        this.aRestartGame = pBool;
    }
    
    
      /**
     * Ends the game, optionally prompting the player to restart the game.
     * @param pRestartQuestion True to ask the player if they want to restart, false to end the game.
     */
    
    private void endGame(final boolean pRestartQuestion)
    {
        if (pRestartQuestion) {
            this.aGui.println("Do you want to play again ?");
            this.aRestartGame = true;
        }
        else {
        this.aGui.println( "Thank you for playing.  Good bye." ); 
        this.aGui.enable( false );
            
        }
  
    }

}