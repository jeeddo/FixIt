
/**
 * Décrivez votre classe MovingCharacter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MovingCharacter extends Character
{
    private Room aRoom;
    
    public MovingCharacter(final String pName, final String pTextToSay, final String pResponse, final Item pItem, final Room pRoom) {
        super(pName, pTextToSay, pResponse, pItem);
        this.aRoom = pRoom;
    }

    public void setRoom(final Room pRoom) {
        this.aRoom = pRoom;
    }
    
    public void move(final Room pRoom) {
        this.aRoom.removeCharacter(this);
        this.setRoom(pRoom);
        this.aRoom.addCharacter(this);
    }
}
