public class Warrior extends ClassOfPlayer {
    // Konštruktor pre triedu Warrior
    public Warrior(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

    // Implementácia metódy use pre bojovníka
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

    // Schopnosť Mighty Strike zvyšuje útok o 5
    public void mightyStrike() {
        this.setAttack(5);
    }

    // Schopnosť Shield Bash zvyšuje obranu o 3
    public void shieldBash() {
        this.setDefense(3);
    }

    // Schopnosť Defensive Stance zdvojnásobí obranu a zníži útok
    public void defensiveStance() {
        int currentDefense = this.getDefense();
        int currentAttack = this.getAttack();
        this.setDefense(currentDefense * 2);
        this.setAttack(currentAttack / 2);
    }

    // Schopnosť War Cry zvyšuje útok, ale zníži obranu
    public void warCry() {
        int currentAttack = this.getAttack();
        int currentDefense = this.getDefense();
        this.setAttack(currentAttack + 3);
        this.setDefense(currentDefense - 2);
    }
}