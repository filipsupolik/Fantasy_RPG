public enum Room {
    ROOM1(0,1 , new Item("Flame Sword", "Ostry meč s oceľovým rezom a horiacim plameňom na ostrí.", ItemType.WEAPON), new EnemyAssasin("Shadowblade", 10, 15, 5)),
    ROOM2(0,2, null, new EnemyGoblin("Snarlgut", 6,8,2)),
    ROOM0(0,0, null, null),
    ROOM3(1,0, new Item("Healing Elixir", " Malá fľaštička obsahujúca liečivý elixír. Požitím obnovuje zdravie a poskytuje určitú ochranu počas boja.", ItemType.POTION), null),
    ROOM4(1,1, new Item(" Shadow Cloak", "Čierny plášť so špeciálnou látkou, ktorá poskytuje schopnosť zliezť do tieňov a stať sa takmer neviditeľným. Pridava obranu o 2.", ItemType.ARMOR), null),
    ROOM5(1,2 , null, null),
    ROOM6(2,0, null, new EnemyWarrior("Ironclad", 8,12,6)),
    ROOM7(2,1, new Item("Poisoned Arrows", "Šípy pokryté jedovatým roztokom, ktoré môžu spôsobiť dodatočné poškodenie nepriateľovi po zasiahnutí.", ItemType.WEAPON), null),
    ROOM8(2,2, null,null);
    private int x;
    private int y;
    private Item item;
    private Enemy enemyType;

    Room(int x, int y, Item item, Enemy enemyType) {
        this.x = x;
        this.y = y;
        this.item = item;
        this.enemyType = enemyType;
    }
}
