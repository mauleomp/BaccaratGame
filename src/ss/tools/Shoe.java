package ss.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Class that create a Shoe of cards
 */
public class Shoe {

    // -- Instance Variables
    private List<Card> shoe;

    // -- Constructor
    public Shoe(int n_decks){
        this.shoe = createShoe(n_decks);
    }

    /**
     * Function that creates a shoe using a certain number of decks
     * @param n_decks
     * @return
     */
    public List<Card> createShoe(int n_decks){
        List<Card> shoe =new ArrayList<>();
        for (int i=0; i<n_decks; i++){
            Deck deck = new Deck();
            //deck.shuffleDeck();
            for(Card c: deck.getCards()){
                shoe.add(c);
            }
        }
        return shoe;
     }

    /**
     * method that shuffle the entire shoe of cards
     */
    public void shuffleShoe(){
        Collections.shuffle(this.shoe, new Random());
    }

    /**
     * function that take the first card of the shoe and remove it from the list
     * @return a Card from the list
     */
    public Card takeCard(){
        Card card = this.shoe.get(0);
        this.shoe.remove(0);
        return card;
    }

    /**
     * Getter that return a shoe
     * @return a list of cards of the shoe
     */
    public List<Card> getShoe() {
        return shoe;
    }
}
