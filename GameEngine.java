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
    
       
/**
     * Constructor for objects of class GameEngine
     */
  public GameEngine(final String pPlayerName)
    {
        this.aParser = new Parser(this);
        this.aPlayer = new Player(pPlayerName);
        this.aRooms = new ArrayList<Room>();
        this.createRooms();
  
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
 * Creates the different rooms in the game, along with their exits and items.
 */

    private void createRooms() 
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
    Item beamer = new Item("beamer", "the transporter room ! ", 200);
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
} // createRooms

public List<Room> getRooms() {
    return this.aRooms;
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
    private void printHelp() {
        this.aGui.println("You are lost. You are alone.");
        this.aGui.println("You wander around at the university.\n");
        this.aGui.println("Your command words are:");
        this.aGui.println(this.aParser.getCommands());
    }//printHelp
    

    

    /**
 * Displays the current room's description and its image.
 */

    
    private void printLocationInfo() {
        Room vRoom = this.aPlayer.getCurrentRoom();
        this.aGui.println(vRoom.getLongDescription());
        if ( vRoom.getImageName() != null )
            this.aGui.showImage( vRoom.getImageName() );
        
        
    } //printLocationInfo
    
    /**
 * Displays the detailed description of the current room or examines one or more objects in the current room.
 * @param pSecondWord The name of the object or list of objects separated by spaces.
 */

    private void look(final String pSecondWord){
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        if (pSecondWord == null)
            this.printLocationInfo();
        else {
            String[] vItemsToLook = pSecondWord.trim().split(" ");
            
            for (String pItemName : vItemsToLook) {
                if (vCurrentRoom.getItem(pItemName) == null) {
                    this.aGui.println( pItemName + " does'nt exist in this room...");
                    return;

                }
            }
            for (String pItemName : vItemsToLook) {
                this.aGui.println(vCurrentRoom.getItem(pItemName).getItemString());
            }
            
        }
        
        
            
    }
    
    /**
 * Displays a message indicating the player has eaten or allows to eat the magicCookie.
 * @param pItemName The name of the item to eat.
 */
    private void eat(final String pItemName) {
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        if ((vCurrentRoom.getItem(pItemName) != null || this.aPlayer.getItem(pItemName) != null) && pItemName.equals("magicCookie")) {
            this.aPlayer.setPlayerWeigth(this.aPlayer.getPlayerWeigth());
            this.aGui.println("Miam miam miammmmm, here is your weigth now : " + this.aPlayer.getPlayerWeigth());
            if (vCurrentRoom.getItem(pItemName) != null) vCurrentRoom.removeItem(pItemName);
            else this.aPlayer.removeItem(pItemName);
        }
        else this.aGui.println( this.aPlayer.getName().toUpperCase() + " has eaten now and he's not hungry any more");

    }
    
     /**
     * Checks if the player has fixed a bug using a specific object.
     * @param pSecondWord The keyword needed to complete the game.
     */
    
    private void fix(final String pSecondWord) {
        Item thePC = this.aPlayer.getItem("thePC");
        if ( thePC == null) this.aGui.println("You did'nt find your PC yet...");
        else if (thePC != null && (pSecondWord == null || !pSecondWord.equals("bug"))) this.aGui.println("ahh you were close !");
        else {
            this.aGui.println("YOUUUUUPIII you have fix the bug, you won the Game BRAVO !");
            this.endGame(true);
        }
        
        
        
    }
      /**
     * Allows the player to pick up an item in the current room if they can carry it.
     * @param pItemName The name of the item to pick up.
     */
    
   private void take(final String pItemName) {
       Item vRoomItem = this.aPlayer.getCurrentRoom().getItem(pItemName);
        if (vRoomItem != null) {
            
            if (vRoomItem.getItemWeigth() <= this.aPlayer.getPlayerWeigth()) {
                 this.aPlayer.addItem(vRoomItem);
                this.aGui.println("You took : " + vRoomItem.getItemString());
                this.aPlayer.setPlayerWeigth(- vRoomItem.getItemWeigth());
                 this.aPlayer.getCurrentRoom().removeItem(pItemName);
                 this.aGui.println(this.aPlayer.getMyItemsList());  
            }
            else this.aGui.println("You can carry " + pItemName + " because you weigth available is :" + this.aPlayer.getPlayerWeigth());
            
            
        }
           
        else 
            this.aGui.println("this item does'nt exist in this room...");
    } 
    
     /**
     * Allows the player to drop an item in the current room.
     * @param pItemName The name of the item to drop.
     */
    
    private void drop(final String pItemName) {
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        Item vPlayerItem = this.aPlayer.getItem(pItemName); 

        if ( vPlayerItem == null) this.aGui.println("You don't own " + pItemName);
        
        else if (vCurrentRoom.getItem(pItemName) != null) this.aGui.println("You are not allowed to put the same item in the room");
        
        else {
            vCurrentRoom.addItem(vPlayerItem);
            this.aPlayer.setPlayerWeigth(vPlayerItem.getItemWeigth());
            this.aPlayer.removeItem(pItemName);
            this.aGui.println("You droped " + pItemName);
        }
    }
    
       /**
     * Moves the player back to the previous room(s), depending on the command.
     * If a specific number of "back" commands is provided, it goes back that many times.
     * @param pXTime The number of times "back" is specified, or null for a single back.
     */
    
    private void back(final String pXTime) {
        
        if (this.aPlayer.getItinerarySize() == 1)
            this.aGui.println("Back is no possible here...");
            
     
        else {
            if (this.aPlayer.getCurrentRoom().isExit(this.aPlayer.getRoom(this.aPlayer.getItinerarySize( ) - 2)) || ( (TransporterRoom) (this.aPlayer.getRoom(this.aPlayer.getItinerarySize() - 2))).isATransporterRoom()) {
                 if (pXTime == null) {
                this.aPlayer.removeTopRoom();
                this.aPlayer.setCurrentRoom( this.aPlayer.getTopRoom());
                 this.printLocationInfo();
                return;
            }
            String[] vCommands = pXTime.trim().split(" ");
            for(int i = 0; i < vCommands.length; i++) {
                if (!vCommands[i].equals("back")) 
                {
                   this.aGui.println("back what ?");
                   return;
                }
            }
        
            for (int i = 0; i < vCommands.length + 1; i++) {
                if (this.aPlayer.getItinerarySize() == 1) break;
                
                this.aPlayer.removeTopRoom();
            }
            
        
            this.aPlayer.setCurrentRoom( this.aPlayer.getTopRoom());
            this.printLocationInfo();
                
            }
            else {
                this.aPlayer.clearItinerary();
                
                this.aPlayer.addRoom(this.aPlayer.getCurrentRoom());  
                
            }
        
           
           
        }
    }
    
    private void charge(final String pBeamerName) {
        if (pBeamerName == null) this.aGui.println("charge what ?");
        else if (! pBeamerName.equals("beamer")) this.aGui.println(pBeamerName + " is not the beamer");
        else if (this.aPlayer.getItem(pBeamerName) == null) this.aGui.println("You don't own the beamer");
        else {
            this.aPlayer.setBeamerRoom(this.aPlayer.getCurrentRoom());
            this.aGui.println("You charged the beamer");
        }
        
    }
    
    private void fire(final String pBeamerName) {
         if (pBeamerName == null) this.aGui.println("charge what ?");
        else if (! pBeamerName.equals("beamer")) this.aGui.println(pBeamerName + " is not the beamer");
        else if (this.aPlayer.getItem(pBeamerName) == null) this.aGui.println("You don't own the beamer");
        else if (this.aPlayer.getBeamerRoom() == null) this.aGui.println("You forget to charge it !");
        else {
            if (this.aPlayer.getCurrentRoom() == this.aPlayer.getBeamerRoom()) {
                this.aGui.println("You can not fire at the same room you charged the beamer...");
                return;
            }
            this.aPlayer.setCurrentRoom(this.aPlayer.getBeamerRoom());
            this.aPlayer.addRoom(this.aPlayer.getCurrentRoom());
            this.printLocationInfo();
            this.aPlayer.removeItem(pBeamerName);
        }
    }
    
    private void alea(final String pSecondCommandWord) {
        
        if (pSecondCommandWord != null && this.aIsTestMode) {
               for (Room room : this.aRooms) 
            if (room.getName().equals(pSecondCommandWord)) this.aAleaRoom = room;
        
        }
     
 
    }
    
    public Room getAleaRoom() {
        return this.aAleaRoom;
    }
    
    /**
     * Executes a series of commands from a test file located in the "./tests" directory.
     * @param pUneCommande The command specifying the test file to execute.
     */
 private void test(final Command pUneCommande) {
  
    if (!pUneCommande.hasSecondWord()) {
        this.aGui.println("Which file do you want to test ?");
        return; 
    }

 
    String vSecondWord = pUneCommande.getSecondWord();

 
    File vDossier = new File("./tests");
    File vFichier = new File(vDossier, vSecondWord + ".txt");


    if (!vFichier.exists()) {
        this.aGui.println("The file " + vSecondWord + ".txt' does not exist.");
        return;  
    }

     try (Scanner vScanner = new Scanner(vFichier)) {
        this.aIsTestMode = true;
         while (vScanner.hasNextLine()) {
            
             this.interpretCommand(vScanner.nextLine());
        }
        this.aIsTestMode = false;
    } catch (IOException e) {
        System.out.println("An error occured : " + e.getMessage());
    }
}

/**
* Displays the list of items currently in the player's inventory.
*/
private void items() {
    this.aGui.println(this.aPlayer.getMyItemsList());
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
        
   
        if ( vCommand.isUnknown() ) {
         
            if (this.aRestartGame) {
                if (vCommand.getSecondWord() == null) this.endGame(false); 
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
        
        if (this.aPlayer.getNbMoves() == 25) {
            this.aGui.println("you've reached the maximum number of attempts (25)... ");
            this.endGame(true);
            return;
            
        }

        CommandWord vCommandWord = vCommand.getCommandWord();
        
        switch (vCommandWord) {
            case HELP:
                this.printHelp();
                 break;
            case GO:
                this.goRoom( vCommand );
                 break;
            case QUIT:
                if ( vCommand.hasSecondWord() )
                this.aGui.println( "Quit what?" );
            else
                this.endGame(false);
                 break;
        
          case LOOK:
            this.look(vCommand.getSecondWord());
             break;
        
    
        case EAT: 
            this.eat(vCommand.getSecondWord());
             break;
        
        case BACK:
            this.back(vCommand.getSecondWord());
             break;
        case TEST:
            this.test(vCommand);
             break;
        case TAKE:
            if (!vCommand.hasSecondWord()) this.aGui.println("Take what ?");
            else this.take(vCommand.getSecondWord());
             break;
        
        
        case DROP: 
            if (!vCommand.hasSecondWord()) this.aGui.println("Drop what ?");
            else this.drop(vCommand.getSecondWord());
            break;
        
        case ITEMS:
            this.items();
            break;
        case FIX:
            this.fix(vCommand.getSecondWord());
            break;
        
        case CHARGE: 
            this.charge(vCommand.getSecondWord());
            break;
            
        case FIRE:
            this.fire(vCommand.getSecondWord());
            break;
        case ALEA:
            this.alea(vCommand.getSecondWord());
            break;
            
        default:
            this.aGui.println("Erreur du programmeur : commande non reconnue !");
        
    }
            this.aPlayer.addOneMove();

   
}
        

        

 /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom( final Command pCommand ) 
    {
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "Go where?" );
            return;
        }
        



        String vDirection = pCommand.getSecondWord();
        
        // Try to leave current room.
        Room vPreviousRoom = this.aPlayer.getCurrentRoom();
        Room vNextRoom = vPreviousRoom.getExit( vDirection );

        
        if ( vNextRoom == null )
            this.aGui.println( "There is no door!" );
        else {
            if (vPreviousRoom.isLockedDoor(vDirection) && this.aPlayer.getItem(vPreviousRoom.getDoorKeyItemName(vDirection)) == null) {
                    this.aGui.println("You don't have the key to go to the " + vDirection);
                    return;
            }
            
            this.aPlayer.setCurrentRoom(vNextRoom);
            this.aPlayer.addRoom(vNextRoom);
            
            
            if (vPreviousRoom.isTrapDoor(vDirection)) {
                switch (vDirection) {
                    case "North": vNextRoom.removeDirection("South"); break;
                    case "South": vNextRoom.removeDirection("North"); break;
                    case "West" : vNextRoom.removeDirection("East"); break;
                    case "East": vNextRoom.removeDirection("West");
                }
            }
                if (( (TransporterRoom) vPreviousRoom).isATransporterRoom()) {
                this.aPlayer.removeTopRoom();
                Room vRandomRoom = vPreviousRoom.getExit(null);
                this.aPlayer.setCurrentRoom(vRandomRoom);
                this.aPlayer.addRoom(vRandomRoom);

            }
            this.printLocationInfo();
        }
    }
    
      /**
     * Retrieves the state of the restart game flag.
     * @return True if the game is ready to restart, false otherwise.
     */
    
    public boolean getRestartGame() {
        return this.aRestartGame;
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

