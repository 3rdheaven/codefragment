package poker;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player p1 = new Player();
        Player p2 = new Player();

        p1.setName("임준형");
        p2.setName("권재관");

        deck.init();
        p1.setCards(deck.drawCards(5));
        p2.setCards(deck.drawCards(5));

        //System.out.println(deck.getResult(cards));
        //System.out.println(p1.getName() +  ": " + p1.getCardsText() + p1.getResult().text());
        //System.out.println(p2.getName() +  ": " + p2.getCardsText() + p2.getResult().text());
        System.out.println();
    }
}

