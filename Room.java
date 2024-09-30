 import java.util.HashMap;
 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *     
 * @author Pierre MATAR
 */
public class Room
{
    
    private String aDescription;
    private HashMap<String, Room> aExits;
    
       
    
    public Room(final String pDescription) {
        this.aDescription = pDescription;
        aExits = new HashMap<String, Room>();
    }
    
    public String getDescription() {
        return this.aDescription;
    }
    public Room getExit(String pDirection) {
        return this.aExits.get(pDirection);
        
    }
    
    public String getExitString() {
        String vExitString = "Exits:  ";
        
        if(this.aExits.get("North") != null) { 
            vExitString += "north "; 
        } 
        if(this.aExits.get("South") != null) { 
            vExitString += "south "; 
        } 
         
        if(this.aExits.get("East") != null) { 
            vExitString += "east "; 
        } 
        if(this.aExits.get("West") != null) { 
            vExitString += "west "; 
        }
        if(this.aExits.get("Up") != null) { 
            vExitString += "up "; 
        }

        if(this.aExits.get("Down") != null) { 
            vExitString += "down "; 
        }

        return vExitString;
        
    }

     
    public void setExits(final String pDirection, final Room pNeighbor){
        aExits.put(pDirection, pNeighbor);
    }
} // Room
