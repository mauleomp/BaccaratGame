package ss.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    // -- Instance Variables

    private static  int NUM_CARDS = 52;
    private List<Card> cards;

    // -- Constructor

    /**
     * Constructor of the deck which contains the cards for the game
     */
    public Deck(){
        this.cards =createCards();
    }

    /**
     * method that creates cards according to the normal french rules
     * @return
     */
    public List<Card> createCards(){
        List<Card> c = new ArrayList<>();
        for (Face f : Face.values()){
            for (Court court : Court.values()){
                Card card = new Card(court.toString(), f);
                c.add(card);
            }
            for (int i = 2; i <= 10; i++){
                Card card = new Card(Integer.toString(i),f);
                c.add(card);
            }
        }
        return c;
    }

    /**
     * Method that shuffle this individual deck
     */
    public void shuffleDeck(){
        Collections.shuffle(this.cards, new Random());
    }

    // -- Getters

    /**
     * Getter of the cards
     * @return a list of cards that contains the deck
     */
    public List<Card> getCards(){return this.cards;}


}
