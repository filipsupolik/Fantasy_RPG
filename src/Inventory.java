import java.util.ArrayList;
/**
 * The Inventory class manages the items that the player collects during the game.
 * It allows adding, deleting, displaying, and retrieving items from the inventory.
 * @author Filip Šupolík
 * @version 1.0
 */

public class Inventory {
    private ArrayList<Item> items;

    /**
     * Constructs an Inventory object initializing the list of items.
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the inventory.
     *
     * @param item The item to be added to the inventory
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Deletes an item from the inventory.
     *
     * @param item The item to be removed from the inventory
     */
    public void deleteItem(Item item) {
        this.items.remove(item);
    }

    /**
     * Displays the list of items in the inventory.
     */
    public void showInventory() {
        for (Item item: this.items) {
            System.out.println(item.getName());
        }
    }

    /**
     * Retrieves an item from the inventory based on its name.
     *
     * @param itemName The name of the item to be retrieved
     * @return The item if found in the inventory, otherwise returns null
     */
    public Item getItemFromInventory(String itemName) {
        for (Item item : this.items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Ak sa item nenájde, vráti null
    }
}

