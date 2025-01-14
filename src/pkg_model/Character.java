package pkg_model;


/**
 * Represents a character in the game.
 * 
 * @author Pierre MATAR
 */
public class Character
{
    private String aName;
    private String aTextToSay;
    private String aResponseText;
    private Item aItem;
    
    
     /**
     * Creates a new character with specified attributes.
     * 
     * @param pName          The character's name.
     * @param pTextToSay     The dialogue text the character says.
     * @param pResponseText  The character's response text.
     * @param pItem          The item associated with the character.
     */
    
    public Character(final String pName, final String pTextToSay, final String pResponseText, final Item pItem) {
        this.aName = pName;
        this.aTextToSay = pTextToSay;
        this.aResponseText = pResponseText;
        this.aItem = pItem;
    }
    
    
     /**
     * @return The character's text.
     */
    
    public String getTextToSay() {
        return this.aTextToSay;
    }
    
    /**
     * @return The character's name.
     */
    public String getName() {
        return this.aName;
    }
    
    /**
     * @return The response text.
     */
    
    public String getResponseText() {
        return this.aResponseText;
    }
    
    /**
     * @return The associated item.
     */
    
    public Item getItem() {
        return this.aItem;
    }
    
}
