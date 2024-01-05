
/**
 * Enum representing different rooms in the game world.
 * Each room has a name, coordinates, an item, and a potential enemy associated with it.
 *
 * @author FILIP Šupolík
 * @version 1.0
 */
public enum Room {

    ROOM_00("Vstupna miestnost", 0, 0, new Item("Sword", ItemType.WEAPON), new EnemyGoblin("Goblin", 10, 5, 4)),
    ROOM_01("Room01", 0, 1, new Item("Potion", ItemType.POTION), null),
    ROOM_02("Room02", 0, 2, null, new EnemyWarrior("Dragon", 50, 20, 10)),
    ROOM_10("Room03", 1, 0, null, null),
    ROOM_11("Room04", 1, 1, new Item("Shield", ItemType.ARMOR), null),
    ROOM_12("Room05", 1, 2, new Item("Bow", ItemType.WEAPON), null),
    ROOM_20("Room06", 2, 0, null, new Enemy("Zombie", 20, 10, 2)),
    ROOM_21("Room07", 2, 1, new Item("Healing Potion", ItemType.POTION), null),
    ROOM_22("Konecna miestnost", 2, 2, null, null);

    private final String name;
    private final int x;
    private final int y;
    private final Item item;
    private final Enemy enemy;

    /**
     * Constructor for each Room enum constant.
     * Initializes the name, coordinates, item, and enemy associated with the room.
     *
     * @param name  The name of the room.
     * @param x     The x-coordinate of the room.
     * @param y     The y-coordinate of the room.
     * @param item  The item present in the room (can be null if no item exists).
     * @param enemy The enemy present in the room (can be null if no enemy exists).
     */
    Room(String name, int x, int y, Item item, Enemy enemy) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.item = item;
        this.enemy = enemy;
    }

    /**
     * Retrieve the x-coordinate of the room.
     *
     * @return The x-coordinate of the room.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Retrieve the y-coordinate of the room.
     *
     * @return The y-coordinate of the room.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Retrieve the item present in the room.
     *
     * @return The item in the room (can be null if no item exists).
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * Retrieve the enemy present in the room.
     *
     * @return The enemy in the room (can be null if no enemy exists).
     */
    public Enemy getEnemy() {
        return this.enemy;
    }

    /**
     * Retrieve the name of the room.
     *
     * @return The name of the room.
     */
    public String getName() {
        return this.name;
    }
}
