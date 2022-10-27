package ss.tools;

/**
 * enum of the court of a deck
 */
public enum Court {
    A, J, Q, K;

    public String toString(){
        if(this.equals(A)){
            return "A";
        }else if(this.equals(J)){
            return "J";
        }else if(this.equals(Q)){
            return "Q";
        }else{
            return "K";
        }
    }
}
