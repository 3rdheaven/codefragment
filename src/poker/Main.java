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

        /*p1.cards[0].number = 4;
        p1.cards[1].number = 14;
        p1.cards[2].number = 14;
        p1.cards[3].number = 4;
        p1.cards[4].number = 8;

        p1.cards[0].shape = 2;
        p1.cards[1].shape = 3;
        p1.cards[2].shape = 2;
        p1.cards[3].shape = 2;
        p1.cards[4].shape = 2;

        p2.cards[0].number = 4;
        p2.cards[1].number = 14;
        p2.cards[2].number = 4;
        p2.cards[3].number = 14;
        p2.cards[4].number = 7;

        p2.cards[0].shape = 1;
        p2.cards[1].shape = 1;
        p2.cards[2].shape = 1;
        p2.cards[3].shape = 1;
        p2.cards[4].shape = 3;*/

        //System.out.println(deck.getResult(cards));
        System.out.println(p1.getName() +  ": " + p1.getCardsText() + p1.getResult().text());
        System.out.println();
        System.out.println(p2.getName() +  ": " + p2.getCardsText() + p2.getResult().text());
        System.out.println();
        System.out.println("승자: " + p1.checkWinner(p2));
    }
}