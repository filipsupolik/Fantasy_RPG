import java.util.ArrayList;
import java.util.Scanner;

/**
 * Trieda Commands pre pracu so vseobecnymi prikazmi
 */
public class Commands {
    private ArrayList<String> allComands;
    private Scanner sc;

    public Commands() {
        this.allComands = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.createCommandsList();
    }

    public String commandCheck(String command) {
        String chosenCommand = null;
            if (this.allComands.contains(command)) {
                chosenCommand = command;
            } else if (!this.allComands.contains(command)){
                System.out.format("Prikaz %s nie je mozne rozpoznat. %n Prosim zadaj iny prikaz. \n", command);
                chosenCommand = "";
            }
        return chosenCommand;
    }

    public void addNewCommand(String command) {
        this.allComands.add(command);
    }

    public ArrayList<String> getAllComands() {
        return this.allComands;
    }

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
    }

    public String charChooseCheck() {
        String input = this.sc.nextLine().trim().toLowerCase(); // Získanie vstupu a úprava (odstránenie prázdnych znakov, prevod na malé písmená)
        while (!(input.equals("1") || input.equals("2") || input.equals("3"))) {
            System.out.println("Nesprávny vstup. Zadaj '1 pre Warriora', '2 pre Rangera' alebo '3 pre Paladina'.");
            input = this.sc.nextLine().trim().toLowerCase(); // Nový vstup v prípade chybného vstupu
        }
        return input;
    }

    public String playerInput() {
        String input = this.sc.nextLine();
        return input;
    }
}
