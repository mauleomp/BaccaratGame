package ss;

import ss.players.Bank;
import ss.players.Player;
import ss.tools.Card;
import ss.tools.Shoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class of that created the Game
 */
public class Game {

    // -- Instance Variables

    private Shoe shoe;

    private Player[] players;

    private int idxWinner;

    // -- Constructors

    /**
     * Constructor of the game that takes a player and the number of decks for the shoe
     * @param p the human player
     * @param n number of decks that conforms the shoe
     */
    public Game(Player p, int n){
        this.shoe = new Shoe(n);
        players = new Player[2];
        Bank bank = new Bank();
        players[0] = p;
        players[1] = bank;
    }

    /**
     * function that reset the hand of the players and reset the score.
     */
    public void reset(){
        //this.shoe = new Shoe(8);
        for(Player p: players){
            p.cleanHand();
            p.resetScore();
        }
    }

    /**
     * function that start the game
     * it will play while the player wants to continue
     */
    public void start(){
        boolean continueGame = true;
        System.out.println(" > The new Game has started");
        //shuffle the shoe
        shoe.shuffleShoe();
        while (continueGame){
            //reset();
            play();
            System.out.println("\n Do you want to play another hand?");
            Scanner scanner = new Scanner(System.in);
            String ans = scanner.nextLine();
            continueGame = ans.contains("y");

        }
    }


    /***
     * function that follows the sequense of the game of a hand
     */
    public void play(){
        System.out.println();
        //shoe.shuffleShoe();
        //System.out.println(" -- The cards had been shuffled! --");
        boolean isGaming =  true;
        while(isGaming){
            giveHand(shoe);
            presentScore(players);
            if(isNotEnded(players)){
                for(Player p: players){
                    if(p.canPull(shoe)){
                        if(p.askCard()){
                            Card card = shoe.takeCard();
                            p.addCard(card);
                        }
                    }
                }
                presentScore(players);
            }
            isGaming = false;


        }
    }

    /**
     * method that takes 2 cards from a shoe and give it to each player
     * @param shoe that is being used in this game
     */
    public void giveHand( Shoe shoe){
        for(Player p: players){
            p.cleanHand();
            p.resetScore();
            List<Card> hand = new ArrayList<>();
            for (int i = 0 ; i<2; i++) {
                hand.add(shoe.takeCard());
            }
            p.setHand(hand);
        }
    }

    /**
     * method that returns the winner based on the scored
     * @param players a list of players in the game
     * @return a player name
     */
    public String getWinner(Player[] players){
        if(players[0].getScore()>players[1].getScore()) return players[0].getName();
        else return players[1].getName();
    }

    /**
     * mehtod that return true if the game has a winner based of the number of points
     * @param players a list of players of the game
     * @return a boolean value (true if there is a winner, false if it is a tie)
     */
    public boolean existWinner(Player[] players){
        if(players[0].getScore() != players[1].getScore()) return true;
        else return false;
    }

    /**
     * method that checks if the game has ended based of the rules
     * @param players a lis of players of the game
     * @return a boolean value
     */
    public boolean isNotEnded(Player[] players){
        //return false if any of the players has a score bigger than 7
        for (Player p: players) if (p.getScore() > 7) return false;
        //check if each player can pull a card
        for(Player p: players){
            if (p.canPull(shoe)) return true;

        }
        return false;
    }

    /**
     * function that shows the score and result of a hand
     * @param players
     */
    public void presentScore(Player[] players){
        String result = "";
        for (Player p : players){
            result+= p.handToString();
            result+= " | ";
        }
        if (existWinner(players)){
            result+= getWinner(players);
        }else result+= "TIE";
        System.out.println(result);
    }

    /**
     * Getter that return the shoe used in the game
     * @return  a shoe
     */
    public Shoe getShoe() {
        return shoe;
    }

    public Player[] getPlayers(){return players;}
}
