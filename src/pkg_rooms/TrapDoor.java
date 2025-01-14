package src.pkg_rooms;
import src.pkg_items.Item;

/**
 * Represents a trap door in the game that extends a Door.
 * A trap door can either be a regular door or a trap door that may trigger specific behavior.
 * @author Pierre MATAR
 */
public class TrapDoor extends Door
{
    private boolean aIsTrapDoor;
    
     /**
     * Constructs a TrapDoor with a specified lock status, key, and trap door status.
     * 
     * @param pIsLocked Indicates whether the door is locked.
     * @param pKeyDoor The key (item) required to open the door.
     * @param pIsTrapDoor Indicates if the door is a trap door.
     */
    public TrapDoor(final boolean pIsLocked, final Item pKeyDoor, final boolean pIsTrapDoor) {
        super(pIsLocked, pKeyDoor);
        this.aIsTrapDoor = pIsTrapDoor;
    }
    
    /**
     * @return true if the door is a trap door, false otherwise.
     */
    
    public boolean isTrapDoor() {
        return this.aIsTrapDoor;
    }
    
}
