
/**
 * The Player class represents the user's character in the game.
 * It handles character movement, character selection, and displays available commands.
 * @author Filip Šupolík
 * @version 1.0
 */
public class Player {
    private ClassOfPlayer classOfPlayer;
    private Commands command;

    private int x;
    private int y;

    /**
     * Constructs a Player object initializing necessary attributes.
     */
    public Player() {
        this.command = new Commands();
    }

    /**
     * Gets the x-coordinate of the player's position.
     *
     * @return The x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the x-coordinate of the player's position.
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the player's position.
     *
     * @return The y-coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x-coordinate of the player's position.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the instance of Commands class
     *
     * @return Commands instance
     */
    public Commands getCommandInstance() {
        return this.command;
    }

    /**
     * Chooses a character for the player based on the provided command.
     * Initializes the selected character's stats and displays initial stats.
     *
     * @param command The command representing the selected character
     * @return The selected ClassOfPlayer object
     */
    public ClassOfPlayer chooseCharacter(String command) {
        String character = "";
        String notInput = null;
        switch (command) {
            case "3":
                this.classOfPlayer = new Paladin("Paladin", 3, 7, 10);
                character = "Paladin";
                notInput = "correct";
                break;
            case "2":
                this.classOfPlayer = new Ranger("Ranger", 6, 3, 5);
                character = "Ranger";
                notInput = "correct";
                break;
            case "1":
                this.classOfPlayer = new Warrior("Warrior", 8, 5, 7);
                character = "Warrior";
                notInput = "correct";
                break;
            default:
                System.out.println("Nepoznam zvolenu postavu, zadaj platny vstup.");
                notInput = "";
        }
        if (notInput.equals("")) {
            this.chooseCharacter(command);
        } else {
            System.out.format("Zvolil si postavu: %s \n", character);
            System.out.format("Tvoje staty na zaciatku hry su: Utok: %d, Zivoty: %d, Obrana: %d \n", this.classOfPlayer.getAttack(), this.classOfPlayer.getHitpoints(), this.classOfPlayer.getDefense());
        }
        return this.classOfPlayer;
    }

    /**
     * Displays the special commands available to the player based on the chosen character.
     */
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
        }
        System.out.print("Tvoj príkaz: ");
    }

    /**
     * Gets character that player chooses at the start of game
     * @return
     */
    public ClassOfPlayer getClassOfPlayer() {
        return this.classOfPlayer;
    }
    /**
     * Moves the player in the specified direction within the game grid.
     * Checks if the movement is within the bounds of the game grid.
     *
     * @param direction The direction in which the player wants to move
     * @return True if the movement is successful, false otherwise
     */
    public boolean move(String direction) {
        int newX = this.x;
        int newY = this.y;
        switch (direction) {
            case "vpravo":
                if ((newX >= 0 && newX < 3) && (newY >= 0 && newY < 2)) {
                    this.x = newX;
                    this.y++;
                    System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                    return true;
                } else {
                    System.out.println("Nemozes ist tade, je to mimo priestoru.");
                    return false;
                }
            case "vlavo":
                if ((newX >= 0 && newX < 3) && (newY > 0 && newY <= 2)) {
                    this.x = newX;
                    this.y--;
                    System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                    return true;
                } else {
                    System.out.println("Nemozes ist tade, je to mimo priestoru.");
                    return false;
                }
            case "hore":
                if ((newX > 0 && newX < 3) && (newY >= 0 && newY < 2)) {
                    this.x--;
                    this.y = newY;
                    System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                    return true;
                } else {
                    System.out.println("Nemozes ist tade, je to mimo priestoru.");
                    return false;
                }
            case "dole":
                if ((newX >= 0 && newX < 2) && (newY >= 0 && newY < 2)) {
                    this.x++;
                    this.y = newY;
                    System.out.println("Nachadzas sa v miestnosti: " + this.x + " " + this.y);
                    return true;
                } else {
                    System.out.println("Nemozes ist tade, je to mimo priestoru.");
                    return false;
                }
            default:
                System.out.println("Neplatný smer pohybu.");
                break;
        }
        return true;
    }


}

