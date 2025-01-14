package pkg_items;

/**
 * Represents an item with a name, description, and weight.
 * Items are used by players in the game and have associated properties.
 * 
 * @author Pierre MATAR
 * @version 2
 */
public class Item
{
    private String aDescription;
    private int aWeight;
    private String aName;
    
      /**
     * Constructs a new Item with the given name, description, and weight.
     * 
     * @param pName The name of the item.
     * @param pDescription A description of the item.
     * @param pWeigth The weight of the item.
     */
    
    public Item(final String pName, final String pDescription, final int pWeight) {
        this.aName = pName;
        this.aDescription = pDescription;
        this.aWeight = pWeight;
        
    }
        
    /**
     * Returns the description of the item.
     * 
     * @return The item's description.
     */
    
    public String getItemDescription() {
        return this.aDescription;
    }
    
    /**
     * Returns the weight of the item.
     * 
     * @return The item's weight.
     */
    
    public int getItemWeight() {
        return this.aWeight;
    }
    
    /**
     * Returns the name of the item.
     * 
     * @return The item's name.
     */
    public String getName() {
        return this.aName;
    }
    
    /**
     * Returns a string representation of the item, including its name, description, and weight.
     * 
     * @return The item's details as a string.
     */
    
    public String getItemString() {
        return this.aName +" "+this.aDescription + " " + this.aWeight;
    }
}
