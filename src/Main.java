public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String command;
        ClassOfPlayer player;
        do {
            command = game.playerInput();
            player = game.chooseCharacter(command);
        } while (player == null);

        while (true) {
            System.out.println("Zadaj príkaz pre postavu:" + game.getClassOfPlayer().toString());
            System.out.println("1. Vseobecny prikaz");
            System.out.println("2. Prikaz pre schopnost postavy");
            // Get player input for their action/command
            command = game.playerInput(); // Update the command variable
            switch (command) {
                case "1":
                    game.displayCommands();
                    command = game.playerInput();
                    break;
                case "2":
                    game.displaySpecialCommands();
                    command = game.playerInput();
                    break;
            }
            player.use(command);

            // Check the game over condition and end the loop if it's met
            if (gameOverCondition()) {
                System.out.println("Hra skončila. Ďakujeme za hranie!");
                break;
            }
        }
    }
    // Metóda pre kontrolu ukončenia hry
    private static boolean gameOverCondition() {
        // Implementácia podľa logiky hry, ktorá určuje, kedy hra končí
        // Napríklad po dosiahnutí určitého stavu alebo podmienky
        return false; // Tu môže byť podmienka ukončenia hry
    }
}