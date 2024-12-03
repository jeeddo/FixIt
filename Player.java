
/**
 * Décrivez votre classe Player ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Player
{
    private Room aCurrentRoom;
    private String aName;
    
    
    public Player(final String pName) {
        this.aName = pName;
    }
    
    public void setCurrentRoom(final Room pRoom) {
        this.aCurrentRoom = pRoom;
    }
    public Room getCurrentRoom() {
        return this.aCurrentRoom;
    }
    public String getName() {
        return this.aName;
    }
    
    public void setName(final String pName) {
        this.aName = pName;
    }
}
