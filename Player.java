import java.util.HashMap;
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
    private HashMap<String, Item> aItemList;
    
    
    public Player(final String pName) {
        this.aName = pName;
        this.aItemList = new HashMap<>();
        
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
    
    public void addItem(final Item pItem) {
        this.aItemList.put(pItem.getName(), pItem);
    }
    public Item getItem(final String pItemName) {
        return this.aItemList.get(pItemName);
    }
    
    public void removeItem(final String pItemName) {
        this.aItemList.remove(pItemName);
    }
    
    public String getAllItemString() {

        StringBuilder vSb = new StringBuilder("\nItems available :");
        
        for (String itemName : this.aItemList.keySet()) {
            vSb.append(itemName +" ");
        }

        return vSb.toString();
    }
}
