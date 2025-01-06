import java.util.Random;
import java.util.List;
/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer
{
    public static Room getRandomRoom(final List<Room> pRooms, final Room pTransporterRoom) {
        Random vRandom = new Random();
        Room vRandomRoom = pRooms.get(vRandom.nextInt(pRooms.size()));
        while (vRandomRoom == pTransporterRoom) vRandomRoom = pRooms.get(vRandom.nextInt(pRooms.size()));
        return pRooms.get(vRandom.nextInt(pRooms.size()));
    }
}
