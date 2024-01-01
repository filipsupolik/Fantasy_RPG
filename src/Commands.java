import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that provides all and available commands for user to use
 * It contains methods for checking correct input, adding new commands and to enable user input
 * @author Filip Šupolík
 * @version 1.0
 */
public class Commands {
    private ArrayList<String> allComands;
    private Scanner sc;

    /**
     * Initialize and creates list of commands
     * After creating Commands instance it enables user input for user
     */
    public Commands() {
        this.allComands = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.createCommandsList();
    }

    /**
     * Checks if the given command is valid from the available commands list.
     *
     * @param command the command to be checked
     * @return the validated command if it exists; empty string if not recognized
     */
    public String commandCheck(String command) {
        String chosenCommand = null;
        if (this.allComands.contains(command)) {
            chosenCommand = command;
        } else if (!this.allComands.contains(command)) {
            System.out.format("Prikaz %s nie je mozne rozpoznat. %n Prosim zadaj iny prikaz. \n", command);
            chosenCommand = "";
        }
        return chosenCommand;
    }

    /**
     * Adds a new command to the list of available commands.
     *
     * @param command the command to be added
     */
    public void addNewCommand(String command) {
        this.allComands.add(command);
    }

    /**
     * Retrieves the list of all available commands.
     *
     * @return ArrayList containing all available commands
     */
    public ArrayList<String> getAllComands() {
        return this.allComands;
    }

    /**
     * Initializes the list of available commands with predefined values.
     */
    public void createCommandsList() {
        this.addNewCommand("ukonci");
        this.addNewCommand("akcia");
        this.addNewCommand("pohyb");
        this.addNewCommand("vstup");
        this.addNewCommand("zvolit");
        this.addNewCommand("dalej");
        this.addNewCommand("prehľadaj");
        this.addNewCommand("bojuj");
        this.addNewCommand("použi");
        this.addNewCommand("hore");
        this.addNewCommand("dole");
        this.addNewCommand("vpravo");
        this.addNewCommand("vlavo");
        this.addNewCommand("Sword");
        this.addNewCommand("Potion");
        this.addNewCommand("Shield");
        this.addNewCommand("Bow");
        this.addNewCommand("Healing Potion");
    }

    /**
     * Checks and retrieves the user's choice for character selection.
     *
     * @return the user's choice for character selection as a string
     */
    public String charChooseCheck() {
        String input = this.sc.nextLine().trim().toLowerCase(); // Získanie vstupu a úprava (odstránenie prázdnych znakov, prevod na malé písmená)
        while (!(input.equals("1") || input.equals("2") || input.equals("3"))) {
            System.out.println("Nesprávny vstup. Zadaj '1 pre Warriora', '2 pre Rangera' alebo '3 pre Paladina'.");
            input = this.sc.nextLine().trim().toLowerCase(); // Nový vstup v prípade chybného vstupu
        }
        return input;
    }

    /**
     * Retrieves and returns the user input.
     *
     * @return the user input as a string
     */
    public String playerInput() {
        String input = this.sc.nextLine();
        return input;
    }
}
