/**
 * The Item class represents an item that can be collected and used within the game.
 * It contains information about the name and type of the item.
 * @author Filip Šupolík
 * @version 1.0
 */
public class Item {
    private String name;
    private ItemType itemType;

    /**
     * Constructs an Item object with a specified name and item type.
     *
     * @param name     The name of the item
     * @param itemType The type of the item (e.g., Weapon, Armor, Potion)
     */
    public Item(String name, ItemType itemType) {
        this.name = name;
        this.itemType = itemType;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name The name to be set for the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the type of the item.
     *
     * @return The type of the item (e.g., Weapon, Armor, Potion)
     */
    public ItemType getItemType() {
        return this.itemType;
    }

    /**
     * Sets the type of the item.
     *
     * @param itemType The type to be set for the item
     */
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    /**
     * Defines the action to be performed when using the item.
     * This method can be implemented to specify the behavior of using the item.
     */
    public void use() {

    }
}

