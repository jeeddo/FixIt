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
    private HashMap<String, Boolean> aTrapDoors;
    private String aImageName;
    private ItemList aItems;
    
       
    /**
 * Constructor for the room, initializes the description and exits.
 */

    public Room(final String pDescription, final String pImage) {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aTrapDoors = new HashMap<String, Boolean>();
        this.aImageName = pImage;
        this.aItems = new ItemList();
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
        
        return "You are " + this.aDescription + ".\n" + this.getExitString() +this.aItems.getAllItemString(this);
    }
    
 
    
    /**
 * Sets the exits from the room in the specified direction.
 */

     
       public void setExit(final String pDirection, final Room pNeighbor, final Boolean pIsTrapDoor) {
        this.aExits.put(pDirection, pNeighbor);
        this.aTrapDoors.put(pDirection, pIsTrapDoor != null ? pIsTrapDoor : false );
    }
    
    public void setExit(final String pDirection, final Room pNeighbor) {
        this.setExit(pDirection, pNeighbor, false);
    }
    
    public String getImageName()
    {
         return this.aImageName;
   }
    public boolean isExit(Room pRoom) {
        return this.aExits.containsValue(pRoom);
    }
     public boolean isTrapDoor(String pDirection) {
        return this.aTrapDoors.get(pDirection);
    }
   
    public void removeDirection(final String pDirection) {
        this.aExits.remove(pDirection);
    }
   
    public void addItem(final Item pItem) {
        this.aItems.addItem(pItem);
    }
    public Item getItem(final String pItemName) {
        return this.aItems.getItem(pItemName);
    }
    
    public void removeItem(final String pItemName) {
        this.aItems.removeItem(pItemName);
    }
   
} // Room
