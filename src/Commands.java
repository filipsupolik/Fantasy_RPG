import java.util.ArrayList;

/**
 * Trieda Commands pre pracu so vseobecnymi prikazmi
 */
public class Commands {
    private ArrayList<String> allComands;

    public Commands() {
        this.allComands = new ArrayList<>();
        this.createCommandsList();
    }

    public String chooseCommand(String command) {
        String chosenCommand = null;
            if (this.allComands.contains(command)) {
                chosenCommand = command;
            } else if (!this.allComands.contains(command)){
                System.out.format("Command %s is not available.%n Try call another available command", command);
                chosenCommand = "";
            }
        return chosenCommand;
    }

    public void addNewCommand(String command) {
        this.allComands.add(command);
    }

    public void createCommandsList() {
        addNewCommand("vstup");
        addNewCommand("pomoc");
        addNewCommand("pomoc_special");
        addNewCommand("otvor inventar");
    }

    public ArrayList<String> getAllComands() {
        return this.allComands;
    }
}
