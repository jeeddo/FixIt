package src.pkg_items;
import src.pkg_rooms.Room;

/**
 * Beamer class represents an item that is associated with a room.
 * It extends the Item class.
 * 
 * @author Pierre MATAR
 */
public class Beamer extends Item
{
    private Room aRoom;
    
    
     /**
     * Constructs a Beamer with the specified name, description, and weight.
     *
     * @param pName the name of the beamer
     * @param pDescription the description of the beamer
     * @param pWeight the weight of the beamer
     */
    
    public Beamer(final String pName, final String pDescription, final int pWeight) {
        super(pName, pDescription, pWeight);
    }
    
     /**
     * @return the room of the beamer
     */
    
    public Room getRoom() {
        return this.aRoom;
    }
    
      /**
     * Sets the room of the beamer.
     *
     * @param pRoom the room to set
     */
    
    public void setRoom(final Room pRoom) {
        this.aRoom = pRoom;
    }
    
    public boolean isBeamerCharged() {
        return this.aRoom != null;
    }
}
