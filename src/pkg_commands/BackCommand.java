package src.pkg_commands;

import src.pkg_models.Player;
import src.pkg_game.GameEngine;
import src.pkg_rooms.TransporterRoom;
/**
 * Represents the command to move the player back to the previous room in their itinerary.
 * 
 * @author Pierre MATAR
 */
public class BackCommand extends Command

{
    /**
     * Executes the "back" command, moving the player to the previous room in their itinerary.
     * 
     * @param pPlayer The player who is executing the command.
     * @param pGameEngine The game engine.
     */
    
    @Override
     public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        
        String vXTime = super.getSecondWord();
        if (pPlayer.getItinerarySize() == 1) pGameEngine.getGui().println("Back is no possible here...");
         
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
                if (!vCommands[i].equals(CommandWord.BACK.getDescription())) 
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
