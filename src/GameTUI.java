import ss.Game;
import ss.players.HumanPlayer;
import ss.players.Player;

import java.util.Scanner;

public class GameTUI {

    public static void main(String args[]){
        System.out.println("+------------|  WELCOME  |------------+");
        System.out.println("+-----------      to       -----------+");
        System.out.println("+------------| BACCARAT  |------------+");
        System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
        boolean exit = false;
        while(!exit){
            System.out.println("\tMENU:");
            System.out.println("\t1. PLAY\n\t2. EXIT");
            System.out.println("Please type the number ");
            Scanner scanner = new Scanner(System.in);
            String menu = scanner.nextLine();
            switch (menu){
                case "1":
                    System.out.println("What is your name ? ");
                    String name = scanner.nextLine();
                    Player player = new HumanPlayer(name);
                    Game game = new Game(player, 8);
                    game.start();
                    break;
                case "2":
                    System.out.println("SEE YOU SOON");
                    exit = true;
                    break;
                default:
                    System.out.println("NOT RECOGNIZED");
            }
        }


    }
}
