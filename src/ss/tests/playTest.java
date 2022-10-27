package ss.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.Game;
import ss.players.HumanPlayer;
import ss.players.Player;
import ss.tools.*;

import java.util.List;
public class playTest {

    private Player testPlayer;
    private Game testGame;
    private Shoe shoe;

    @BeforeEach
    public void setUp(){
        testPlayer = new HumanPlayer("Test");
        testGame = new Game(testPlayer, 8);
        shoe = new Shoe(8);
    }

    /**
     * Test the points that the player should obtain after giving a hand
     */
    @Test
    public void testPlayer(){
        Card card1 = new Card("5",Face.H);
        Card card2 = new Card("4",Face.H);
        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        assertEquals(9, testPlayer.getScore());
        testPlayer.cleanHand();
        card1 = new Card("A",Face.H);
        card2 = new Card("9",Face.H);
        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        assertEquals(0, testPlayer.getScore());

    }

    /**
     * Testing the rules of pulling a third card
     */
    @Test
    public void testRules(){
        Card card1 = new Card("4",Face.H);
        Card card2 = new Card("4",Face.D);
        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        //the player should not be allowed to pull a card if thw have 8 or 9 points
        assertFalse(testPlayer.canPull(testGame.getShoe()));
        testPlayer.cleanHand();
        card1 = new Card("6",Face.H);
        card2 = new Card("4",Face.D);
        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        //the player should be allowed to pull a card if they have less than 7 points
        assertTrue(testPlayer.canPull(testGame.getShoe()));
        Card card3 = new Card("K",Face.D);
        //adding a third card to the player's hand
        testPlayer.addCard(card3);
        //The user should not be allowed to have more than 3 cards.
        assertFalse(testPlayer.canPull(testGame.getShoe()));
    }

    @Test
    public void testWinner(){
        Card card1 = new Card("4",Face.H);
        Card card2 = new Card("4",Face.D);
        for (Player p: testGame.getPlayers()){

            p.addCard(card1);
            p.addCard(card2);
        }
        //Test if there is a tie
        assertFalse(testGame.existWinner(testGame.getPlayers()));
        for (Player p: testGame.getPlayers()){
            p.cleanHand();
            p.resetScore();
        }

        card1 = new Card("4",Face.H);
        card2 = new Card("4",Face.D);
        testGame.getPlayers()[0].addCard(card1);
        testGame.getPlayers()[0].addCard(card2);

        card1 = new Card("4",Face.H);
        card2 = new Card("5",Face.D);
        testGame.getPlayers()[1].addCard(card1);
        testGame.getPlayers()[1].addCard(card2);
        //Test if the game recognizes a winner
        assertTrue(testGame.existWinner(testGame.getPlayers()));
        //Check in the "BANKER" is the winner
        Player[] players = testGame.getPlayers();
        assertEquals("BANKER",testGame.getWinner(players));

    }

}
