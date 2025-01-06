
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
    
    
    public TransporterRoom(final String pDescription, final String pImage, final boolean pIsTransporterRoom, final GameEngine pGameEngine) {
        super(pDescription, pImage);
        this.aIsTransporterRoom = pIsTransporterRoom;
        this.aGameEngine = pGameEngine;
        this.aTransporterRoom = this;
    }
    
    public TransporterRoom(final String pDescription, final String pImage) {
        this(pDescription, pImage, false, null);
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
        return RoomRandomizer.getRandomRoom(this.aGameEngine.getRooms(), this.aTransporterRoom);
    }
    
    
    
}
