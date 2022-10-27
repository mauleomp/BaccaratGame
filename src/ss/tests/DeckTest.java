package ss.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.tools.*;

import java.util.List;

public class DeckTest {

    private Deck deck;
    private Shoe shoe;

    @BeforeEach
    public void setUp(){
        deck = new Deck();
        shoe = new Shoe(8);
    }

    /**
     * Test if the deck contain 52 cards
     */
    @Test
    public void DeckCards(){
        assertEquals(52, deck.getCards().size());
    }

    /**
     * Test if the deck contains 4 exact number of the same card number
     * Test if the deck contain 13 cards of diamonds
     */
    @Test
    public void DeckStructure(){
        List<Card> cards = deck.getCards();
        int four = 0;
        int kings = 0;
        int aces = 0;
        int diamond = 0;
        for(int i = 0; i<cards.size()-1; i++){
            Card card = cards.get(i);
            if (card.getNum().equals("4")) four++;
            if (card.getNum().equals("K")) kings++;
            if (card.getNum().equals("A")) aces++;
            if (card.getSymbol().equals(Face.D)) diamond++;
        }
        assertEquals(4, aces);
        assertEquals(4, four);
        assertEquals(4, kings);
        assertEquals(13, diamond);
    }

    /**
     * Test if the shoe contains 416 cards (8 decks)
     */
    @Test
    public void ShoeStructure(){
        assertEquals(416, shoe.getShoe().size());
    }

    /**
     * check that a card does not appear in the shoe after taking it
     */
    @Test
    public void TestShoe(){
        int size = shoe.getShoe().size();
        Card card = shoe.takeCard();
        assertEquals(size-1, shoe.getShoe().size());
        assertFalse(shoe.getShoe().contains(card));

    }
}
