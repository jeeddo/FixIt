
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author Pierre MATAR
 * @version 2
 */
public class Beamer
{
    private Room aRoom;
    
    public Beamer(final Room pRoom) {
        this.aRoom = pRoom;
    }
    
    public Room getRoom() {
        return this.aRoom;
    }
    
    public void setRoom(final Room pRoom) {
        this.aRoom = pRoom;
    }
}
