public class Paladin extends ClassOfPlayer {
    public Paladin(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

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

    // Pridanie božskej sily k útoku, čo zvacsi att o 3
    public void useDivineSmite() {
        this.setAttack(3);
    }

    // Schopnosť liečiť seba dotykom, prenesením liečivé energie.
    // Ked bude Enemy done, zmenit tak aby sa pocitalo kolko zivota si ma pridat
    public void useLayOnHands() {
        int aktualneZivoty = this.getHitpoints();
        if (aktualneZivoty > 0 && aktualneZivoty < 7) {
            this.setHitpoints(4);
        } else if (aktualneZivoty < 0 || aktualneZivoty == 7) {
            System.out.println("Nemozes doplnit zivoty");
        }
    }

    // Aktivácia ochranného pole okolo seba, čo zvyšuje odolnosť voči zraneniam.
    public void useAuraOfProtection() {
        this.setDefense(5);
    }

    // Po obdržaní poškodenia sa paladin môže brániť spätným útokom s dodatočným bonusom poškodenia počas svojho ďalšieho ťahu.
    public void useRighteousRetribution(int receivedDamage) {
        int bonusDamage = calculateBonusDamage(receivedDamage); // Výpočet bonusového poškodenia

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

    private int calculateBonusDamage(int receivedDamage) {
        // Implementácia výpočtu bonusového poškodenia na základe prijatého poškodenia
        // Tu môžeš implementovať logiku, ako sa vypočíta bonusové poškodenie
        // Napríklad, môžeš vytvoriť vzťah medzi prijatým poškodením a bonusovým poškodením
        // v závislosti od parametrov triedy Paladin alebo iných faktorov v hre
        return receivedDamage * 2; // Príklad výpočtu bonusového poškodenia (2-násobok prijatého poškodenia)
    }


}
