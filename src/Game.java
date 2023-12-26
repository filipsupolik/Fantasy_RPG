//Postavy hodnoty statov od 1 - 10;
// Paladin staty - name: Paladin, att: 3, hp: 7, defense: 10
// Ranger staty - name: Ranger, att: 6, hp: 3, defense: 5
// Warrior staty - name: Warrior, att: 8, hp: 5, def: 6

import java.util.Scanner;

public class Game {
    private Scanner sc;
    private Inventory inventory;
    private Room[][] hraciaPlocha;
    private Player player;

    public Game() {
        this.sc = new Scanner(System.in);
        this.player = new Player();
        this.hraciaPlocha = new Room[3][3];
        this.addRooms();
        System.out.println("Vitaj v hre! Vyber si postavu:");
        System.out.println("1. Warrior");
        System.out.println("2. Ranger");
        System.out.println("3. Paladin");
        System.out.print("Zadaj číslo postavy: ");
    }

    public void addRooms() {
        this.hraciaPlocha[0][0] = Room.ROOM0;
        this.hraciaPlocha[0][1] = Room.ROOM1;
        this.hraciaPlocha[0][2] = Room.ROOM2;
        this.hraciaPlocha[1][0] = Room.ROOM3;
        this.hraciaPlocha[1][1] = Room.ROOM4;
        this.hraciaPlocha[1][2] = Room.ROOM5;
        this.hraciaPlocha[2][0] = Room.ROOM6;
        this.hraciaPlocha[2][1] = Room.ROOM7;
        this.hraciaPlocha[2][2] = Room.ROOM8;
    }

    public String playerInput() {
        String input = this.sc.nextLine();
        return input;
    }

    public void gameLoop() {
        String command;
        do {
            command = this.playerInput();
            this.player.chooseCharacter(command);
        } while (player == null);

        while (true) {
            System.out.println("Zadaj príkaz pre postavu:" + player.getClassOfPlayer().toString());
            System.out.println("1. Vseobecny prikaz");
            System.out.println("2. Prikaz pre schopnost postavy");
            // Get player input for their action/command
            command = this.playerInput(); // Update the command variable
            switch (command) {
                case "1":
                    player.displayCommands();
                    command = this.playerInput();
                    break;
                case "2":
                    player.displaySpecialCommands();
                    command = this.playerInput();
                    break;
            }
            player.getClassOfPlayer().use(command);

            // Check the game over condition and end the loop if it's met
            if (gameOverCondition()) {
                System.out.println("Hra skončila. Ďakujeme za hranie!");
                break;
            }
        }
    }
    // Metóda pre kontrolu ukončenia hry
    private boolean gameOverCondition() {
        // Implementácia podľa logiky hry, ktorá určuje, kedy hra končí
        // Napríklad po dosiahnutí určitého stavu alebo podmienky
        return false; // Tu môže byť podmienka ukončenia hry
    }
}
