
/**
 * This class represents a special type of room in the game, known as a transporter room.
 * A transporter room can randomly teleport the player to another room in the game.
 * It extends the basic functionality of a Room and adds teleportation capabilities.
 * 
 * @author Pierre MATAR
 */
public class TransporterRoom extends Room
{
    private boolean aIsTransporterRoom;
    private GameEngine aGameEngine;
    private Room aTransporterRoom;
    private RoomRandomizer aRoomRandomizer;
    
    
     /**
     * Constructor to initialize a transporter room with specific properties.
     * 
     * @param pName The name of the room.
     * @param pDescription A description of the room.
     * @param pImage The image representing the room.
     * @param pIsTransporterRoom A flag indicating if the room is a transporter room.
     * @param pGameEngine The game engine for managing room and game state.
     */
    
    public TransporterRoom(final String pName, final String pDescription, final String pImage, final boolean pIsTransporterRoom, final GameEngine pGameEngine) {
        super(pName,pDescription, pImage);
        this.aIsTransporterRoom = pIsTransporterRoom;
        this.aGameEngine = pGameEngine;
        this.aTransporterRoom = this;
    }
    
    /**
     * Constructor to initialize a transporter room without specifying transporter functionality.
     * This constructor defaults the transporter room flag to false and passes null for the game engine.
     * 
     * @param pName The name of the room.
     * @param pDescription A description of the room.
     * @param pImage The image representing the room.
     */
    
    public TransporterRoom(final String pName, final String pDescription, final String pImage) {
        this(pName, pDescription, pImage, false, null);
    }
    
    /**
     * @return True if the room is a transporter room, false otherwise.
     */
    
    public boolean isATransporterRoom() {
        return this.aIsTransporterRoom;
    }
    
     /**
     * Returns the exit in the specified direction.
     * If the direction is valid, it calls the parent method to retrieve the exit.
     * Otherwise, it teleports the player to a random room.
     * 
     * @param pDirection The direction of the exit.
     * @return The room that the player can enter after moving in the specified direction or a random room.
     */
    
    @Override
    public Room getExit(final String pDirection) {
        if (pDirection != null) return super.getExit(pDirection);
        return this.findRandomRoom();
    }
    
     /**
     * Finds a random room in the game and returns it.
     * This method is used when the player attempts to move from a transporter room.
     * 
     * @return A randomly selected room from the available rooms in the game.
     */
    
    private Room findRandomRoom() {
        this.aRoomRandomizer = new RoomRandomizer(this.aGameEngine.getAleaRoom());
        return this.aRoomRandomizer.getRandomRoom(this.aGameEngine.getRooms(), this.aTransporterRoom);
    }
    
    
    
}
