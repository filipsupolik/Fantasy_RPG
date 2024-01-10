/**
 * The Ranger class represents a character of type Ranger in the game.
 * It inherits attributes and methods from the ClassOfPlayer abstract class.
 *
 * @author FILIP Šupolík
 * @version 1.0
 */
public class Ranger extends ClassOfPlayer {
    /**
     * Constructor for the Ranger class.
     * Initializes the Ranger character with specified attributes.
     *
     * @param name     The name of the Ranger character
     * @param attack   The attack points of the Ranger
     * @param hitpoints The hit points of the Ranger
     * @param defense  The defense points of the Ranger
     */
    public Ranger(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

    /**
     * Overrides the use method to define specific actions for the Ranger character based on the provided command.
     *
     * @param command The command representing the action the Ranger will perform
     */
    @Override
    public void use(String command) {
        switch (command) {
            case "Aimed Shot":
                this.aimedShot();
                System.out.println("Vykonaný Aimed Shot! Tvoj útok sa zvýšil o 4.");
                break;
            case "Stealth":
                this.stealth();
                System.out.println("Vykonané Stealth! Tvoja obrana sa zvýšila o 2.");
                break;
            case "Evasion":
                this.evasion();
                System.out.println("Vykonané Evasion! Tvoja obrana a útok sa dočasne zvýšili.");
                break;
            case "Explosive Trap":
                this.explosiveTrap();
                System.out.println("Vykonaná Explosive Trap! Spôsobil si škodu nepriateľovi.");
                break;
        }
    }

    /**
     * Increases the Ranger's attack by 4 when using the Aimed Shot ability.
     */
    public void aimedShot() {
        this.setAttack(4);
    }

    /**
     * Increases the Ranger's defense by 2 when using the Stealth ability.
     */
    public void stealth() {
        this.setDefense(2);
    }

    /**
     * Temporarily increases both the Ranger's defense and attack by 2 when using the Evasion ability.
     */
    public void evasion() {
        int currentDefense = this.getDefense();
        int currentAttack = this.getAttack();
        this.setDefense(currentDefense + 2);
        this.setAttack(currentAttack + 2);
    }

    /**
     * Executes the Explosive Trap ability, causing damage to the enemy.
     * Note: Implementation requires interaction with the 'enemy' object or its equivalent in the game.
     */
    public void explosiveTrap() {
        // Implementácia spôsobenia škody nepriateľovi
        // Napríklad:
        // enemy.takeDamage(5); // Aplikácia škody nepriateľovi
        System.out.println("Explosive Trap spôsobilo škodu nepriateľovi!");
    }
}
