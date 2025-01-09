
/**
 * Décrivez votre classe BackCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BackCommand extends Command

{
    @Override
     public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        
        String vXTime = super.getSecondWord();
        if (pPlayer.getItinerarySize() == 1)
            pGameEngine.getGui().println("Back is no possible here...");
            
         
        else {
            if (pPlayer.getCurrentRoom().isExit(pPlayer.getRoom(pPlayer.getItinerarySize( ) - 2)) || ( (TransporterRoom) (pPlayer.getRoom(pPlayer.getItinerarySize() - 2))).isATransporterRoom()) {
                 if (vXTime == null) {
                pPlayer.removeTopRoom();
                pPlayer.setCurrentRoom( pPlayer.getTopRoom());
                 pGameEngine.printLocationInfo();
                return;
            }
            String[] vCommands = vXTime.trim().split(" ");
            for(int i = 0; i < vCommands.length; i++) {
                if (!vCommands[i].equals("back")) 
                {
                   pGameEngine.getGui().println("back what ?");
                   return;
                }
            }
        
            for (int i = 0; i < vCommands.length + 1; i++) {
                if (pPlayer.getItinerarySize() == 1) break;
                
                pPlayer.removeTopRoom();
            }
            
        
            pPlayer.setCurrentRoom( pPlayer.getTopRoom());
            pGameEngine.printLocationInfo();
                
            }
            else {
                pPlayer.clearItinerary();
                
                pPlayer.addRoom(pPlayer.getCurrentRoom());  
                
            }
        
           
           
        }
    }
}
