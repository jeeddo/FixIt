
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author Pierre MATAR
 * @version 2
 */
public class Beamer extends Item
{
    private Room aRoom;
    
    public Beamer(final String pName, final String pDescription, final int pWeight) {
        super(pName, pDescription, pWeight);
    }
  
    public Room getRoom() {
        return this.aRoom;
    }
    
    public void setRoom(final Room pRoom) {
        this.aRoom = pRoom;
    }
}
