 import java.util.HashMap;
 import java.util.Set;
 import java.util.ArrayList;
 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *     
 * @author Pierre MATAR
 */
public class Room
{
    
    private String aDescription;
    private HashMap<String, Room> aExits;
    private String aImageName;
    private ArrayList<Item> aItem;
    
       
    /**
 * Constructor for the room, initializes the description and exits.
 */

    public Room(final String pDescription, final String pImage) {
        this.aDescription = pDescription;
        aExits = new HashMap<String, Room>();
        this.aImageName = pImage;
        this.aItem = new ArrayList<Item>();
    }//Room
    /**
 * Returns the description of the room.
 */
    
    public String getDescription() {
        return this.aDescription;
    }//getDescription
    
    /**
 * Returns the room in the given direction.
 */
    
    public Room getExit(String pDirection) {
        return this.aExits.get(pDirection);
        
    }//getExit
    
    /**
 * Returns a string of available exits from the room.
 */
    
    public String getExitString() {
        StringBuilder vSb = new StringBuilder("Exits:  ");
        
        for (String element : this.aExits.keySet()) {
            if (this.aExits.get(element) != null)
                vSb.append(element+" ");
        }

        return vSb.toString();
        
    }//getExitString
    /**
 * Returns a detailed description of the room including exits.
 */
    
    public String getLongDescription() {
        
        return "You are " + this.aDescription + ".\n" + this.getExitString() +this.getAllItemString();
    }
    
    public String getAllItemString() {
        if (this.aItem.isEmpty()) 
            return ".\nNo item here. ";
        StringBuilder vSb = new StringBuilder("\nItems available :");
        
        for (Item item : this.aItem) {
            vSb.append(item.getName() +"\n");
        }

        return vSb.toString();
    }
    
    /**
 * Sets the exits from the room in the specified direction.
 */

     
    public void setExits(final String pDirection, final Room pNeighbor){
        this.aExits.put(pDirection, pNeighbor);
    }//setExits
    
    public String getImageName()
    {
         return this.aImageName;
   }
   
   public void addItem(final Item pItem) {
       this.aItem.add(pItem);
   }
} // Room
