package v1;
/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author Pierre MATAR
 */
public class Game extends CommandWords
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    private void createRooms() 
    {
        //Création des 5 lieux
        Room vOutside = new Room("outside the main entrance of the university");
        Room vTheatre = new Room("in a lecture theatre");
        Room vPub = new Room("in the campus pub");
        Room vLab = new Room("in a computing lab");
        Room vOffice = new Room("in the computing admin office");
        
        //Positionnement des sorties
        
        vOutside.setExits(null, vLab, vTheatre, vPub);
        vTheatre.setExits(null, null, null, vOutside);
        vPub.setExits(null, null, vOutside, null);
        vLab.setExits(vOutside, null, vOffice, null);
        vOffice.setExits(null, null, null, vLab);
        
        // Current Room
        
        this.aCurrentRoom = vOutside;
        
        
    } //createRooms
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
        if (vDirection.equals("North")){
            if (this.aCurrentRoom.aNorthExit == null){
                System.out.println("There is no door !");
                return;
            }
            
            this.aCurrentRoom = this.aCurrentRoom.aNorthExit;
            System.out.println(this.aCurrentRoom.getDescription());
            System.out.print("Exits : ");
            if (this.aCurrentRoom.aNorthExit != null) {
                System.out.print(" North ");
            }
            if (this.aCurrentRoom.aSouthExit != null) {
                System.out.print(" South ");
            }
            if (this.aCurrentRoom.aEastExit != null) {
                System.out.print(" East ");
            }
            if (this.aCurrentRoom.aWestExit != null) {
                System.out.print(" West ");
            }
        }
        else if (vDirection.equals("South")){
            if (this.aCurrentRoom.aSouthExit == null){
                System.out.println("There is no door !");
                return;
            }
            this.aCurrentRoom = this.aCurrentRoom.aSouthExit;
            System.out.println(this.aCurrentRoom.getDescription());
            System.out.print("Exits :");
            if (this.aCurrentRoom.aNorthExit != null) {
                System.out.print(" North ");
            }
            if (this.aCurrentRoom.aSouthExit != null) {
                System.out.print(" South ");
            }
            if (this.aCurrentRoom.aEastExit != null) {
                System.out.print(" East ");
            }
            if (this.aCurrentRoom.aWestExit != null) {
                System.out.print(" West ");
            }
        }
        else if (vDirection.equals("East")){
            if (this.aCurrentRoom.aEastExit == null){
                System.out.println("There is no door !");
                return;
            }
            this.aCurrentRoom = this.aCurrentRoom.aEastExit;
            System.out.println(this.aCurrentRoom.getDescription());
            System.out.print("Exits :");
            if (this.aCurrentRoom.aNorthExit != null) {
                System.out.print(" North ");
            }
            if (this.aCurrentRoom.aSouthExit != null) {
                System.out.print(" South ");
            }
            if (this.aCurrentRoom.aEastExit != null) {
                System.out.print(" East ");
            }
            if (this.aCurrentRoom.aWestExit != null) {
                System.out.print(" West ");
            }
        }
        else if (vDirection.equals("West")) {
            if (this.aCurrentRoom.aWestExit == null){
                System.out.println("There is no door !");
                return;
            }
            this.aCurrentRoom = this.aCurrentRoom.aWestExit;
            System.out.println(this.aCurrentRoom.getDescription());
            System.out.print("Exits :");
            if (this.aCurrentRoom.aNorthExit != null) {
                System.out.print(" North ");
            }
            if (this.aCurrentRoom.aSouthExit != null) {
                System.out.print(" South ");
            }
            if (this.aCurrentRoom.aEastExit != null) {
                System.out.print(" East ");
            }
            if (this.aCurrentRoom.aWestExit != null) {
                System.out.print(" West ");
            }
            
        }
        else
        {
            System.out.println("Unknown direction !");
            return;
        }
        
    } //goRoom
    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help. \n \n");
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
        System.out.println(this.aCurrentRoom.getDescription());
        boolean vFinished = false;
        while (vFinished == false) {
            Command vResultat = this.aParser.getCommand();
            if (vResultat.getCommandWord() == null) {
            System.out.println("Erreur du programmeur : commande non reconnue !");
            }
            else if (vResultat.getCommandWord().equals("quit")){
                vFinished = this.quit(vResultat);
                if (vFinished == true) 
                    System.out.println("Thank you for playing.  Good bye.");

            }
            else if (vResultat.getCommandWord().equals("go")){
                this.goRoom(vResultat);
            }
            else if (vResultat.getCommandWord().equals("help")) {
                this.printHelp();
            }
        }
    }
    private boolean processCommand(final Command pUneCommande) {
        if (pUneCommande.getCommandWord().equals("go")) {
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
        else if (pUneCommande.isUnknown()) {
        System.out.println("I don't know what you mean...");
        return false;
    }
    else {
        System.out.println("Erreur du programmeur : commande non reconnue !");
        return false;
    }
    
}
} // Game