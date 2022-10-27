package ss.players;

import ss.tools.Card;
import ss.tools.Shoe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    // -- Constructor

    /**
     * constructor or the Human Player
     * @param name String name of the player
     */
    public HumanPlayer(String name){
        super(name);
    }

    /**
     * Add card to the hand of the player
     * @param card Card from a shoe
     */
    @Override
    public void addCard(Card card) {
        if(getHand().size()<3) getHand().add(card);
    }

    /**
     * method that takes a card from a shoe
     * @param shoe shoe used in the game
     */
    @Override
    public void pullCard(Shoe shoe) {
        this.addCard(shoe.takeCard());
    }

    /**
     * method tha return true if the player could ask for a third card
     * @param shoe can take a card from a shoe from the game
     * @return
     */
    @Override
    public boolean canPull(Shoe shoe) {
        if (getScore() > 7) return false;
        if(shoe.getShoe().size() >0){
            if (this.getHand().size()<3) return true;
            else return false;
        }
        return false;
    }

    /**
     * Method that asks the player if he wants a third card
     * @return true if the string contains "y"
     */
    public boolean askCard(){
        System.out.println("Do you want another card? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        return ans.contains("y");
    }
}
