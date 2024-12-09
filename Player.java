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
    private ItemList aItems;
    
    
    public Player(final String pName) {
        this.aName = pName;
        this.aItems = new ItemList();
        
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
        this.aItems.addItem(pItem);
    }
    public Item getItem(final String pItemName) {
        return this.aItems.getItem(pItemName);
    }
    
    public void removeItem(final String pItemName) {
        this.aItems.removeItem(pItemName);
    }
    
    public String getMyItemsList() {
         return this.aItems.getAllItemString(this);
    }
    
    

}
