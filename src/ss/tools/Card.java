package ss.tools;

/**
 * Card class that create makes references using a number and symbol from a deck's card
 */
public class Card {

    // -- Instance variables

    private String num;
    private Face symbol;
    private int value;

    // -- Constructor

    /**
     * Creates a card Object with its character and symbol
     * @param num is its character that can go from 2-10 and J,Q,K,A
     * @param symbols use a card symbol such as hearts, clubs, spades, clubs
     */
    public Card(String num, Face symbols){
        this.num = num;
        this.symbol = symbols;
        // checking if the card has a value
        this.value = calValue(num);

    }

    /**
     * Functions that takes the character of the card and assign a value
     * @param num is a character that can go from 2 to 10 and A,J,Q,K
     * @return the value of the card (0 if the card is not numerical )
     */
    public int calValue(String num){
        boolean isNum = isNumber(num);
        if(isNum){
            int n = Integer.parseInt(num);
            if (n >1 || n<10){
                return n;
            }else{
                return 0;
            }
        }else{
            if(num.equals("A")){
                return 1;
            }else { return 0;}
        }

    }

    /**
     * method that return true if the string is a number
     * @param num is a string that which will be checked
     * @return true if the string is number
     */
    public boolean isNumber(String num){

        try{
            int value = Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    // -- Getters for this class

    /**
     * Getter of the number
     * @return the number of the card
     */
    public String getNum(){ return this.num;}

    /**
     * getter of the Value
     * @return the value of the card as integer
     */
    public int getValue(){return  this.value;}

    /**
     * getter of the face of the card
     * @return the symbol of the card
     * It can be use for more games on different cases.(a possible improvement of the game)
     */
    public Face getSymbol(){return this.symbol;}

}
