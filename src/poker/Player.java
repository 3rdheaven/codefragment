package poker;

import com.sun.org.apache.regexp.internal.RE;

public class Player{
    private String name;
    private Card[] cards;
    private Result result;

    public void setName(String name) {
        this.name = name;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public String  getCardsText() {
        String result = "";

        for(int i = 0; i < cards.length; i++) {
            result += cards[i] + " ";
        }

        return result;
    }
}
