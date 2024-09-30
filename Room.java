 import java.util.HashMap;
 import java.util.Set;
 
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
        
        for (String element : this.aExits.keySet()) {
            if (this.aExits.get(element) != null)
                vExitString += " "+ element;
        }

        return vExitString;
        
    }

     
    public void setExits(final String pDirection, final Room pNeighbor){
        aExits.put(pDirection, pNeighbor);
    }
} // Room
