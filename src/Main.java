public class Main {
    public static void main(String[] args) {
        Commands commands = new Commands();
        System.out.println(commands.chooseCommand("napoveda"));
        System.out.println(commands.chooseCommand("pomoc"));
        System.out.println(commands.getAllComands());
    }
}