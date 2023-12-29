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

    Room(String name, int x, int y, Item item, Enemy enemy) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.item = item;
        this.enemy = enemy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Item getItem() {
        return this.item;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public String getName() {
        return name;
    }
}
