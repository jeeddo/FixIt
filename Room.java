import java.util.Collection;

 import java.util.HashMap;
 import java.util.Set;
 
/**
 * This class represents a room in the game with exits, items, characters, and doors / trapdoors.
 *    
 * @author Pierre MATAR
 */
public class Room
{
    private String aName;
    private String aDescription;
    private HashMap<String, Room> aExits; 
    private HashMap<String, Door> aDoors;
    private String aImageName;
    private ItemList aItems;
    private HashMap<String, Character> aCharacters;

       
    /**
     * Constructor for the room, initializes the description, exits, and items.
     * 
     * @param pName The name of the room.
     * @param pDescription A brief description of the room.
     * @param pImage The image name associated with the room.
     */
    public Room(final String pName,final String pDescription, final String pImage) {
        this.aName = pName;
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aDoors = new HashMap<String, Door>();
        this.aImageName = pImage;
        this.aItems = new ItemList();
        this.aCharacters = new HashMap<String, Character>();
    }//Room
    /**
     * @return A string representing the description of the room.
     */
    public String getDescription() {
        return this.aDescription;
    }//getDescription
    
    /**
     * @return The name of the room.
     */
    public String getName() {
        return this.aName;
    }
    /**
     * @param pDirection The direction of the exit (e.g., "north", "south").
     * @return The room in the specified direction, or null if there is no exit in that direction.
     */
    public Room getExit(String pDirection) {
        return this.aExits.get(pDirection);
        
    }//getExit
    
    /**
     * @return A string listing all exits (e.g., "Exits: north south west").
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
     * @return A string listing the names of all characters in the room, or an empty string if no characters are present.
     */
    public String getCharactersString() {
        if (!this.aCharacters.isEmpty()) {
               StringBuilder vSb = new StringBuilder(".\nHere live"+ (this.aCharacters.size() > 1 ? " : " : "s : "));
        for (String characterName : this.aCharacters.keySet()) {
            vSb.append(characterName).append(" ");
        }
        return vSb.toString();
        }
        return "";
    }
    
    /**
     * @return A detailed string description of the room.
     */
    public String getLongDescription() {
        
        return "You are " + this.aDescription + ".\n" + this.getExitString() + this.aItems.getAllItemString(this) + this.getCharactersString();
    }
    
 
    
/**
     * Sets an exit in a given direction, specifying whether it is a locked door or a trapdoor.
     * 
     * @param pDirection The direction of the exit.
     * @param pNeighbor The neighboring room in the specified direction.
     * @param pIsLocked True if the door is locked, otherwise false.
     * @param pKeyDoor The key item required to open the door, or null if not needed.
     * @param pIsTrapDoor True if the exit is a trapdoor, otherwise false.
*/
       public void setExit(final String pDirection, final Room pNeighbor, final boolean pIsLocked, final Item pKeyDoor, final boolean pIsTrapDoor) {
        this.aExits.put(pDirection, pNeighbor);
        this.aDoors.put(pDirection, new TrapDoor(pIsLocked, pKeyDoor, pIsTrapDoor));
    }
    
    
    
    /**
 * Sets an exit in a given direction without specifying trap door status.
 * By default, the exit is not a trap door.
 * 
 * @param pDirection The direction of the exit.
 * @param pNeighbor  The neighboring room in the specified direction.
 */
    
    public void setExit(final String pDirection, final Room pNeighbor) {
        this.setExit(pDirection, pNeighbor, false, null, false);
    }
    
/**
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
     * @return True if the specified room is an exit, otherwise false.
     */
    public boolean isExit(final Room pRoom) {
        return this.aExits.containsValue(pRoom);
    }
    
    
    /**
 * Checks if the exit in a specified direction is a trap door.
 * 
 * @param pDirection The direction to check.
 * @return True if the exit is a trap door; otherwise, false.
 */
     public boolean isTrapDoor(final String pDirection) {
        return ( (TrapDoor) this.aDoors.get(pDirection)).isTrapDoor();
    }
     /**
     * Checks if the exit in a specified direction is a locked door.
     * 
     * @param pDirection The direction to check.
     * @return True if the exit is a locked door, otherwise false.
     */
    
    public boolean isLockedDoor(final String pDirection) {
        return this.aDoors.get(pDirection).isLocked();
    }
    
     /**
     * @param pDirection The direction of the door.
     * @return The name of the key item required to open the door, or null if no key is required.
     */
    
    public String getDoorKeyItemName(final String pDirection) {
        return this.aDoors.get(pDirection).getKeyItemName();
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
    
    /**
     * Adds a character to the room.
     * 
     * @param pCharacter The character to add.
     */
    
    public void addCharacter(final Character pCharacter) {
        this.aCharacters.put(pCharacter.getName(), pCharacter);
    }
    
    /**
     * Removes a character from the room.
     * 
     * @param pCharacter The character to remove.
     */
    
    public void removeCharacter(final Character pCharacter) {
        this.aCharacters.remove(pCharacter.getName());
    }
    
     /**
     * Retrieves a character from the room by name.
     * 
     * @param pCharacterName The name of the character to retrieve.
     * @return The character if found, otherwise null.
     */
    public Character getCharacter(final String pCharacterName) {
        return this.aCharacters.get(pCharacterName);
    }
    
    /**
     * @return A collection of characters in the room.
     */
    
    public Collection<Character> getCharacters() {
        return this.aCharacters.values();
    }
   
} // Room
