
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
    
    public Item(final String pDescription, final int pWeigth) {
        this.aDescription = pDescription;
        this.aWeigth = pWeigth;
    }
    
    public String getItemDescription() {
        return this.aDescription;
    }
    
    public int getItemWeigth() {
        return this.aWeigth;
    }
    
    public void setItem(final Room pRoom) {
        pRoom.setItem(this);
    }
    
    public String getItemString() {
        return this.aDescription + " " + this.aWeigth;
    }
}
