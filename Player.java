import java.util.Stack;
/**
 * Décrivez votre classe Player ici.
 *
 * @author Pierre MATAR
 * @version 2
 */
public class Player
{
    private Stack<Room> aItinerary;
    private Room aCurrentRoom;
    private String aName;
    private ItemList aItems;
    private int aWeigth;
    private int aNbMoves;
    
    
      /**
     * Constructs a new Player with the given name.
     * Initializes the player's items list, weight, and number of moves.
     * 
     * @param pName The name of the player.
     */
    public Player(final String pName) {
        this.aName = pName;
        this.aItems = new ItemList();
        this.aWeigth = 300;
        this.aNbMoves = 0;
        this.aItinerary = new Stack<>();
        
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
     * Returns the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName() {
        return this.aName;
    }

    
    /**
     * Returns the player's weight.
     * 
     * @return The weight of the player.
     */
    public int getPlayerWeigth() {
        return this.aWeigth;
    }
        /**
     * Sets the player's weight by adding the given weight.
     * 
     * @param pWeigth The weight to add to the player's current weight.
     */
    public void setPlayerWeigth(final int pWeigth) {
        this.aWeigth += pWeigth;
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
     * Returns the number of moves the player has made.
     * 
     * @return The number of moves.
     */
    
    public int getNbMoves() {
        return this.aNbMoves;
    }
     /**
     * Returns the size of the player's itinerary.
     * 
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
    

}
