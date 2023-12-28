public class Ranger extends ClassOfPlayer {
    // Konštruktor pre triedu Ranger
    public Ranger(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

    // Implementácia metódy use pre hráča typu Ranger
    @Override
    public void use(String command) {
        switch (command) {
            case "vstup":
                System.out.println("Zvol smer: vpravo, vlavo, hore, dole");
                break;
            case "pomoc":
                System.out.println("Prikazy ktore sa daju pouzit: " + this.getCommands());
                break;
            case "otvor inventar":
                System.out.println("Predmety v tvojom inventari: ");
                break;
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

    // Schopnosť Aimed Shot zvyšuje útok o 4
    public void aimedShot() {
        this.setAttack(4);
    }

    // Schopnosť Stealth zvyšuje obranu o 2
    public void stealth() {
        this.setDefense(2);
    }

    // Schopnosť Evasion dočasne zvyšuje obranu a útok
    public void evasion() {
        int currentDefense = this.getDefense();
        int currentAttack = this.getAttack();
        this.setDefense(currentDefense + 2);
        this.setAttack(currentAttack + 2);
    }

    // Schopnosť Explosive Trap spôsobí škodu nepriateľovi
    public void explosiveTrap() {
        // Implementácia spôsobenia škody nepriateľovi
        // Napríklad:
        // enemy.takeDamage(5); // Aplikácia škody nepriateľovi
        System.out.println("Explosive Trap spôsobilo škodu nepriateľovi!");
    }
}
