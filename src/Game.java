//Postavy hodnoty statov od 1 - 10;
// Paladin staty - name: Paladin, att: 3, hp: 7, defense: 10
// Ranger staty - name: Ranger, att: 6, hp: 3, defense: 5
// Warrior staty - name: Warrior, att: 8, hp: 5, def: 6

import java.util.Scanner;

public class Game {
    private boolean firstEntry;
    private Scanner sc;
    private Inventory inventory;
    private Room[][] hraciaPlocha;
    private Player player;

    public Game() {
        this.firstEntry = true;
        this.sc = new Scanner(System.in);
        this.player = new Player();
        this.hraciaPlocha = new Room[3][3];
        this.addRooms();
    }

    public void addRooms() {
        this.hraciaPlocha[0][0] = Room.ROOM_00;
        this.hraciaPlocha[0][1] = Room.ROOM_01;
        this.hraciaPlocha[0][2] = Room.ROOM_02;
        this.hraciaPlocha[1][0] = Room.ROOM_10;
        this.hraciaPlocha[1][1] = Room.ROOM_11;
        this.hraciaPlocha[1][2] = Room.ROOM_12;
        this.hraciaPlocha[2][0] = Room.ROOM_20;
        this.hraciaPlocha[2][1] = Room.ROOM_21;
        this.hraciaPlocha[2][2] = Room.ROOM_22;
    }

    public String playerInput() {
        String input = this.sc.nextLine();
        return input;
    }

    public void gameLoop() {
        String command;
        System.out.println("Vitaj v hre! Vyber si postavu:");
        System.out.println("1. Warrior");
        System.out.println("2. Ranger");
        System.out.println("3. Paladin");
        System.out.print("Zadaj číslo postavy: ");
        do {
            command = this.playerInput();
            this.player.chooseCharacter(command);
        } while (player == null);

        System.out.println("Si pripravený začať svoju misiu. Napíš 'vstup' pre pohyb.");
        boolean continueGame = true;
        while (continueGame) {
            command = this.playerInput();

            if (command.equals("vstup")) {
                if (firstEntry) {
                    getCurrentRoomInfo();
                    firstEntry = false;
                }
            } else {
                System.out.println("Zvol dalsi krok:");
                System.out.println("Tvoj krok moze byt: akcia, pohyb");
                command = this.playerInput();
                switch (command) {
                    case "akcia":
                        System.out.println("Zvol aku akciu chces vykonat:");
                        System.out.println("prehľadaj, bojuj, použi");
                        command = this.playerInput();
                        if (command.equals("prehľadaj")) {
                            this.player.performAction(command);
                            System.out.println("V miestnosti si nasiel item: " + this.hraciaPlocha[this.player.getX()][this.player.getY()].getItem());
                        } else if (command.equals("bojuj")) {
                            this.player.performAction(command);
                            System.out.println("V miestnosti sa nachadza nepriatel: " + this.hraciaPlocha[this.player.getX()][this.player.getY()].getEnemy() + ". Do utoku!");
                        }
                        break;
                    case "pohyb":
                        System.out.println("Zvolil si pohyb. Prosim zvol smer:");
                        System.out.println("hore, dole, vpravo, vlavo");
                        command = this.playerInput();
                        this.player.move(command);
                        this.getCurrentRoomInfo();
                        break;
                }
            }

        }
    }
    // Metóda pre kontrolu ukončenia hry
    private boolean gameOverCondition() {
        // Implementácia podľa logiky hry, ktorá určuje, kedy hra končí
        // Napríklad po dosiahnutí určitého stavu alebo podmienky
        return false; // Tu môže byť podmienka ukončenia hry
    }

    public void getCurrentRoomInfo() {
        Room currentRoom = hraciaPlocha[this.player.getX()][this.player.getY()]; // Získaj aktuálnu miestnosť z hracej plochy
        System.out.println("Nachádzaš sa v miestnosti: " + currentRoom.getName());
        System.out.println("Popis miestnosti: " + currentRoom.getItem() +", " + currentRoom.getEnemy());
        System.out.println("Akcie dostupné v tejto miestnosti: zvolit, dalej");
    }
}
