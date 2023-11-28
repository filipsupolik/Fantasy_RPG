import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Zvol si postavu: \n");
        game.playerInput();
        ClassOfPlayer hrac = game.chooseCharacter();
        while (true) {
            System.out.println("Zvol dalsiu akciu");
            hrac.use(game.playerInput());
//            System.out.println(game.getClassOfPlayer());

        }
//        ClassOfPlayer player = new Paladin("Paladin", 3, 7, 10);
//        System.out.println( "Meno: " + player.getName() + ", " + "Hodnota utoku: " + player.getAttack());
//        player.use("Divine smite");
//        System.out.println( "Meno: " + player.getName() + " " + "Hodnota utoku: " + player.getAttack());
//        System.out.println( "Meno: " + player.getName() + ", " + "Hodnota zivotov: " + player.getHitpoints());
//        player.use("Lay On Hands");
//        System.out.println( "Meno: " + player.getName() + " " + "Hodnota zivotov: " + player.getHitpoints());
    }
}