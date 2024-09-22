package v1;
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author Pierre MATAR
 */
public class Room
{
    private String aDescription;
    public Room aNorthExit;
    public Room aSouthExit;
    public Room aEastExit;
    public Room aWestExit;
    
    
    
    public Room(final String pDescription) {
        this.aDescription = pDescription;
    }
    
    public String getDescription() {
        return this.aDescription;
    }
    
    public void setExits(final Room pNorthExit, final Room pSouthExit, final Room pEastExit, final Room pWestExit){
        this.aNorthExit = pNorthExit;
        this.aSouthExit = pSouthExit;
        this.aEastExit = pEastExit;
        this.aWestExit = pWestExit;
    }
} // Room
