
/**
 * The class represents the game engine, managing the game's flow.
 * It allows the player to interact with rooms, select a character, and perform various actions.
 * It encompasses the game loop and methods for managing the game flow.
 * @author Filip Šupolík
 * @version 1.0
 */
public class Game {
    private boolean firstEntry;
    private Inventory inventory;
    private Room[][] hraciaPlocha;
    private Player player;
    private boolean endOfGame;


    /**
     * Constructor creating an instance of the `Game` class.
     * Initializes necessary variables and the game environment.
     * Contains main loop for game
     */
    public Game() {
        this.firstEntry = true;
        this.player = new Player();
        this.hraciaPlocha = new Room[3][3];
        this.addRooms();
        this.endOfGame = false;
        this.inventory = new Inventory();
    }

    /**
     * Initializes the game rooms and adds them to the game space.
     */
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

    /**
     * Initiates the main game loop, where the player interacts with the game.
     * Allows character selection, movement, room interaction, and action execution.
     */
    public void gameLoop() {
        String command;
        System.out.println("Vitaj v hre! Vyber si postavu:");
        System.out.println("1. Warrior");
        System.out.println("2. Ranger");
        System.out.println("3. Paladin");
        System.out.print("Zadaj číslo postavy: ");
        do {
            command = this.player.getCommandInstance().charChooseCheck();
            this.player.chooseCharacter(command);
        } while (this.player == null);

        System.out.println("Si pripravený začať svoju misiu. Napíš 'vstup' pre pohyb.");
        boolean continueGame = true;
        while (continueGame) {
            command = this.player.getCommandInstance().playerInput();
            this.player.getCommandInstance().commandCheck(command);
            if (command.equals("vstup")) {
                if (this.firstEntry) {
                    this.getCurrentRoomInfo();
                    this.firstEntry = false;
                }
                if (!this.firstEntry) {
                    boolean continueAction = true;
                    while (continueAction) {
                        System.out.println("Zvol dalsi krok:");
                        System.out.println("Tvoj krok moze byt: akcia, pohyb");
                        command = this.player.getCommandInstance().playerInput();
                        this.player.getCommandInstance().commandCheck(command);
                        switch (command) {
                            case "akcia":
                                boolean actionCompleted;
                                System.out.println("Zvol aku akciu chces vykonat:");
                                System.out.println("prehľadaj, bojuj, použi, ukonci");
                                do {
                                    command = this.player.getCommandInstance().playerInput();
                                    this.player.getCommandInstance().commandCheck(command);
                                    actionCompleted = this.performActionInRoom(command); // Vykonanie akcie
                                    if (actionCompleted) {
                                        // Ďalšie pokyny pre hráča
                                        System.out.println("Teraz môžeš zadať ďalší príkaz: prehľadaj, bojuj, použi, ukonci");
                                    } else {
                                        // Spracovanie neúspešnej akcie
                                        System.out.println("Akcia bola ukoncena.");
                                    }
                                } while (actionCompleted); // Opakuje sa, pokiaľ hráč úspešne vykoná akciu
                                break;
                            case "pohyb":
                                boolean movementComplete;
                                do {
                                    System.out.println("Zvolil si pohyb. Prosim zvol smer:");
                                    System.out.println("hore, dole, vpravo, vlavo");
                                    command = this.player.getCommandInstance().playerInput();
                                    this.player.getCommandInstance().commandCheck(command);
                                    movementComplete = this.player.move(command);
                                    this.getCurrentRoomInfo();
                                } while (!movementComplete);
                                break;
                        }
                        if (this.hraciaPlocha[this.player.getX()][this.player.getY()].equals(Room.ROOM_22)) {
                            continueAction = false;
                            continueGame = false;
                            System.out.println("Dakujem za hranie mojej hry.");
                        }
                    }
                }
            }

        }
    }

    /**
     * Displays information about the current room where the player is located.
     */
    public void getCurrentRoomInfo() {
        Room currentRoom = this.hraciaPlocha[this.player.getX()][this.player.getY()]; // Získaj aktuálnu miestnosť z hracej plochy
        System.out.println("Nachádzaš sa v miestnosti: " + currentRoom.getName());
    }

    /**
     * Executes the chosen action in the room based on the given command.
     *
     * @param action The command to be executed in the room
     * @return True if the action was executed, otherwise False
     */
    public boolean performActionInRoom(String action) {
        Room room = this.hraciaPlocha[this.player.getX()][this.player.getY()];
        String command = "";
        switch (action) {
            case "prehľadaj":
                System.out.println("Prehľadávaš miestnosť.");
                if (room.getItem() == null) {
                    System.out.println("Miestnost je prazdna, nic si nenasiel.");
                } else {
                    Item item = room.getItem();
                    System.out.println("Nasiel si item: " + room.getItem().getName());
                    this.inventory.addItem(item);
                    System.out.println("Pridavam ho do inventara.");
                }
                return true; // Akcia sa vykonala
            case "bojuj":
                if (room.getEnemy() == null) {
                    System.out.println("Nemas s kym bojovat, si tu sam.");
                } else {
                    System.out.println("Nasiel si enemy: " + room.getEnemy().getName() + " Do utoku!");
                    this.player.displaySpecialCommands();
                    command = this.player.getCommandInstance().playerInput();

                }
                return true; //Akcia sa vykonala
            case "použi":
                System.out.println("Zobrazujem inventár:");
                this.inventory.showInventory(); // Zobraziť obsah inventára hráča
                System.out.println("Vyber item z inventára na použitie:");
                String selectedCommand = this.player.getCommandInstance().playerInput();
                this.player.getCommandInstance().commandCheck(selectedCommand);

                // Ak hráč zadal názov itemu, ktorý chce použiť
                Item selectedItem = this.inventory.getItemFromInventory(selectedCommand);
                if (selectedItem != null) {
                    // Tu môžeš implementovať logiku pre použitie vybraného itemu
                    System.out.println("Používaš item: " + selectedItem.getName());
                    this.player.getClassOfPlayer().useItem(selectedItem); // Logika pre použitie itemu hráčom
                } else {
                    System.out.println("Zadal si neplatný item.");
                }
                break;
            case "ukonci":
                return false;
            default:
                System.out.println("Neplatná akcia.");
                break;
        }
        return false; //Akcia nebola vykonana
    }
}
//Postavy hodnoty statov od 1 - 10;
// Paladin staty - name: Paladin, att: 3, hp: 7, defense: 10
// Ranger staty - name: Ranger, att: 6, hp: 3, defense: 5
// Warrior staty - name: Warrior, att: 8, hp: 5, def: 6
