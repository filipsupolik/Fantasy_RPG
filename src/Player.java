public class Player {
    private ClassOfPlayer classOfPlayer;
    private Commands command;

    private int x;
    private int y;

    public Player() {
        this.command = new Commands();
        this.command.createCommandsList();
    }

    public ClassOfPlayer chooseCharacter(String command) {
        String character = "";
        String notInput = null;
        switch (command) {
            case "3":
                this.classOfPlayer = new Paladin("Paladin", 3, 7, 10);
                character = "Paladin";
                break;
            case "2":
                this.classOfPlayer = new Ranger("Ranger", 6, 3, 5);
                character = "Ranger";
                break;
            case "1":
                this.classOfPlayer = new Warrior("Warrior", 8, 5, 7);
                character = "Warrior";
                break;
            default:
                System.out.println("Nepoznam zvolenu postavu, zadaj platny vstup.");
                notInput = "";
        }
        if (notInput == "") {
            this.chooseCharacter(command);
        } else {
            System.out.format("Zvolil si postavu: %s \n", character);
            System.out.format("Tvoje staty na zaciatku hry su: Utok: %d, Zivoty: %d, Obrana: %d \n", this.classOfPlayer.getAttack(), this.classOfPlayer.getHitpoints(), this.classOfPlayer.getDefense());
        }
        return this.classOfPlayer;
    }

    // Metóda pre výpis príkazov, ktoré môže hráč použiť
    public void displaySpecialCommands() {
        switch (this.getClassOfPlayer().toString()) {
            case "Paladin":
                System.out.println("1. Divine Smite / Lay On Hands / Aura Of Protection / Righteous Retribution");
                break;
            case "Warrior":
                System.out.println("3. Mighty Strike / Shield Bash / Defensive Stance / War Cry");
                break;
            case "Ranger":
                System.out.println("2. Aimed Shot / Stealth / Evasion / Explosive Trap");
                // Ďalšie možné príkazy alebo možnosti interakcie so svetom hry
                System.out.print("Tvoj príkaz: ");
        }
    }

    public ClassOfPlayer getClassOfPlayer() {
        return classOfPlayer;
    }

    public void displayCommands() {
        System.out.println("Vseobecne prikazy " + this.command.getAllComands());
        // Ďalšie možné príkazy alebo možnosti interakcie so svetom hry
        System.out.print("Tvoj príkaz: ");
    }
}
