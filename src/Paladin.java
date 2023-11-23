public class Paladin extends ClassOfPlayer {
    public Paladin(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

    @Override
    public void use(String command) {
        switch (command) {
            case "Divine smite":
                this.divineSmite();
                System.out.println("Tvoj att sa uspesne zvacsil o 3.");
                break;
            case "Lay On Hands":
                this.layOnHands();
                System.out.println("Podarilo sa ti doplnit si zivoty.");
                break;
            case "Aura Of Protection":
                this.auraOfProtection();
                System.out.println("Tvoja obrana sa zvysila.");
                break;
            case "Righteous Retribution":
                this.righteousRetribution();
                break;
        }
    }

    // Pridanie božskej sily k útoku, čo zvacsi att o 3
    public void divineSmite() {
        this.setAttack(3);
    }

    // Schopnosť liečiť seba dotykom, prenesením liečivé energie.
    // Ked bude Enemy done, zmenit tak aby sa pocitalo kolko zivota si ma pridat
    public void layOnHands() {
        int aktualneZivoty = this.getHitpoints();
        if (aktualneZivoty > 0 && aktualneZivoty < 7) {
            this.setHitpoints(4);
        } else if (aktualneZivoty < 0 || aktualneZivoty == 7) {
            System.out.println("Nemozes doplnit zivoty");
        }
    }

    // Aktivácia ochranného pole okolo seba, čo zvyšuje odolnosť voči zraneniam.
    public void auraOfProtection() {
        this.setDefense(5);
    }

    // Po obdržaní poškodenia sa paladin môže brániť spätným útokom s dodatočným bonusom poškodenia počas svojho ďalšieho ťahu.
    public void righteousRetribution() {

    }


}
