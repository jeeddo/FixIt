package pkg_rooms;

import java.util.Random;
import java.util.List;
/**
 * Randomizes room selection for the game.
 * Can return either a predetermined room or a randomly chosen room from a list.
 * 
 * @author Pierre MATAR
 */
public class RoomRandomizer
{
    
    private Room aAleaRoom;
    
    /**
     * RoomRandomizer constructor.
     * @param pAleaRoom The fixed room to return if specified, or null for random selection.
     */
    public RoomRandomizer(final Room pAleaRoom) {
        this.aAleaRoom = pAleaRoom;
    }
    
     /**
     * Returns a random room from a list of available rooms.
     * Ensures that the transporter room is not selected.
     * 
     * @param pRooms            The list of possible rooms in the game.
     * @param pTransporterRoom  The room to exclude from selection.
     * @return A randomly selected room or the fixed room if specified.
     */
    public Room getRandomRoom(final List<Room> pRooms, final Room pTransporterRoom) {
        Random vRandom = new Random();
        if (this.aAleaRoom == null) {
            Room vRandomRoom = pRooms.get(vRandom.nextInt(pRooms.size()));
            while (vRandomRoom == pTransporterRoom) vRandomRoom = pRooms.get(vRandom.nextInt(pRooms.size()));
            return vRandomRoom;
        }
        return this.aAleaRoom;
    }
}
