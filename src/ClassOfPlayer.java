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

    @Override
    public String toString() {
        return this.name;
    }

    public void useCommand(String command) {
        switch (command) {
            case "vstup":
                System.out.println("Hrac vstupuje do miestnosti");
                break;
            case "pomoc":
                System.out.println("Prikazy ktore sa daju pouzit: " + this.commands.getAllComands());
                break;
            case "otvor inventar":
                System.out.println("Predmety v tvojom inventari: ");
                break;
            default:
                System.out.println("Zadany prikaz nie je spravny, zadaj iny prikaz: ");
                this.useCommand(command);
        }
    }

    public abstract void use(String specialCommand);
}
