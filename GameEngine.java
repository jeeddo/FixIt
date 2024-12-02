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
    private Room aCurrentRoom;
    private Stack<Room> aItinerary;
    private Parser aParser;
    private UserInterface aGui;
       
/**
     * Constructor for objects of class GameEngine
     */
  public GameEngine()
    {
        this.aParser = new Parser();
        this.aItinerary = new Stack<>();
        this.createRooms();
        
    }
    
       public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
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
    
    Item three = new Item("Item 5", "Item 3 ", 500);
    
    
    
    hall.setExits("North", null);
    hall.setExits("South", null);
    hall.setExits("East", null);
    hall.setExits("West", null);
    hall.setExits("Up", openSpace);
    hall.setExits("Down", null);
    hall.addItem(one);
    

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

    
    this.aCurrentRoom = hall;
    this.aItinerary.push(this.aCurrentRoom);
} // createRooms


    
    /**
 * Displays the welcome message to the player.
 */
    private void printWelcome() {
        this.aGui.println("Welcome to 404 : Pc not found !");
        this.aGui.println("World of Zuul is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help. \n");
        this.printLocationInfo();
    } //printWelcome
    
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
        
        this.aGui.println(this.aCurrentRoom.getLongDescription());
        if ( this.aCurrentRoom.getImageName() != null )
            this.aGui.showImage( this.aCurrentRoom.getImageName() );
        
        
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
    public void eat() {
        this.aGui.println("You have eaten now and you are not hungry any more");
    }
    
    private void back(final String pXTime) {
        
        if (this.aItinerary.size() == 1)
            this.aGui.println("Back is no possible here...");
            
     
        else {
            if (pXTime == null) {
                this.aItinerary.pop();
                this.aCurrentRoom = this.aItinerary.peek();
                this.aGui.println( this.aCurrentRoom.getLongDescription() );
                if ( this.aCurrentRoom.getImageName() != null )
                    this.aGui.showImage( this.aCurrentRoom.getImageName() );
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
            
        
            this.aCurrentRoom = this.aItinerary.peek();
            this.aGui.println( this.aCurrentRoom.getLongDescription() );
            if ( this.aCurrentRoom.getImageName() != null )
                this.aGui.showImage( this.aCurrentRoom.getImageName() );
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

    


/**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "help" ) )
            this.printHelp();
        else if ( vCommandWord.equals( "go" ) )
            this.goRoom( vCommand );
        else if ( vCommandWord.equals( "quit" ) ) {
            if ( vCommand.hasSecondWord() )
                this.aGui.println( "Quit what?" );
            else
                this.endGame();
        }
          else if (vCommandWord.equals("look")) 
        this.look();
        
    
        else if (vCommandWord.equals("eat")) 
            this.eat();
        
        else if (vCommandWord.equals("back"))
            this.back(vCommand.getSecondWord());
        else if (vCommandWord.equals("test"))
            this.test(vCommand);
      
    else {
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
        Room vNextRoom = this.aCurrentRoom.getExit( vDirection );
        
        if ( vNextRoom == null )
            this.aGui.println( "There is no door!" );
        else {
            this.aCurrentRoom = vNextRoom;
            this.aItinerary.push(this.aCurrentRoom);
            this.aGui.println( this.aCurrentRoom.getLongDescription() );
            if ( this.aCurrentRoom.getImageName() != null )
                this.aGui.showImage( this.aCurrentRoom.getImageName() );
        }
    }

    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." ); 
        this.aGui.enable( false );
    }



}

