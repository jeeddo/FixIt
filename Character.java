
/**
 * Décrivez votre classe Character ici.
 *
 * @author Pierre MATAR
 * @version (un numéro de version ou une date)
 */
public class Character
{
    private String aName;
    private String aTextToSay;
    private String aResponseText;
    private Item aItem;
    
    public Character(final String pName, final String pTextToSay, final String pResponseText, final Item pItem) {
        this.aName = pName;
        this.aTextToSay = pTextToSay;
        this.aResponseText = pResponseText;
        this.aItem = pItem;
    }
    
    public String getTextToSay() {
        return this.aTextToSay;
    }
    
    public String getName() {
        return this.aName;
    }
    public String getResponseText() {
        return this.aResponseText;
    }
    
    public Item getItem() {
        return this.aItem;
    }
    
}
