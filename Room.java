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
 * Sets an exit in a given direction, specifying if it is a trap door.
 * 
 * @param pDirection  The direction of the exit.
 * @param pNeighbor   The neighboring room in the specified direction.
 * @param pIsTrapDoor True if the exit is a trap door; otherwise, false.
 */
       public void setExit(final String pDirection, final Room pNeighbor, final Boolean pIsTrapDoor) {
        this.aExits.put(pDirection, pNeighbor);
        this.aTrapDoors.put(pDirection, pIsTrapDoor != null ? pIsTrapDoor : false );
    }
    
    /**
 * Sets an exit in a given direction without specifying trap door status.
 * By default, the exit is not a trap door.
 * 
 * @param pDirection The direction of the exit.
 * @param pNeighbor  The neighboring room in the specified direction.
 */
    
    public void setExit(final String pDirection, final Room pNeighbor) {
        this.setExit(pDirection, pNeighbor, false);
    }
    
    /**
 * Returns the name of the image file associated with the room.
 * 
 * @return The image file name.
 */
    
    public String getImageName()
    {
         return this.aImageName;
   }
   
   /**
 * Checks if a given room is one of the exits from the current room.
 * 
 * @param pRoom The room to check.
 * @return True if the specified room is an exit; otherwise, false.
 */
    public boolean isExit(Room pRoom) {
        return this.aExits.containsValue(pRoom);
    }
    
    /**
 * Checks if the exit in a specified direction is a trap door.
 * 
 * @param pDirection The direction to check.
 * @return True if the exit is a trap door; otherwise, false.
 */
     public boolean isTrapDoor(String pDirection) {
        return this.aTrapDoors.get(pDirection);
    }
    
    /**
 * Removes an exit in the specified direction.
 * 
 * @param pDirection The direction to remove.
 */
   
    public void removeDirection(final String pDirection) {
        this.aExits.remove(pDirection);
    }
    /**
 * Adds an item to the room.
 * 
 * @param pItem The item to add to the room.
 */
   
    public void addItem(final Item pItem) {
        this.aItems.addItem(pItem);
    }
    /**
 * Retrieves an item from the room based on its name.
 * 
 * @param pItemName The name of the item to retrieve.
 * @return The item if it exists in the room; otherwise, null.
 */
    public Item getItem(final String pItemName) {
        return this.aItems.getItem(pItemName);
    }
    /**
 * Removes an item from the room based on its name.
 * 
 * @param pItemName The name of the item to remove.
 */
    
    public void removeItem(final String pItemName) {
        this.aItems.removeItem(pItemName);
    }
   
} // Room
