/**
 * The Paladin class represents a character of the Paladin class in the game.
 * It extends the ClassOfPlayer abstract class and implements specific abilities of a Paladin.
 * @author Filip Šupolík
 * @version 1.0
 */
public class Paladin extends ClassOfPlayer {
    /**
     * Constructs a Paladin object with specified attributes.
     *
     * @param name     The name of the Paladin
     * @param attack   The attack power of the Paladin
     * @param hitpoints The hitpoints (health) of the Paladin
     * @param defense  The defense capability of the Paladin
     */
    public Paladin(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

    /**
     * Defines the usage of various abilities by the Paladin based on given commands.
     *
     * @param command The command representing the ability the Paladin wants to use
     */
    @Override
    public void use(String command) {
        switch (command) {
            case "otvor inventar":
                System.out.println("Predmety v tvojom inventari: ");
                break;
            case "Divine smite":
                this.useDivineSmite();
                System.out.println("Tvoj att sa uspesne zvacsil o 3.");
                break;
            case "Lay On Hands":
                this.useLayOnHands();
                System.out.println("Podarilo sa ti doplnit si zivoty.");
                break;
            case "Aura Of Protection":
                this.useAuraOfProtection();
                System.out.println("Tvoja obrana sa zvysila.");
                break;
            case "Righteous Retribution":
                this.useRighteousRetribution(3);
                break;
            default:
                System.out.println("Zadany prikaz nie je spravny, zadaj iny prikaz: ");
                break;
        }
    }

    /**
     * dmg = damage
     * Adds dmg by 3 to Paladin dmg
     */
    public void useDivineSmite() {
        this.setAttack(3);
    }

    /**
     * Ability for healing missing health
     */
    // Ked bude Enemy done, zmenit tak aby sa pocitalo kolko zivota si ma pridat
    public void useLayOnHands() {
        int aktualneZivoty = this.getHitpoints();
        if (aktualneZivoty > 0 && aktualneZivoty < 7) {
            this.setHitpoints(4);
        } else if (aktualneZivoty < 0 || aktualneZivoty == 7) {
            System.out.println("Nemozes doplnit zivoty");
        }
    }

    /**
     * Player increase his defense to take less dmg
     */
    public void useAuraOfProtection() {
        this.setDefense(5);
    }

    /**
     * After receiving dmg, he takes some dmg as bonus dmg to his abilities
     * @param receivedDamage
     */
    public void useRighteousRetribution(int receivedDamage) {
        int bonusDamage = this.calculateBonusDamage(receivedDamage); // Výpočet bonusového poškodenia

        // Implementácia spravodlivej odplaty
        if (bonusDamage > 0) {
            // Aplikovanie bonusového poškodenia na nepriateľa alebo akcie na základe toho
            // Napríklad:
            // enemy.takeDamage(bonusDamage); // Aplikácia bonusového poškodenia na nepriateľa
            // Alebo ak iné akcie podľa logiky hry
            System.out.println("Spravodlivá odplata! Bonusové poškodenie: " + bonusDamage);
        } else {
            System.out.println("Žiadne bonusové poškodenie v spravodlivej odplate.");
        }
    }

    /**
     * Calculation for bonus dmg
     * @param receivedDamage
     * @return
     */
    private int calculateBonusDamage(int receivedDamage) {
        // Implementácia výpočtu bonusového poškodenia na základe prijatého poškodenia
        // Tu môžeš implementovať logiku, ako sa vypočíta bonusové poškodenie
        // Napríklad, môžeš vytvoriť vzťah medzi prijatým poškodením a bonusovým poškodením
        // v závislosti od parametrov triedy Paladin alebo iných faktorov v hre
        return receivedDamage * 2; // Príklad výpočtu bonusového poškodenia (2-násobok prijatého poškodenia)
    }


}
