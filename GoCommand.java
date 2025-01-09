
/**
 * Décrivez votre classe GoCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GoCommand extends Command
{
    @Override
    public void execute(final Player pPlayer, final GameEngine pGameEngine) 
    {
        if ( ! super.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            pGameEngine.getGui().println( "Go where?" );
            return;
        }
        

        String vDirection = super.getSecondWord();
        
        // Try to leave current room.
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
