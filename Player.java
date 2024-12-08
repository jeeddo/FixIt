
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
    private Item aItem;
    
    
    public Player(final String pName) {
        this.aName = pName;
        System.out.println(this.aItem);
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
    
    public void setItem(final Item pItem) {
        this.aItem = pItem;
    }
    public Item getItem() {
        return this.aItem;
    }
}
