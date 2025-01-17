package src.pkg_models;
import src.pkg_items.Beamer;
import src.pkg_rooms.Room;
import src.pkg_items.ItemList;
import src.pkg_items.Item;
import java.util.Stack;
/**
 * Represents a player in the game.
 *
 * @author Pierre MATAR
 
 */
public class Player
{
    private Stack<Room> aItinerary;
    private Room aCurrentRoom;
    private String aName;
    private ItemList aItems;
    private int aWeight;
    private int aNbMoves;
    private Beamer aBeamer;
    private final int NB_MAX_MOVES = 25;
    
    
      /**
     * Constructs a new Player with the given name.
     * Initializes the player's items list, weight, and number of moves.
     * 
     * @param pName The name of the player.
     */
    public Player(final String pName) {
        this.aName = pName;
        this.aItems = new ItemList();
        this.aWeight = 300;
        this.aNbMoves = 0;
        this.aItinerary = new Stack<Room>();
    }
       /**
     * Sets the current room the player is in.
     * 
     * @param pRoom The room to set as the current room.
     */
    
    public void setCurrentRoom(final Room pRoom) {
        this.aCurrentRoom = pRoom;
    }
      /**
     * Returns the current room the player is in.
     * 
     * @return The current room.
     */
    public Room getCurrentRoom() {
        return this.aCurrentRoom;
    }
    
    /**
     * @return The maximum number of moves.
     */
    public int getMaxMoves() {
        return this.NB_MAX_MOVES;
    }
    /**
    
     * @return The name of the player.
     */
    public String getName() {
        return this.aName;
    }

    
    /**
     * @return The weight of the player.
     */
    public int getPlayerWeight() {
        return this.aWeight;
    }
    
    /**
     * Sets the player's weight by adding the given weight.
     * 
     * @param pWeigth The weight to add to the player's current weight.
     */
    public void setPlayerWeight(final int pWeight) {
        this.aWeight += pWeight;
    }

       /**
     * Adds an item to the player's inventory.
     * 
     * @param pItem The item to add.
     */
    public void addItem(final Item pItem) {
        this.aItems.addItem(pItem);
    }
       /**
     * Returns an item from the player's inventory by name.
     * 
     * @param pItemName The name of the item.
     * @return The item with the specified name.
     */
    public Item getItem(final String pItemName) {
        return this.aItems.getItem(pItemName);
    }
    
    
    /**
     * Removes an item from the player's inventory by name.
     * 
     * @param pItemName The name of the item to remove.
     */
    public void removeItem(final String pItemName) {
        this.aItems.removeItem(pItemName);
    }
    
    /**
     * Returns a list of all items in the player's inventory as a string.
     * 
     * @return The list of items in string format.
     */
    
    public String getMyItemsList() {
         return this.aItems.getAllItemString(this);
    }
     /**
     * Increases the player's number of moves by one.
     */
    
    public void addOneMove() {
        this.aNbMoves += 1;
    }
    
    /**
     * @return The number of moves.
     */
    
    public int getNbMoves() {
        return this.aNbMoves;
    }
     /**
     * @return The size of the itinerary.
     */
    public int getItinerarySize() {
        return this.aItinerary.size();
    }
    
      /**
     * Adds a room to the player's itinerary.
     * 
     * @param pRoom The room to add.
     */
    public void addRoom(final Room pRoom) {
        this.aItinerary.push(pRoom);
    }
        /**
     * Returns the room at the specified index in the player's itinerary.
     * 
     * @param pIndex The index of the room to retrieve.
     * @return The room at the specified index.
     */
    
    public Room getRoom(final int pIndex) {
        
        return this.aItinerary.get(pIndex);
    }
    
    /**
     * Removes the top room from the player's itinerary.
     */
    
    public void removeTopRoom() {
        this.aItinerary.pop();
    }
    
      /**
     * Returns the top room from the player's itinerary.
     * 
     * @return The top room.
     */
    public Room getTopRoom() {
        return this.aItinerary.peek();
    }
    
      /**
     * Clears the player's itinerary.
     */
    public void clearItinerary() {
        this.aItinerary.clear();
    }
    
    /**
     * @return The room of the beamer.
     */
    public Room getBeamerRoom() {
        return this.aBeamer.getRoom();
    }
    
    /**
     * Sets the room for the player's beamer.
     * 
     * @param pRoom The room to set for the beamer.
     */
    
    public void setBeamerRoom(final Room pRoom) {
        this.aBeamer.setRoom(pRoom);
    }
    
    /**
     * Sets the player's beamer.
     * 
     * @param pBeamer The beamer to set.
     */
    
    public void setBeamer(final Beamer pBeamer) {
        this.aBeamer = pBeamer;
    }
    
    /**
     * @return The player's beamer.
     */
    
    public Beamer getBeamer() {
        return this.aBeamer;
    }
    /**
     * @return true if the number of max moves is reached, false otherwise.
     */
    public boolean isNbMaxMovesReached() {
        return this.NB_MAX_MOVES == this.aNbMoves;
    }
}
