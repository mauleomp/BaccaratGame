package ss.players;

import ss.tools.Card;
import ss.tools.Shoe;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Abstract class of a player
 */
public abstract class Player {

    // -- Instance Variables

    private String name;
    private int score;
    private List<Card> hand;

    // -- Constructors;

    /**
     * Constructor that creates a player with a name and score
     * @param name
     */
    public Player(String name){
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    // -- Commands

    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setHand(List<Card> hand){

       this.hand = hand;

    }

    public void calculateScore(){
        this.score = giveScore();
    }

    public void cleanHand(){
        this.hand = new ArrayList<>();
    }

    public abstract void addCard(Card card);


    public void resetScore(){
        this.score = 0;
    }
    /**
     * method that takes a card from a shoe and add them to the hand
     * @param shoe
     */
    public abstract void pullCard(Shoe shoe);

    // -- Queries


    public int getScore() {
        this.calculateScore();
        return score;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand(){
        return this.hand;
    }

    /**
     * method that return the hand(sequence of cards) as a string
     * @return
     */
    public String handToString(){
        if(hand.size() == 0){
            return "NONE";
        }else{
            StringJoiner joiner = new StringJoiner(",");
            hand.forEach( card -> joiner.add(card.getNum()));
            return joiner.toString();
        }
    }

    /**
     * method that calculates the score of the player
     * if the number is bigger than 9 it will return its last digit
     * @return
     */
    public int giveScore(){
        int score = 0;
        for(int i = 0; i<this.hand.size(); i++){
            Card card = this.hand.get(i);
            score += card.getValue();
        }
        if (score >= 10) {
            score = score % 10;
        }
        return score;
    }

    /**
     * method that checks if the player is able to pull a card
     * @param shoe can take a card from a shoe from the game
     * @return a boolean value
     */
    public abstract boolean canPull(Shoe shoe);

    /**
     * method that return true if the player should ask for a card following the rules of baccarat
     * @return a boolean value fal
     */
    public abstract boolean askCard();
}
