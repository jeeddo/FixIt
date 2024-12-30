
/**
 * Décrivez votre classe Door ici.
 *
 * @author Pierre MATAR
 * @version 2
 */
public class Door
{
    private boolean aIsLocked;
    private Item aKeyDoor;
    
    public Door(final boolean pIsLocked, final Item pKeyDoor) {
        this.aIsLocked = pIsLocked;
        this.aKeyDoor = pKeyDoor;
    }
    
    public boolean isLocked() {
        return this.aIsLocked;
    }
    public String getKeyItemName() {
        return this.aKeyDoor.getName();
    }
    
}
