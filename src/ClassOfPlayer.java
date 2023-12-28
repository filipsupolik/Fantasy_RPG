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

    public ArrayList<String> getCommands() { return this.commands.getAllComands();}

    @Override
    public String toString() {
        return this.name;
    }

    public abstract void use(String specialCommand);
}
