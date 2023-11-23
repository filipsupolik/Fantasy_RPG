public class Ranger extends ClassOfPlayer {
    public Ranger(String name, int attack, int hitpoints, int defense) {
        super(name, attack, hitpoints, defense);
    }

    @Override
    public void use(String command) {
        switch (command) {
            case "Precise Shot":
                this.preciseShot();
                System.out.println("Tvoj att sa uspesne zvacsil o 3.");
                break;
            case "Stealthy Approach":
                this.stealthApproach();
                System.out.println("Podarilo sa ti doplnit si zivoty.");
                break;
            case "Trapping":
                this.trapping();
                System.out.println("Tvoja obrana sa zvysila.");
                break;
            case "Evasive Maneuvers":
                this.evasiveManeuvers();
                break;
        }
    }

    //Presný lukostrelecký útok zameraný na zraniteľné miesto na tele nepriateľa, čo môže spôsobiť dodatočné poškodenie alebo efekty.
    public void preciseShot() {
        this.setAttack(10);
    }

    // Schopnosť skrytia a pohybu bez výrazného zvukového stopy, čo umožňuje hliadkovi prichádzať k nepriateľom bez varovania.
    public void stealthApproach() {

    }

    // Položenie pasce, ktorá môže spôsobiť poškodenie alebo nejaký efekt nepriateľovi, keď sa dostane do blízkosti.
    public void trapping() {

    }

    // Rýchle pohyby a obratné manévre, ktoré umožňujú rangerovi vyhnúť sa určitým útokom, čím sa zvýši jeho šance na prežitie.
    public void evasiveManeuvers() {
        this.setDefense(3);
    }
}
