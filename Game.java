 
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
    
    hall.setExits("North", null);
    hall.setExits("South", null);
    hall.setExits("East", null);
    hall.setExits("West", null);
    hall.setExits("Up", openSpace);
    hall.setExits("Down", null);

    // Developer Room configuration
    developerRoom.setExits("North", projectManagerOffice);
    developerRoom.setExits("South", null);
    developerRoom.setExits("East", null);
    developerRoom.setExits("West", serverRoom);
    developerRoom.setExits("Up", null);
    developerRoom.setExits("Down", meetingRoom);

    // Server Room configuration
    serverRoom.setExits("North", null);
    serverRoom.setExits("South", null);
    serverRoom.setExits("East", developerRoom);
    serverRoom.setExits("West", null);
    serverRoom.setExits("Up", null);
    serverRoom.setExits("Down", null);

    // Meeting Room configuration
    meetingRoom.setExits("North", null);
    meetingRoom.setExits("South", null);
    meetingRoom.setExits("East", openSpace);
    meetingRoom.setExits("West", null);
    meetingRoom.setExits("Up", developerRoom);
    meetingRoom.setExits("Down", null);

    // Cafeteria configuration
    cafeteria.setExits("North", presentationRoom);
    cafeteria.setExits("South", Wc);
    cafeteria.setExits("East", null);
    cafeteria.setExits("West", openSpace);
    cafeteria.setExits("Up", null);
    cafeteria.setExits("Down", null);

    // Project Manager Office configuration
    projectManagerOffice.setExits("North", null);
    projectManagerOffice.setExits("South", developerRoom);
    projectManagerOffice.setExits("East", null);
    projectManagerOffice.setExits("West", null);
    projectManagerOffice.setExits("Up", null);
    projectManagerOffice.setExits("Down", null);

    // Open Space configuration
    openSpace.setExits("North", null);
    openSpace.setExits("South", null);
    openSpace.setExits("East", cafeteria);
    openSpace.setExits("West", meetingRoom);
    openSpace.setExits("Up", null);
    openSpace.setExits("Down", hall);

    // Presentation Room configuration
    presentationRoom.setExits("North", null);
    presentationRoom.setExits("South", cafeteria);
    presentationRoom.setExits("East", null);
    presentationRoom.setExits("West", null);
    presentationRoom.setExits("Up", null);
    presentationRoom.setExits("Down", null);

    // Wc configuration
    Wc.setExits("North", cafeteria);
    Wc.setExits("South", null);
    Wc.setExits("East", null);
    Wc.setExits("West", null);
    Wc.setExits("Up", null);
    Wc.setExits("Down", null);

    
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
        
        if (!vDirection.equals("North") && !vDirection.equals("South") && !vDirection.equals("East") && !vDirection.equals("West") && !vDirection.equals("Up") && !vDirection.equals("Down"))
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
        System.out.println("Type 'help' if you need help. \n");
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
    } //quit
    
    private void play() {
        this.printWelcome();
        boolean vFinished = false;
        while (!vFinished) {
            Command vResultat = this.aParser.getCommand();
            vFinished = this.processCommand(vResultat);
        }
        System.out.println("Thank you for playing. Good bye.");
    }//play
    
    private void printLocationInfo() {
        
        System.out.println( "\nYou are " + this.aCurrentRoom.getDescription()); 
        System.out.println(this.aCurrentRoom.getExitString() + "\n");
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
    
}//processCommand
} // Game
