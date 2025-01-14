package src.pkg_commands;
        


/**
 * AleaCommand class represents a command that allows the player to set a random room (alea room) 
 * when the game is in test mode.
 * 
 * @author Pierre MATAR
 */
public class AleaCommand extends Command
{
    
     /**
     * Executes the AleaCommand, setting the alea room if the game is in test mode.
     * 
     * @param pPlayer The player who issued the command.
     * @param pGameEngine The game engine which contains the state of the game.
     * 
     */
    
    @Override
   public void execute(final Player pPlayer, final GameEngine pGameEngine) {
        String vSecondCommandWord = super.getSecondWord();
        if (!pGameEngine.isTestMode()) pGameEngine.getGui().println("You're not in test mode");
        else if (vSecondCommandWord != null) {
               for (Room room : pGameEngine.getRooms()) {
                       if (room.getName().equals(vSecondCommandWord)) {
                        pGameEngine.setAleaRoom(room);
                        pGameEngine.getGui().println("The alea room is on -> " + room.getName());
                        return;
                    }
        
               }
               pGameEngine.getGui().println("We don't provide this room : " + vSecondCommandWord);
        }
     
 
    }
}
