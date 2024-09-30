 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *     
 * @author Pierre MATAR
 */
public class Room
{
    
    private String aDescription;
    private Room aNorthExit;
    private Room aSouthExit;
    private Room aEastExit;
    private Room aWestExit;
    
       
    
    public Room(final String pDescription) {
        this.aDescription = pDescription;
    }
    
    public String getDescription() {
        return this.aDescription;
    }
    public Room getNorthExit() {
        return this.aNorthExit;
    }
    public Room getSouthExit() {
        return this.aSouthExit;
    }

    public Room getEastExit() {
        return this.aEastExit;
    }
    public Room getWestExit() {
        return this.aWestExit;
    }
    public Room getExit(String pDirection) {
        if (pDirection.equals("North"))
            return this.aNorthExit;
        if (pDirection.equals("South"))
            return this.aSouthExit;
        if (pDirection.equals("East"))
            return this.aEastExit;
        if (pDirection.equals("West"))
            return this.aWestExit;
            
        return null;
        
        
    }

     
    public void setExits(final Room pNorthExit, final Room pSouthExit, final Room pEastExit, final Room pWestExit){
        this.aNorthExit = pNorthExit;
        this.aSouthExit = pSouthExit;
        this.aEastExit = pEastExit;
        this.aWestExit = pWestExit;
    }
} // Room
