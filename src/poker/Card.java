package poker;

public class Card {
    int shape;
    int number;
    boolean selected;
    boolean checked;

    public String getNumber() {
        if(number == 11) return "J";
        else if(number == 12) return "Q";
        else if(number == 13) return "K";
        else if(number == 14) return "A";
        
        return number + "";
    }

    public String getShape() {
        if (shape == 0) return "♠";
        else if (shape == 1) return "◇";
        else if (shape == 2) return "♡";
        else if (shape == 3) return "♣";

        return "";
    }
}