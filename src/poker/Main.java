package poker;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        ResultChecker resultChecker = new ResultChecker();
        Player p1 = new Player();
        Player p2 = new Player();

        p1.setName("임준형");
        p2.setName("권재관");

        deck.init();
        p1.setCards(deck.drawCards(5));
        p2.setCards(deck.drawCards(5));

        Card[] cards1 = p1.getCards();
        Card[] cards2 = p2.getCards();
        
        cards1[0].setNumber(14);
        cards1[1].setNumber(9);
        cards1[2].setNumber(9);
        cards1[3].setNumber(5);
        cards1[4].setNumber(5);

        cards1[0].setShape(2);
        cards1[1].setShape(1);
        cards1[2].setShape(2);
        cards1[3].setShape(2);
        cards1[4].setShape(2);

        cards2[0].setNumber(9);
        cards2[1].setNumber(9);
        cards2[2].setNumber(5);
        cards2[3].setNumber(5);
        cards2[4].setNumber(2);

        cards2[0].setShape(0);
        cards2[1].setShape(0);
        cards2[2].setShape(0);
        cards2[3].setShape(0);
        cards2[4].setShape(1);


        resultChecker.makeResult(p1);
        resultChecker.makeResult(p2);

        //System.out.println(deck.getResult(cards));
        System.out.println(p1.getName() +  ": " + p1.getCardsText() + p1.getResult().text());
        System.out.println();
        System.out.println(p2.getName() +  ": " + p2.getCardsText() + p2.getResult().text());
        System.out.println();
        System.out.println("승자: " + resultChecker.determineWinner(p1 ,p2).getName());
    }
}