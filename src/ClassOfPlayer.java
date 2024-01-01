
/**
 * Abstract class representing a character in the game.
 * This class defines the basic attributes and functionalities for all characters in the game.
 * It provides methods to manipulate the character's attributes and use items.
 *
 * @author Filip Šupolík
 * @version 1.0
 */
public abstract class ClassOfPlayer {
    private String name;
    private int attack;
    private int hitpoints;
    private int defense;

    private Commands commands;

    /**
     * Creates a new instance of ClassOfPlayer with specified attributes.
     *
     * @param name      name of character
     * @param attack    attack power of character
     * @param hitpoints hitpoints or health of character
     * @param defense   defense power of character
     */
    public ClassOfPlayer(String name, int attack, int hitpoints, int defense) {
        this.name = name;
        this.attack = attack;
        this.hitpoints = hitpoints;
        this.defense = defense;
        this.commands = new Commands();
    }

    /**
     * Access method for character attribute name
     * @return name of character
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method for setting value of name attribute
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Access method for character attribute attack
     * @return how much damage it gives to enemy
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Method for setting value of attack attribute
     * @param attack
     */
    public void setAttack(int attack) {
        this.attack += attack;
    }

    /**
     * Access method for character attribute hitpoints
     * @return how much damage it can take from enemy
     */
    public int getHitpoints() {
        return this.hitpoints;
    }

    /**
     * Method for setting value of hitpoints attribute
     * @param hitpoints
     */
    public void setHitpoints(int hitpoints) {
        this.hitpoints += hitpoints;
    }

    /**
     * Access method for character attribute DEFENSE
     * @return how much damage it can reduce from enemy
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Method for setting value of defense attribute
     * @param defense
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Allows the player to use a specific item from their inventory.
     * Modifies the character's attributes based on the type of item used.
     *
     * @param item the item to be used by the character
     */
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

    /**
     * Abstract method that allows derived classes to define specific actions for the character.
     * Each derived class must implement this method according to the character's specific actions.
     *
     * @param specialCommand a special command or action for the character
     */
    public abstract void use(String specialCommand);

    /**
     * Returns a string representation of the character's name.
     *
     * @return the name of the character
     */
    @Override
    public String toString() {
        return this.name;
    }
}
