import java.util.HashMap;
/**
 * Décrivez votre classe ItemList ici.
 *
 * @author Pierre MATAR
 * @version 2
 */
public class ItemList
{
    private HashMap<String, Item> aItemList;
    
    /**
 * Constructs an ItemList with an empty collection of items.
 */
    public ItemList() {
        this.aItemList = new HashMap<>();
    }
    /**
 * Adds an item to the collection.
 * 
 * @param pItem The item to add to the collection.
 */
  
       public void addItem(final Item pItem) {
        this.aItemList.put(pItem.getName(), pItem);
    }
    /**
 * Retrieves an item from the collection by its name.
 * 
 * @param pItemName The name of the item to retrieve.
 * @return The item if found; otherwise, null.
 */
    public Item getItem(final String pItemName) {
        return this.aItemList.get(pItemName);
    }
    /**
 * Removes an item from the collection by its name.
 * 
 * @param pItemName The name of the item to remove.
 */
    
    public void removeItem(final String pItemName) {
        this.aItemList.remove(pItemName);
    }
    /**
 * Returns a string representation of all items in the collection.
 * The format of the string depends on whether the items belong to a room
 * or a player's inventory.
 * 
 * @param pO The object context (Room or other) to determine the string format.
 * @return A string listing all items and their weights, or a message if no items exist.
 */
    
    public String getAllItemString(final Object pO) {
        StringBuilder vSb;
        int index = 0;
        if (pO instanceof Room) {
            if (this.aItemList.isEmpty()) return ".\nNo item here. ";
            vSb = new StringBuilder("\nItems available :");

        }
            
        else {
            if (this.aItemList.isEmpty()) return "\nYou are not carrying any items.";
            vSb = new StringBuilder("Your items -> ");

        }
        
        
        for (String itemName : this.aItemList.keySet()) {
            vSb.append(itemName +" (" + this.getItem(itemName).getItemWeigth() + ")").append(index == this.aItemList.size() - 1 ? "" : " / ");
            index++;
        }
     
        return vSb.toString();
    }
    
 
    
}
