package ss.players;

import ss.tools.Card;
import ss.tools.Shoe;

import java.util.Random;

public class Bank extends Player{

    //-- Constructor

    /**
     * constructor of the bank.
     */
    public Bank(){
        super("BANKER");
    }

    /**
     * method that add a card to the hand
     * @param card
     */
    @Override
    public void addCard(Card card) {
        if(getHand().size()<3){
            getHand().add(card);
        }
    }

    /**
     * method that takes a card from a shoe and add it to the hand
     * @param shoe
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
            if (this.getHand().size()<3) return thirdRule();
        }
        return false;
    }

    /**
     * bank would aways ask for a card after it checks if it can pull following the third rule
     * @return
     */
    @Override
    public boolean askCard() {
        return true;
    }

    /**
     * method that checks the third rule of a card depending on the hand of the player
     * @return true if the bank should ask for a diffetent card
     */
    public boolean thirdRule(){
        if(getScore() >=0 && getScore()<5){
            return true;
        }else if(getScore() == 5){
            Random random = new Random();
            return random.nextBoolean();
        }else return false;

    }
}
