
/**
 * Décrivez votre classe TransporterRoom ici.
 *
 * @author Pierre MATAR
 * @version (un numéro de version ou une date)
 */
public class TransporterRoom extends Room
{
    private boolean aIsTransporterRoom;
    private GameEngine aGameEngine;
    private Room aTransporterRoom;
    private RoomRandomizer aRoomRandomizer;
    
    
    public TransporterRoom(final String pName, final String pDescription, final String pImage, final boolean pIsTransporterRoom, final GameEngine pGameEngine) {
        super(pName,pDescription, pImage);
        this.aIsTransporterRoom = pIsTransporterRoom;
        this.aGameEngine = pGameEngine;
        this.aTransporterRoom = this;
    }
    
    public TransporterRoom(final String pName, final String pDescription, final String pImage) {
        this(pName, pDescription, pImage, false, null);
    }
    
    public boolean isATransporterRoom() {
        return this.aIsTransporterRoom;
    }
    
    @Override
    public Room getExit(final String pDirection) {
        if (pDirection != null) return super.getExit(pDirection);
        return this.findRandomRoom();
    }
    
    private Room findRandomRoom() {
        this.aRoomRandomizer = new RoomRandomizer(this.aGameEngine.getAleaRoom());
        return this.aRoomRandomizer.getRandomRoom(this.aGameEngine.getRooms(), this.aTransporterRoom);
    }
    
    
    
}
