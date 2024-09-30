 
/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author Pierre MATAR
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
       
    
    private void createRooms() 
    {
    
    Room hall = new Room("in The entry hall.");
    Room developerRoom = new Room("inside the developer room.");
    Room serverRoom = new Room("inside the server room.");
    Room meetingRoom = new Room("inside the meeting room.");
    Room cafeteria = new Room("inside the cafétéria,");
    Room projectManagerOffice = new Room("inside the project manager office.");
    Room openSpace = new Room("inside the open-space");
    Room presentationRoom = new Room("inside the presenting room");
    Room Wc = new Room("In the toilet...");

    hall.setExits(openSpace, null, null, null);
    developerRoom.setExits(projectManagerOffice, null, null, serverRoom);
    serverRoom.setExits(null, null, developerRoom, null);
    meetingRoom.setExits(null, null, openSpace, null);
    cafeteria.setExits(presentationRoom, Wc, null, openSpace);
    projectManagerOffice.setExits(null, developerRoom, null, null);
    openSpace.setExits(null, null, cafeteria, meetingRoom);
    presentationRoom.setExits(null, cafeteria, null, null);
    Wc.setExits(cafeteria, null, null, null);

    this.aCurrentRoom = hall;
} // createRooms

    public Game() {
        this.createRooms();
        this.aParser = new Parser();
        
        this.play();
        
    }//Game
    
    
    private void goRoom(final Command pCommande)
    {
        if (!pCommande.hasSecondWord()) {
            System.out.println("Go where ?");
            return;
        }
        String vDirection = pCommande.getSecondWord();
        
        if (!vDirection.equals("North") && !vDirection.equals("South") && !vDirection.equals("East") && !vDirection.equals("West"))
        {
            System.out.println("Unknown direction !");
            return;
        }
        
        if (this.aCurrentRoom.getExit(vDirection) == null){
            System.out.println("There is no door !");
            return;
        }
 
            
        this.aCurrentRoom = this.aCurrentRoom.getExit(vDirection);
        this.printLocationInfo();
       
        
    } //goRoom
    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help. \n \n");
        this.printLocationInfo();
    } //printWelcome
    
    public void printHelp() {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the university.\n");
        System.out.println("Your command words are:");
        System.out.println(" go quit help");
    }//printHelp
    
    private boolean quit(final Command pUneCommande) {
        if (pUneCommande.hasSecondWord()){ 
            System.out.println("Quit what ?");
            return false;
        }
        else
            return true;
    }
    
    private void play() {
        this.printWelcome();
        boolean vFinished = false;
        while (!vFinished) {
            Command vResultat = this.aParser.getCommand();
            vFinished = this.processCommand(vResultat);
        }
        System.out.println("Thank you for playing. Good bye.");
    }
    
    private void printLocationInfo() {
        
        System.out.println( "You are " + this.aCurrentRoom.getDescription()); 
        System.out.print( "Exits: " ); 
        if(this.aCurrentRoom.getExit("North") != null) { 
            System.out.print( "north "); 
        } 
        if(this.aCurrentRoom.getExit("South") != null) { 
            System.out.print( "south " ); 
        } 
         
        if(this.aCurrentRoom.getExit("East") != null) { 
            System.out . print( "east "); 
        } 
        if(this.aCurrentRoom.getExit("West") != null) { 
            System.out.print( "west " ); 
        } 
        System.out.println();
    } //printLocationInfo
    
    private boolean processCommand(final Command pUneCommande) {
        if (pUneCommande.isUnknown()) {
        System.out.println("I don't know what you mean...");
        return false;
    }
        else if (pUneCommande.getCommandWord().equals("go")) {
        goRoom(pUneCommande);
        return false;
    } 
        else if (pUneCommande.getCommandWord().equals("quit")) {
        return quit(pUneCommande);
    } 
        else if (pUneCommande.getCommandWord().equals("help")) {
        printHelp();
        return false;
    } 
      
    else {
        System.out.println("Erreur du programmeur : commande non reconnue !");
        return false;
    }
    
}
} // Game
