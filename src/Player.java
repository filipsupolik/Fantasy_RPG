public class Player {
    private ClassOfPlayer classOfPlayer;
    private Commands command;

    private int x;
    private int y;

    public Player() {
        this.command = new Commands();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Commands getCommandInstance() {
        return command;
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
    public boolean move(String direction) {
        int newX = this.x;
        int newY = this.y;
        switch (direction) {
            case "vpravo":
                this.y++;
                System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                return true;
            case "vlavo":
                this.y--;
                System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                return true;
            case "hore":
                this.x--;
                System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                return true;
            case "dole":
                this.x++;
                System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                return true;
            default:
                System.out.println("Neplatný smer pohybu.");
                break;
        }
        if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
            this.x = newX;
            this.y = newY;
            System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
            return true;
        } else {
            System.out.println("Nemozes ist tade, je to mimo priestoru.");
            return false;
        }
    }


}
