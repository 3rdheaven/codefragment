package poker;

import test.HaechiArray;

public class Main {
    //02:01:54:32
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = new Card();
        Card[] cards;

        deck.init();
        cards = deck.drawCards(5);
        System.out.println();
        System.out.println();

        cards[0].number = 3;
        cards[1].number = 3;
        cards[2].number = 3;
        cards[3].number = 4;
        cards[4].number = 5;

        /*cards[0].number = 14;
        cards[1].number = 13;
        cards[2].number = 12;
        cards[3].number = 11;
        cards[4].number = 10;
        cards[5].number = 6;
        cards[6].number = 7;

        cards[0].number = 9;
        cards[1].number = 2;
        cards[2].number = 3;
        cards[3].number = 3;
        cards[4].number = 4;
        cards[5].number = 5;
        cards[6].number = 6;

        cards[0].shape = 3;
        cards[1].shape = 3;
        cards[2].shape = 3;
        cards[3].shape = 1;
        cards[4].shape = 3;
        cards[5].shape = 1;
        cards[6].shape = 2;*/

        //System.out.println(deck.getResult(cards));

        for(int i = 0; i < cards.length; i++) {
            System.out.print(cards[i].getShape() + cards[i].getNumber() + " ");
        }
        System.out.println();



        /*HaechiArray array = deck.sameNumbers(cards, Deck.TRIPLE);

        for(int i=0; i<array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();*/
    }
}

