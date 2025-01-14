package src.pkg_commands;

import src.pkg_models.Player;
import src.pkg_game.GameEngine;
import src.pkg_rooms.Room;
import src.pkg_rooms.TransporterRoom;
/**
 * GoCommand class represents a command that allows the player to move to a different room
 * by specifying a direction (North, South, East, West, etc.).
 * 
 * @author Pierre MATAR
 */
public class GoCommand extends Command
{
    
    /**
     * Executes the GoCommand, allowing the player to move in a specified direction.
     * 
     * The method checks if a second word (direction) was provided, verifies if the player 
     * can move in the specified direction (considering locked doors, traps, etc.), and updates 
     * the player's current room accordingly.
     * 
     * If the current room is a transporter room, the player will be transported to a random room.
     * 
     * @param pPlayer The player who issued the command.
     * @param pGameEngine The game engine which contains the state.
     */
    
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) 
    {
        if ( ! super.hasSecondWord() ) {
            pGameEngine.getGui().println( "Go where?" );
            return;
        }
        

        String vDirection = super.getSecondWord();
        
        Room vPreviousRoom = pPlayer.getCurrentRoom();
        Room vNextRoom = vPreviousRoom.getExit( vDirection );

        
        if ( vNextRoom == null )
            pGameEngine.getGui().println( "There is no door!" );
        else {
            if (vPreviousRoom.isLockedDoor(vDirection) && pPlayer.getItem(vPreviousRoom.getDoorKeyItemName(vDirection)) == null) {
                    pGameEngine.getGui().println("You don't have the " + vPreviousRoom.getDoorKeyItemName(vDirection) + " to go to the " + vDirection);
                    return;
            }
            
            pPlayer.setCurrentRoom(vNextRoom);
            pPlayer.addRoom(vNextRoom);
            
            
            if (vPreviousRoom.isTrapDoor(vDirection)) {
                switch (vDirection) {
                    case "North": vNextRoom.removeDirection("South"); break;
                    case "South": vNextRoom.removeDirection("North"); break;
                    case "West" : vNextRoom.removeDirection("East"); break;
                    case "East": vNextRoom.removeDirection("West");
                }
            }
                if (( (TransporterRoom) vPreviousRoom).isATransporterRoom()) {
                pPlayer.removeTopRoom();
                Room vRandomRoom = vPreviousRoom.getExit(null);
                pPlayer.setCurrentRoom(vRandomRoom);
                pPlayer.addRoom(vRandomRoom);

            }
            pGameEngine.printLocationInfo();
        }
    }
}
