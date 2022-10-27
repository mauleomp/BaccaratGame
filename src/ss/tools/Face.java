package ss.tools;

/**
 * Enum that represents the symbols of a French deck's cards.
 */
public enum Face {

    // --- Instance Variables

    H, D, S, C;

    // --- Queries

    public String toString(){
        if(this.equals(H)){
            return "Hearts";
        }else if(this.equals(D)){
            return "Diamonds";
        }else if(this.equals(S)){
            return "Spades";
        }else{
            return "Clubs";
        }
    }
}
