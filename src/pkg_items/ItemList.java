package src.pkg_items;
import src.pkg_rooms.Room;
import src.pkg_models.Player;
import java.util.HashMap;
/**
 * Manages a collection of items. Allows adding, retrieving, and removing items.
 * Also provides a method to list items based on context.
 * 
 * @author Pierre MATAR
 */
public class ItemList
{
    private HashMap<String, Item> aItemList;
    
    /**
 * Constructs an ItemList with an empty HashMap of items.
 */
    public ItemList() {
        this.aItemList = new HashMap<String, Item>();
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
     * Displays different formats based on the context.
     * 
     * @param pO The context (Room or Player).
     * @return A string listing all items or a message if none.
     */
    public String getAllItemString(final Object pO) {
        StringBuilder vSb;
        int index = 0;
        if (pO instanceof Room) {
            if (this.aItemList.isEmpty()) return ".\nNo item here. ";
            vSb = new StringBuilder("\nItems available :");

        }
            
        else if (pO instanceof Player) {
            if (this.aItemList.isEmpty()) return "\nYou are not carrying any items.";
            vSb = new StringBuilder("\nYour items -> ");

        }
        else {
            if (this.aItemList.isEmpty()) return "\nYou can't eat...";
                vSb = new StringBuilder("\nYou can eat only these items : ");

        }
        
        
        for (String itemName : this.aItemList.keySet()) {
            vSb.append(itemName +" (" + this.getItem(itemName).getItemWeight() + ")").append(index == this.aItemList.size() - 1 ? "" : " / ");
            index++;
        }
     
        return vSb.toString();
    }
    
 
    
}
