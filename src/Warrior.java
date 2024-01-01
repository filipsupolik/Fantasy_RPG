/**
 * The Ranger class represents a character of type Ranger in the game.
 * It inherits attributes and methods from the ClassOfPlayer abstract class.
 *
 * @author FILIP Šupolík
 * @version 1.0
 */
public class Warrior extends ClassOfPlayer {
    /**
     * Constructor for the Warrior class.
     * Initializes the Warrior character with specified attributes.
     *
     * @param name     The name of the Ranger character
     * @param attack   The attack points of the Ranger
     * @param hitpoints The hit points of the Ranger
     * @param defense  The defense points of the Ranger
     */
    public Warrior(String name, int attack, int hitpoints, int defense) {
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
            case "Mighty Strike":
                this.mightyStrike();
                System.out.println("Vykonaný Mighty Strike! Tvoj útok sa zvýšil o 5.");
                break;
            case "Shield Bash":
                this.shieldBash();
                System.out.println("Vykonaný Shield Bash! Tvoja obrana sa zvýšila o 3.");
                break;
            case "Defensive Stance":
                this.defensiveStance();
                System.out.println("Vykonaný Defensive Stance! Tvoja obrana sa zdvojnásobila na úkor útoku.");
                break;
            case "War Cry":
                this.warCry();
                System.out.println("Vykonaný War Cry! Tvoj útok sa zvýšil, ale obrana sa znížila.");
                break;
        }
    }

    /**
     * Increases the Warrior's attack by 5 when using the Aimed Shot ability.
     */
    public void mightyStrike() {
        this.setAttack(5);
    }

    /**
     * Increases the Ranger's defense by 3 when using the Stealth ability.
     */
    public void shieldBash() {
        this.setDefense(3);
    }

    /**
     * Temporarily increases both the warrior's defense and attack by 2
     */
    public void defensiveStance() {
        int currentDefense = this.getDefense();
        int currentAttack = this.getAttack();
        this.setDefense(currentDefense * 2);
        this.setAttack(currentAttack / 2);
    }

    /**
     * Temporarily decrease the Warrior's defense by 2 but increase attack by 3 when using the War Cry ability.
     */
    public void warCry() {
        int currentAttack = this.getAttack();
        int currentDefense = this.getDefense();
        this.setAttack(currentAttack + 3);
        this.setDefense(currentDefense - 2);
    }
}