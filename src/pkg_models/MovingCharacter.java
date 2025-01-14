package src.pkg_models;
import src.pkg_rooms.Room;
import src.pkg_items.Item;

/**
 * MovingCharacter class represents a character that can move between rooms.
 * It extends the Character class and provides functionality to change the room of the character.
 * 
 * @author Pierre MATAR
 */
public class MovingCharacter extends Characterr
{
    private Room aRoom;
    
    /**
     * Constructs a MovingCharacter with the specified name, text to say, response, item, and room.
     *
     * @param pName the name of the character
     * @param pTextToSay the text the character will say
     * @param pResponse the response of the character
     * @param pItem the item associated with the character
     * @param pRoom the room where the character is initially located
     */
    
    public MovingCharacter(final String pName, final String pTextToSay, final String pResponse, final Item pItem, final Room pRoom) {
        super(pName, pTextToSay, pResponse, pItem);
        this.aRoom = pRoom;
    }

     /**
     * Sets the room of the character.
     *
     * @param pRoom the room to set
     */
    
    public void setRoom(final Room pRoom) {
        this.aRoom = pRoom;
    }
    
    /**
     * Moves the character.
     * 
     * @param pRoom the room to move the character to
     */
    
    public void move(final Room pRoom) {
        this.aRoom.removeCharacter(this);
        this.setRoom(pRoom);
        this.aRoom.addCharacter(this);
    }
}
