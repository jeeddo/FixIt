import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GameEngine
{
    private Stack<Room> aItinerary;
    private Parser aParser;
    private UserInterface aGui;
    private Player aPlayer;
       
/**
     * Constructor for objects of class GameEngine
     */
  public GameEngine()
    {
        this.aParser = new Parser(this);
        this.aItinerary = new Stack<>();
        
    }
    
       public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printNameQuestion();
       
    }
    
    public boolean getItinerarySizeInfo() {
        return this.aItinerary.isEmpty();
    }
        /**
 * Creates the different rooms in the game.
 */

    private void createRooms() 
    {
    Room hall, developerRoom, serverRoom, meetingRoom, cafeteria, projectManagerOffice, openSpace, presentationRoom, Wc, maintenanceRoom;
    
    hall = new Room("in The entry hall.", "Images/hall.png");
    developerRoom = new Room("inside the developer room.", "Images/developerRoom.png");
    serverRoom = new Room("inside the server room.", "Images/serverRoom.png");
    meetingRoom = new Room("inside the meeting room.", "Images/meetingRoom.png");
    cafeteria = new Room("inside the cafétéria,", "Images/cafeteria.png");
    projectManagerOffice = new Room("inside the project manager office.", "Images/projectManagerOffice.png");
    openSpace = new Room("inside the open-space", "Images/openSpace.png");
    presentationRoom = new Room("inside the presenting room", "Images/presentationRoom.png");
    Wc = new Room("In the toilet...", "Images/Wc.png");
    maintenanceRoom = new Room("inside the maintenance room.", "Images/maintenanceRoom.png");
    
    Item one = new Item("Item", "Item 1 ", 300);
    Item two = new Item("Item 4", "Item 2 ", 200);
    
    Item three = new Item("Item3", "Item 3 ", 500);
    Item zero = new Item("Item0", "0", 100);
    Item magicCookie = new Item("magicCookie", "THE magic cookie !", 0);
    
    
    
    hall.setExits("North", null);
    hall.setExits("South", null);
    hall.setExits("East", null);
    hall.setExits("West", null);
    hall.setExits("Up", openSpace);
    hall.setExits("Down", null);
    hall.addItem(one);
    hall.addItem(zero);
    

    developerRoom.setExits("North", projectManagerOffice);
    developerRoom.setExits("South", null);
    developerRoom.setExits("East", null);
    developerRoom.setExits("West", serverRoom);
    developerRoom.setExits("Up", null);
    developerRoom.setExits("Down", meetingRoom);

 
    serverRoom.setExits("North", null);
    serverRoom.setExits("South", maintenanceRoom);
    serverRoom.setExits("East", developerRoom);
    serverRoom.setExits("West", null);
    serverRoom.setExits("Up", null);
    serverRoom.setExits("Down", null);

    
    meetingRoom.setExits("North", null);
    meetingRoom.setExits("South", null);
    meetingRoom.setExits("East", openSpace);
    meetingRoom.setExits("West", null);
    meetingRoom.setExits("Up", developerRoom);
    meetingRoom.setExits("Down", null);
    meetingRoom.addItem(two);

    
    cafeteria.setExits("North", presentationRoom);
    cafeteria.setExits("South", Wc);
    cafeteria.setExits("East", null);
    cafeteria.setExits("West", openSpace);
    cafeteria.setExits("Up", null);
    cafeteria.setExits("Down", null);

   
    projectManagerOffice.setExits("North", null);
    projectManagerOffice.setExits("South", developerRoom);
    projectManagerOffice.setExits("East", null);
    projectManagerOffice.setExits("West", null);
    projectManagerOffice.setExits("Up", null);
    projectManagerOffice.setExits("Down", null);
    projectManagerOffice.addItem(three);
    
    openSpace.setExits("North", null);
    openSpace.setExits("South", null);
    openSpace.setExits("East", cafeteria);
    openSpace.setExits("West", meetingRoom);
    openSpace.setExits("Up", null);
    openSpace.setExits("Down", hall);
    openSpace.addItem(three);
    

    
    presentationRoom.setExits("North", null);
    presentationRoom.setExits("South", cafeteria);
    presentationRoom.setExits("East", null);
    presentationRoom.setExits("West", null);
    presentationRoom.setExits("Up", null);
    presentationRoom.setExits("Down", null);

   
    Wc.setExits("North", cafeteria);
    Wc.setExits("South", null);
    Wc.setExits("East", null);
    Wc.setExits("West", null);
    Wc.setExits("Up", null);
    Wc.setExits("Down", null);
    
    maintenanceRoom.setExits("North", serverRoom);
    maintenanceRoom.setExits("South", null);
    maintenanceRoom.setExits("East", null);
    maintenanceRoom.setExits("West", null);
    maintenanceRoom.setExits("Up", null);
    maintenanceRoom.setExits("Down", null);
    maintenanceRoom.addItem(magicCookie);
    

    
    this.aPlayer.setCurrentRoom( hall);
    this.aItinerary.push(this.aPlayer.getCurrentRoom());
} // createRooms


    
    /**
 * Displays the welcome message to the player.
 */
    private void printWelcome() {
        this.aGui.println("Welcome " + this.aPlayer.getName().toUpperCase() + " to 404 : Pc not found !");
        this.aGui.println("World of Zuul is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help. \n");
        this.printLocationInfo();
    } //printWelcome
    private void printNameQuestion() {
        this.aGui.println("Hello, please enter your username...");
    }
    
    
    /**
 * Displays help with the list of available commands.
 */
    public void printHelp() {
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
 * Displays the detailed description of the current room.
 */

    public void look(){
        this.printLocationInfo();
    }
    
    /**
 * Displays a message indicating the player has eaten.
 */
    public void eat(final String pItemName) {
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        if (vCurrentRoom.getItem(pItemName) != null && pItemName.equals("magicCookie")) {
            this.aPlayer.setPlayerWeigth(this.aPlayer.getPlayerWeigth());
            this.aGui.println("Miam miam miammmmm, here is your weigth now : " + this.aPlayer.getPlayerWeigth());
            vCurrentRoom.removeItem(pItemName);
        }
        else this.aGui.println( this.aPlayer.getName().toUpperCase() + " has eaten now and he's not hungry any more");

    }
    
   private void take(final String pItemName) {
       Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        if (vCurrentRoom.getItem(pItemName) != null) {
            
            if (vCurrentRoom.getItem(pItemName).getItemWeigth() <= this.aPlayer.getPlayerWeigth()) {
                 this.aPlayer.addItem(vCurrentRoom.getItem(pItemName));
                this.aGui.println("You took : " + vCurrentRoom.getItem(pItemName).getItemString());
                this.aPlayer.setPlayerWeigth(- vCurrentRoom.getItem(pItemName).getItemWeigth());
                 vCurrentRoom.removeItem(pItemName);
                 this.aGui.println(this.aPlayer.getMyItemsList());  
            }
            else this.aGui.println("You can carry " + pItemName + " because you weigth available is :" + this.aPlayer.getPlayerWeigth());
            
            
        }
           
        else 
            this.aGui.println("this item does'nt exist in this room...");
    } 
    
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
    
    private void back(final String pXTime) {
        
        if (this.aItinerary.size() == 1)
            this.aGui.println("Back is no possible here...");
            
     
        else {
            if (pXTime == null) {
                this.aItinerary.pop();
                this.aPlayer.setCurrentRoom( this.aItinerary.peek());
                this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
                if ( this.aPlayer.getCurrentRoom().getImageName() != null )
                    this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
                return;
            }
            String[] vCommands = pXTime.split(" ");
            for(int i = 0; i < vCommands.length; i++) {
                if (!vCommands[i].equals("back")) 
                {
                   this.aGui.println("back what ?");
                   return;
                }
            }
        
            for (int i = 0; i < vCommands.length + 1; i++) {
                if (this.aItinerary.size() == 1) break;
                
                this.aItinerary.pop();
            }
            
        
                this.aPlayer.setCurrentRoom( this.aItinerary.peek());
            this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
            if ( this.aPlayer.getCurrentRoom().getImageName() != null )
                this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
        }
        
        
        
    }
    
 private void test(final Command pUneCommande) {
  
    if (!pUneCommande.hasSecondWord()) {
        this.aGui.println("Test what ?");
        return; 
    }

 
    String vSecondWord = pUneCommande.getSecondWord();

 
    File vDossier = new File("./tests");
    File vFichier = new File(vDossier, vSecondWord + ".txt");


    if (!vFichier.exists()) {
        this.aGui.println("Le fichier '" + vSecondWord + ".txt' n'existe pas.");
        return;  
    }

     try (Scanner vScanner = new Scanner(vFichier)) {
         while (vScanner.hasNextLine()) {
            
             this.interpretCommand(vScanner.nextLine());
        }
    } catch (IOException e) {
        System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
    }
}

private void items() {
    this.aGui.println(this.aPlayer.getMyItemsList());
}

    


/**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );
        
        if (vCommand == null) {
            this.aGui.println("Your name should not be a game command");
            return;
        }
        else if ( vCommand.isUnknown() ) {
            if (this.getItinerarySizeInfo()) {
                
                this.aPlayer = new Player(vCommand.getSecondWord());
                this.createRooms();
                this.printWelcome();
            }
            else {
                this.aGui.println( "I don't know what you mean..." );
                
            }
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
                this.endGame();
                 break;
        
          case LOOK:
            this.look();
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
            
        default:
            this.aGui.println("Erreur du programmeur : commande non reconnue !");
        
    }
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
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit( vDirection );
        
        if ( vNextRoom == null )
            this.aGui.println( "There is no door!" );
        else {
            this.aPlayer.setCurrentRoom(vNextRoom);
            this.aItinerary.push(this.aPlayer.getCurrentRoom());
            this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
            if ( this.aPlayer.getCurrentRoom().getImageName() != null )
                this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
        }
    }

    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." ); 
        this.aGui.enable( false );
    }

}

