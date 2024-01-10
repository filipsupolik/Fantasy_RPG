/**
 * Class representing all Enemies in the game.
 * This class defines functionalities for all enemies in the game.
 * It provides methods to manipulate the enemie's behaviour
 * Class inherits attributes and methods from ClassOfPlayer class
 * @author Filip Šupolík
 * @version 1.0
 */
public class Enemy extends ClassOfPlayer {
    public Enemy(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

    /**
     * Implementácia abstraktnej metódy použitia pre nepriateľa.
     *
     * @param command Príkaz, ktorý má byť vykonaný
     */
    @Override
    public void use(String command) {

    }

    /**
     * Metóda pre vykonanie útoku nepriateľa.
     *
     * Implementácia útoku pre konkrétnych nepriateľov bude obsahovať detaily útoku a jeho dôsledky.
     */
    public void attack() {

    }
}
