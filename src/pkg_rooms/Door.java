package src.pkg_rooms;
import src.pkg_items.Item;

/**
 * The Door class represents a door in the game. A door can be locked or unlocked,
 * and it may require a key to open. The key is represented by an item that the player
 * needs to possess in order to unlock the door.
 * 
 * @author Pierre MATAR
 */
public class Door
{
    private boolean aIsLocked;
    private Item aKeyDoor;
    
    /**
     * Constructor to create a door with a specified locked state and key item.
     *
     * @param pIsLocked A boolean indicating if the door is locked (true) or unlocked (false).
     * @param pKeyDoor The item required to unlock the door.
     */
    
    public Door(final boolean pIsLocked, final Item pKeyDoor) {
        this.aIsLocked = pIsLocked;
        this.aKeyDoor = pKeyDoor;
    }
    
    /**
     * @return A boolean indicating if the door is locked (true) or unlocked (false).
     */
    public boolean isLocked() {
        return this.aIsLocked;
    }
    
    /**
     * @return The name of the key item needed to unlock the door.
    */
    
    public String getKeyItemName() {
        return this.aKeyDoor.getName();
    }
    
}
