import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Room {
    private Item item;
    private ClassOfPlayer enemy;
    private Room nextRoom;

    public Room() {
        this.item = null;
        this.enemy = null;
        this.nextRoom = null;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setEnemy(ClassOfPlayer enemy) {
        this.enemy = enemy;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public void enterRoom() {
        // Implementácia vstupu hráča do miestnosti
        // Logika miestnosti, zobrazenie itemu, boj s nepriateľom a prechod do ďalšej miestnosti
    }

    public static Room loadRoomFromMap(String roomInfo) {
        Room room = new Room();

        String[] parts = roomInfo.split(":");
        String itemNameOrEnemy = parts.length > 1 ? parts[1] : null;

        if (itemNameOrEnemy != null) {
            if (itemNameOrEnemy.startsWith("Item")) {
                Item item = new Item(itemNameOrEnemy);
                room.setItem(item);
            } else if (itemNameOrEnemy.startsWith("Enemy")) {
                ClassOfPlayer enemy = new Enemy(itemNameOrEnemy, 2,3,4);
                room.setEnemy(enemy);
            }
        }
        return room;
    }

    public static void loadMap(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Room room = this.loadRoomFromMap(line);
                // Tu môžeš pokračovať so spracovaním načítanej miestnosti
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
