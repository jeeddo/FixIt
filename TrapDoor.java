
/**
 * Décrivez votre classe TrapDoor ici.
 *
 * @author Pierre MATAR
 * @version 2
 */
public class TrapDoor extends Door
{
    private boolean aIsTrapDoor;
    
    public TrapDoor(final boolean pIsLocked, final Item pKeyDoor, final boolean pIsTrapDoor) {
        super(pIsLocked, pKeyDoor);
        this.aIsTrapDoor = pIsTrapDoor;
    }
    
    public boolean isTrapDoor() {
        return this.aIsTrapDoor;
    }
    
}
