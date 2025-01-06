import java.util.Random;
import java.util.List;
/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author Pierre MATAR
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer
{
    
    private Room aAleaRoom;
    
    public RoomRandomizer(final Room pAleaRoom) {
        this.aAleaRoom = pAleaRoom;
    }
    
    public Room getRandomRoom(final List<Room> pRooms, final Room pTransporterRoom) {
        Random vRandom = new Random();
        if (this.aAleaRoom == null) {
            Room vRandomRoom = pRooms.get(vRandom.nextInt(pRooms.size()));
            while (vRandomRoom == pTransporterRoom) vRandomRoom = pRooms.get(vRandom.nextInt(pRooms.size()));
            return pRooms.get(vRandom.nextInt(pRooms.size()));
        }
        return this.aAleaRoom;
    }
}
