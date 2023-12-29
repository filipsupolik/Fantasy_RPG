import java.util.ArrayList;

public abstract class ClassOfPlayer {
    private String name;
    private int attack;
    private int hitpoints;
    private int defense;

    private Commands commands;

    public ClassOfPlayer(String name, int attack, int hitpoints, int defense) {
        this.name = name;
        this.attack = attack;
        this.hitpoints = hitpoints;
        this.defense = defense;
        this.commands = new Commands();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack += attack;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints += hitpoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void useItem(Item item) {
        if (item != null) {
            switch (item.getItemType()) {
                case WEAPON:
                    this.setAttack(3);
                    System.out.println("Použil si zbraň: " + item.getName());
                    break;
                case ARMOR:
                    this.setDefense(3);
                    System.out.println("Použil si brnenie: " + item.getName());
                    break;
                case POTION:
                    this.setHitpoints(2);
                    System.out.println("Použil si lektvar: " + item.getName());
                    break;
                default:
                    // Ak ide o iný typ itemu, môžeš sem pridať ďalšie case pre rôzne typy
                    System.out.println("Nepodporovaný typ itemu.");
                    break;
            }
        } else {
            System.out.println("Item neexistuje v inventári.");
        }
    }


    @Override
    public String toString() {
        return this.name;
    }

    public abstract void use(String specialCommand);
}
