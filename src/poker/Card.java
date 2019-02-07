package poker;

public class Card {
    public int shape;
    public int number;
    public boolean selected;
    public boolean checked;

    public static String getNumber(int number) {
        if(number == 11) return "J";
        else if(number == 12) return "Q";
        else if(number == 13) return "K";
        else if(number == 14) return "A";

        return number + "";
    }

    public String getNumber() {
        if(number == 11) return "J";
        else if(number == 12) return "Q";
        else if(number == 13) return "K";
        else if(number == 14) return "A";

        return number + "";
    }

    public String getShape() {
        if (shape == 0) return "♤";
        else if (shape == 1) return "◇";
        else if (shape == 2) return "♡";
        else if (shape == 3) return "♣";

        return "";
    }

    public String toString() {
        return getShape() + getNumber();
    }
}