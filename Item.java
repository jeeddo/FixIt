/**
 * Décrivez votre classe Item ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Item
{
    private String aDescription;
    private int aWeigth;
    private String aName;
    
    public Item(final String pName, final String pDescription, final int pWeigth) {
        this.aName = pName;
        this.aDescription = pDescription;
        this.aWeigth = pWeigth;
        
    }
    
    public String getItemDescription() {
        return this.aDescription;
    }
    
    public int getItemWeigth() {
        return this.aWeigth;
    }
    public String getName() {
        return this.aName;
    }
    
    public String getItemString() {
        return this.aName +" "+this.aDescription + " " + this.aWeigth;
    }
}
