package src.pkg_game;
import src.pkg_commands.Parser;
import src.pkg_rooms.Room;
import src.pkg_items.*;
import src.pkg_models.*;
import src.pkg_rooms.TransporterRoom;
import src.pkg_commands.Command;
import src.pkg_commands.QuitCommand;
import src.pkg_commands.EatCommand;
import src.pkg_commands.CommandWord;
import src.pkg_commands.UnknownCommand;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
    private List<Characterr> aCharacters;
    

/**
     * Constructor for objects of class GameEngine
     */
  public GameEngine(final String pPlayerName)
    {
        this.aParser = new Parser(this);
        this.aPlayer = new Player(pPlayerName);
        this.aRooms = new ArrayList<Room>();
        this.aItemsToEat = new ItemList();
        this.aCharacters = new ArrayList<Characterr>();
        this.createRoomsWithConfiguration();
  
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
 * Creates the different rooms with their configuration (exits / items / characters).
 */

    private void createRoomsWithConfiguration() 
    {
        
    HashMap<String, Item> vItems = this.createItems();
    HashMap<String, Characterr> vCharacters = this.createCharacters(vItems);
    
    Room hall, developerRoom, serverRoom, meetingRoom, cafeteria, projectManagerOffice, openSpace, presentationRoom, Wc, maintenanceRoom;
    
    hall = new TransporterRoom("hall", "in The entry hall.", "assets/images/Hall.jpg");
    developerRoom = new TransporterRoom("developerRoom","inside the developer room.", "assets/images/Developer.jpg");
    serverRoom = new TransporterRoom("serverRoom","inside the server room.", "assets/images/Server.jpg");
    meetingRoom = new TransporterRoom("meetingRoom","inside the meeting room.", "assets/images/Meeting.jpg");
    cafeteria = new TransporterRoom("cafeteria","inside the cafeteria,", "assets/images/Cafeteria.jpg");
    projectManagerOffice = new TransporterRoom("projectManagerOffice", "inside the project manager office.", "assets/images/ProjectManager.jpg", true, this);
    openSpace = new TransporterRoom("openSpace","inside the open-space", "assets/images/OpenSpace.jpg");
    presentationRoom = new TransporterRoom("presentationRoom","inside the presenting room", "assets/images/Presentation.jpg");
    Wc = new TransporterRoom("Wc","In the toilet...", "assets/images/Wc.jpg");
    maintenanceRoom = new TransporterRoom("maintenanceRoom","inside the maintenance room.", "assets/images/Maintenance.jpg");
 
    
    
    hall.setExit("North", null);
    hall.setExit("South", null);
    hall.setExit("East", null);
    hall.setExit("West", null);
    hall.setExit("Up", openSpace);
    hall.setExit("Down", null);
    hall.addItem(vItems.get("apple"));
    hall.addItem(vItems.get("welcomeNote"));
    hall.addItem(vItems.get("trelloTask"));
    hall.addCharacter(vCharacters.get("Christy"));

    developerRoom.setExit("North", projectManagerOffice);
    developerRoom.setExit("South", null);
    developerRoom.setExit("East", null);
    developerRoom.setExit("West", serverRoom);
    developerRoom.setExit("Up", null);
    developerRoom.setExit("Down", meetingRoom);
    developerRoom.addCharacter(vCharacters.get("Jeremy"));


 
    serverRoom.setExit("North", null);
    serverRoom.setExit("South", maintenanceRoom);
    serverRoom.setExit("East", developerRoom, false, null, true);
    serverRoom.setExit("West", null);
    serverRoom.setExit("Up", null);
    serverRoom.setExit("Down", null);
    serverRoom.addItem(this.aMagicCookie);
    serverRoom.addItem(this.aPlayer.getBeamer());

    
    meetingRoom.setExit("North", null);
    meetingRoom.setExit("South", null);
    meetingRoom.setExit("East", openSpace);
    meetingRoom.setExit("West", null);
    meetingRoom.setExit("Up", developerRoom, true, vItems.get("key"), false);
    meetingRoom.setExit("Down", null);
    meetingRoom.addCharacter(vCharacters.get("Rim"));
    meetingRoom.addItem(vItems.get("juice"));
    

    
    cafeteria.setExit("North", presentationRoom, true, vItems.get("keyCard"), false);
    cafeteria.setExit("South", null);
    cafeteria.setExit("East", null);
    cafeteria.setExit("West", openSpace);
    cafeteria.setExit("Up", null);
    cafeteria.setExit("Down", Wc);
    cafeteria.addItem(vItems.get("roastBeef"));


   
    projectManagerOffice.setExit("North", null);
    projectManagerOffice.setExit("South", developerRoom);
    projectManagerOffice.setExit("East", null);
    projectManagerOffice.setExit("West", null);
    projectManagerOffice.setExit("Up", null);
    projectManagerOffice.setExit("Down", null);
    projectManagerOffice.addItem(vItems.get("keyCard"));
    projectManagerOffice.addCharacter(vCharacters.get("Mathieu"));
    ((MovingCharacter) vCharacters.get("Mathieu")).setRoom(projectManagerOffice);

    
    openSpace.setExit("North", null);
    openSpace.setExit("South", null);
    openSpace.setExit("East", cafeteria);
    openSpace.setExit("West", meetingRoom);
    openSpace.setExit("Up", null);
    openSpace.setExit("Down", hall);
    openSpace.addItem(vItems.get("postIt"));
    openSpace.addItem(vItems.get("laptop"));

    
    presentationRoom.setExit("North", null);
    presentationRoom.setExit("South", cafeteria);
    presentationRoom.setExit("East", null);
    presentationRoom.setExit("West", null);
    presentationRoom.setExit("Up", null);
    presentationRoom.setExit("Down", null);
    presentationRoom.addItem(vItems.get("coffee"));
    presentationRoom.addItem(this.aThePC);

   
    Wc.setExit("North", null);
    Wc.setExit("South", null);
    Wc.setExit("East", null);
    Wc.setExit("West", null);
    Wc.setExit("Up", cafeteria);
    Wc.setExit("Down", null);
    Wc.addItem(vItems.get("toothbrush"));
    Wc.addItem(vItems.get("key"));
    
    maintenanceRoom.setExit("North", serverRoom);
    maintenanceRoom.setExit("South", null);
    maintenanceRoom.setExit("East", null);
    maintenanceRoom.setExit("West", null);
    maintenanceRoom.setExit("Up", null);
    maintenanceRoom.setExit("Down", null);
    maintenanceRoom.addItem(vItems.get("toolbox"));
    maintenanceRoom.addItem(vItems.get("kebab"));
    

    
    this.aPlayer.setCurrentRoom(hall);
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
} // createRooms

/**
 * Create all items needed for the game.
 */
private HashMap<String, Item> createItems() {
       
    HashMap<String, Item> vItems = new HashMap<String, Item>();
    
    Item welcomeNote = new Item("welcomeNote", "Hi, " + this.aPlayer.getName() + ".\nThe goal of FixIt is very simple : find your PC and fix the bug with the fix command !", 20);
    Item apple = new Item("apple", "An apple to give you the strength for this adventure", 150);
    Item key = new Item("key", "key to open the developers room", 100);
    Item juice = new Item("juice", "An orange juice", 50);
    Item roastBeef = new Item("roastBeef", "a roastBeef for Rim", 220);
    Item kebab = new Item("kebab", "kebab menu from Berlin", 300);
    Item coffee = new Item("coffee", "drink this coffee", 100);
    Item postIt = new Item("postIt", "hello " + this.aPlayer.getName() + ", how are you today ?", 20);
    Item toothbrush = new Item("toothbrush", "do you want to clean your theeth ?", 40);
    Item magicCookie = new Item("magicCookie", "THE magic cookie !", 0);
    Item thePC = new Item("thePC", "the holy grail", 500);
    Beamer beamer = new Beamer("beamer", "the transporter room !", 300);
    Item keyCard = new Item("keyCard", "keyCard to go in the presentation room", 250);
    Item trelloTask = new Item("trelloTask", "final task : Fix the bug in the FixIt project", 70);
    Item  toolbox = new Item("toolbox", "a toolBox with severals tools...", 250);
    Item laptop = new Item("laptop", "ohh nooo, this is not your PC !", 210);
    
    vItems.put(welcomeNote.getName(), welcomeNote);
    vItems.put(apple.getName(), apple);
    vItems.put(key.getName(), key);
    vItems.put(juice.getName(), juice);
    vItems.put(roastBeef.getName(), roastBeef);
    vItems.put(kebab.getName(), kebab);
    vItems.put(coffee.getName(), coffee);
    vItems.put(postIt.getName(), postIt);
    vItems.put(toothbrush.getName(), toothbrush);
    vItems.put(magicCookie.getName(), magicCookie);
    vItems.put(thePC.getName(), thePC);
    vItems.put(beamer.getName(), beamer);
    vItems.put(keyCard.getName(), keyCard);
    vItems.put(trelloTask.getName(), trelloTask);
    vItems.put(toolbox.getName(), toolbox);
    vItems.put(laptop.getName(), laptop);
    
    this.aMagicCookie = magicCookie;
    this.aThePC = thePC;
    
    this.aPlayer.setBeamer(beamer);
    
    this.aItemsToEat.addItem(magicCookie);
    this.aItemsToEat.addItem(apple);
    this.aItemsToEat.addItem(juice);
    this.aItemsToEat.addItem(coffee);
    this.aItemsToEat.addItem(kebab);
    this.aItemsToEat.addItem(roastBeef);
   

    return vItems;
    
} //createItems

/**
 * Create all characters needed for the game.
 * @param the items to add to chracters if needed.
 */
private HashMap<String, Characterr> createCharacters(final HashMap<String, Item> pItems) {
    HashMap<String, Characterr> vCharacters = new HashMap<String, Characterr>();
    
    Characterr vChristy = new Characterr("Christy", "Welcome to Webtech, have a nice day !", null, null);
    Characterr vRim = new Characterr("Rim", "I'm hungry I want my roast beef please", "Miammmmmmm so good, thank u very much !", pItems.get("roastBeef"));
    MovingCharacter vMathieu = new MovingCharacter("Mathieu", "Hi, I'm the project manager.", "Maybe you can find your PC in the presentation room.", pItems.get("trelloTask"));
    Characterr vJeremy = new Characterr("Jeremy", "Hello, I'm a senior full stack developer, do you want some help ?", "You can solve the problem on your PC with the string 'bug'", pItems.get("laptop"));


    vCharacters.put(vRim.getName(), vRim);
    vCharacters.put(vChristy.getName(), vChristy);
    vCharacters.put(vMathieu.getName(), vMathieu);  
    vCharacters.put(vJeremy.getName(), vJeremy);
       
   
    this.aCharacters.addAll(Arrays.asList(vRim, vChristy, vMathieu, vJeremy));
    
    return vCharacters;
} //createCharacters

 /**
* @return List of rooms.
*/

public List<Room> getRooms() {
    return this.aRooms;
}

    /**
     * @return List of characters.
     */
    
public List<Characterr> getCharacters() {
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

                if (vSecondWord == null || !vSecondWord.equals("yes")) this.invokeQuitCommand(false);
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
        
        if (this.aPlayer.isNbMaxMovesReached()) {
            this.aGui.println("you've reached the maximum number of attempts ( " + this.aPlayer.getMaxMoves() + " )... ");
            this.invokeQuitCommand(true);
            return;
        }
        
        vCommand.execute(this.aPlayer, this);
        this.aPlayer.addOneMove();
}
    
    /**
     * @return a list of items eatable.
     */
    
    public ItemList getItemsToEat() {
        return this.aItemsToEat;
    }
        
    /**
     * Allow to quit the game.
     * @param false to quit immediately, true to ask to restart the game.
     */
    
    private void invokeQuitCommand(final boolean pShouldRestart) {
        
            QuitCommand vQuitCommand = (QuitCommand) CommandWord.QUIT.getCommand();
            vQuitCommand.setState(pShouldRestart);
            vQuitCommand.execute(this.aPlayer, this);
           
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
