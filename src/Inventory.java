import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItem(Item item) {
        items.remove(item);
    }

    public void showInventory() {
        for (Item item: this.items) {
            System.out.println(item);
        }
    }
}
