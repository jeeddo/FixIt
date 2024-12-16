import java.util.HashMap;
/**
 * Décrivez votre classe ItemList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ItemList
{
    private HashMap<String, Item> aItemList;
    
    public ItemList() {
        this.aItemList = new HashMap<>();
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
