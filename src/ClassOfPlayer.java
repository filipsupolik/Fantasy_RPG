import java.util.ArrayList;

public abstract class ClassOfPlayer {
    private String name;
    private int attack;
    private int hitpoints;
    private int defense;
    // ArrayList with commands unique for every class of player
    // If player write command pomoc_special, open list of special commands
    private Commands specialCommands;
    // List with common commands
    // Using command pomoc, opens commands saved in comonList
    private Commands commands;

    public ClassOfPlayer(String name, int attack, int hitpoints, int defense) {
        this.name = name;
        this.attack = attack;
        this.hitpoints = hitpoints;
        this.defense = defense;
        this.specialCommands = new Commands();
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
        this.attack = attack;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void createSpecialCommands(String specialCommand) {
        this.specialCommands.add(specialCommand);
    }

    public abstract void use();
}
