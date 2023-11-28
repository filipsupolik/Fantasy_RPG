//Postavy hodnoty statov od 1 - 10;
// Paladin staty - name: Paladin, att: 3, hp: 7, defense: 10
// Ranger staty - name: Ranger, att: 6, hp: 3, defense: 5
// Warrior staty - name: Warrior, att: 8, hp: 5, def: 6

import java.util.Scanner;

public class Game {
    private ClassOfPlayer classOfPlayer;
    private Scanner sc;
    private Inventory inventory;
    private Room room;
    private Commands command;

    public Game() {
        this.sc = new Scanner(System.in);
        this.command = new Commands();
        this.command.createCommandsList();
    }

    public ClassOfPlayer chooseCharacter() {
        String character = this.playerInput();
        String notInput = null;
        switch (character) {
            case "Paladin":
                this.classOfPlayer = new Paladin("Paladin", 3, 7, 10);
                break;
            case "Ranger":
                this.classOfPlayer = new Ranger("Ranger", 6, 3, 5);
                break;
            case "Warrior":
                this.classOfPlayer = new Warrior("Warrior", 8, 5, 7);
                break;
            default:
                System.out.println("Nepoznam zvolenu postavu, zadaj platny vstup.");
                notInput = "";
        }
        if (notInput == "") {
            this.chooseCharacter();
        } else {
            System.out.format("Zvolil si postavu: %s \n", character);
            System.out.format("Tvoje staty na zaciatku hry su: Utok: %d, Zivoty: %d, Obrana: %d \n", this.classOfPlayer.getAttack(), this.classOfPlayer.getHitpoints(), this.classOfPlayer.getDefense());
        }
        return this.classOfPlayer;
    }

    public ClassOfPlayer getClassOfPlayer() {
        return classOfPlayer;
    }

    public String playerInput() {
        String input = this.sc.nextLine();
        return input;
    }
}
