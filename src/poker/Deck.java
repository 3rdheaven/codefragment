package poker;

import test.HaechiArray;

public class Deck {
    public static final int PAIR = 0;
    public static final int TRIPLE = 1;
    public static final int FOUR_CARDS = 2;

    private Card[] cards = new Card[52];

    public void init() {
        int index = 0;
        for(int i = 0; i < cards.length; i++) cards[i] = new Card();

        for(int shape = 0; shape < 4; shape++) {
            for(int number = 2; number <= 14; number++) {
                cards[index].number = number;
                cards[index].shape = shape;

                index++;
            }
        }
    }

    //  카드를 나눠줌
    public Card[] drawCards(int count) {
        Card[] cards = new Card[count];

        for(int i = 0; i < cards.length; i++) {
            while(true) {
                cards[i] = randomCard();

                if(!cards[i].selected) {
                    cards[i].selected = true;
                    break;
                }
            }
        }

        return cards;
    }

    private Card randomCard() {
        return cards[(int)(Math.random() * 52)];
    }

    public String getResult(Card[] cards) {
        Result result = new Result();

        checkStraightFlush(cards, result);
        checkFourCards(cards, result);
        checkFullHouse(cards, result);
        /*checkFlush(cards, result);
        /*checkStraight(cards, result);
        /*checkTriple(cards, result);
        /*checkTwoPair(cards, result);
        /*checkOnePiar(cards, result);
        /*checkTop(cards, result);*/


        if(isStraightFlush(cards)) return findTopCard(cards).getNumber() + " 스트레이트 플러쉬";
        else if(result.what == Result.FOUR_CARDS) return result.top + " 포커";
        else if(result.what == Result.FULL_HOUSE) return result.top + " 풀 하우스";
        else if(isFlush(cards)) return findTopCard(cards).getNumber() + " 플러쉬";
        else if(isStraight(cards)) return findTopCard(cards).getNumber() + " 스트레이트";
        else if(isTriple(cards)) return findTopCard(cards).getNumber() + " 트리플";
        else if(isTwoPair(cards)) return findTopCard(cards).getNumber() + " 투페어";
        else if(isOnePair(cards)) return findTopCard(cards).getNumber() + " 원페어";
        return findTopCard(cards).number + "탑";
    }

    private void checkStraightFlush(Card[] cards, Result result) {
        if(result.isDone()) return;
        //result.what = Result.STRAIGHT_FLUSH;
    }

    private void checkFourCards(Card[] cards, Result result) {
        if(result.isDone()) return;

        HaechiArray array = sameNumbers(cards, FOUR_CARDS);

        if(!array.isEmpty()) {
            result.what = Result.FOUR_CARDS;
            result.top = array.first();
        }
    }

    private void checkFullHouse(Card[] cards, Result result) {
        if(result.isDone()) return;

        if(sameCount(cards, PAIR) >= 1 && sameCount(cards, TRIPLE) >= 1) {
            result.what = Result.FULL_HOUSE;
            result.top = topCard(cards);
        }
    }

    private void checkFlush(Card[] cards, Result result) {
         if(isFlush(cards)) {
             result.what = Result.FLUSH;
             result.top = topCards(cards);
         }
    }

    private int topCard(Card[] cards) {
        for(int i = 0; i < cards.length; i++) {
            if (cards[i].checked) return cards[i].number;
        }

        return 0;
    }

    private int topCards(Card[] cards) {
        /*for(int i = 0; i < cards.length; i++) {
            if(cards[i].checked)
        }*/

        return 0;
    }

    private boolean isStraightFlush(Card[] cards) {
        if(isStraight(cards) && checkFlushOfStraightFlush(cards)) return true;
        return false;
    }

    private boolean checkFlushOfStraightFlush(Card[] cards) {
        for (int i = 0; i < (cards.length - 1); i++) {
            int count = 1;

            if(!cards[i].checked) continue;

            for (int j = (i + 1); j < cards.length; j++) {
                if(!cards[j].checked) continue;
                else if (cards[i].shape == cards[j].shape) count++;
            }

            if (count >= 5) return true;
        }

        return false;
    }

    private boolean isFourCards(Card[] cards) {
        if(sameCount(cards, FOUR_CARDS) >= 1) return true;
        return false;
    }

    private boolean isFullHouse(Card[] cards) {
        if(isOnePair(cards) && isTriple(cards)) return true;
        return false;
    }

    private boolean isFlush(Card[] cards) {
        for(int i = 0; i < (cards.length - 1); i++) {
            int count = 1;
            clearChecked();

            for(int j = (i + 1); j < cards.length; j++) {
                if (cards[i].shape == cards[j].shape) {
                    cards[i].checked = true;
                    cards[j].checked = true;
                    count++;
                }
            }

            if(count >= 5) return true;
        }

        return false;
    }

    private boolean isStraight(Card[] cards) {
        int count = 1;

        clearChecked();
        sort(cards, false);

        if(isBackStraight(cards)) return true;

        for (int i = 0; i < (cards.length - 1); i++) {
            if (cards[i].number == cards[i + 1].number) continue;
            else if ((cards[i].number - 1) == cards[i + 1].number) {
                count++;
                if (count >= 5) return true;
            }
            else count = 1;
        }

        return false;
    }

    private boolean isBackStraight(Card[] cards) {
        int[] backStraight = { 2, 3, 4, 5, 14 };

        for(int i = 0; i < backStraight.length; i++) {
            if(!existsNumber(cards, backStraight[i])) return false;
        }

        return true;
    }

    private boolean existsNumber(Card[] cards, int number) {
        for(int i = 0; i < cards.length; i++) {
            if(cards[i].number == number) return true;
        }

        return false;
    }

    private boolean isTriple(Card[] cards) {
        if(sameCount(cards, TRIPLE) >= 1) return true;
        return false;
    }

    private boolean isTwoPair(Card[] cards) {
        if(sameCount(cards, PAIR) >= 2) return true;
        return false;
    }

    private boolean isOnePair(Card[] cards) {
        if(sameCount(cards, PAIR) >= 1) return true;
        return false;
    }

    private HaechiArray sameNumbers(Card[] cards, int type) {
        HaechiArray array = new HaechiArray();

        clearChecked();

        for(int i = 0; i < cards.length - 1; i++) {
            if(cards[i].checked) continue;

            int count = 1;

            for(int j = (i + 1); j < cards.length; j++) {
                if(cards[j].checked) continue;

                if(cards[i].number == cards[j].number) {
                    cards[i].checked = true;
                    cards[j].checked = true;
                    count++;
                }
            }

            if(count >= 2) array.add(cards[i].number);
        }

        return array;
    }

    private int sameCount(Card[] cards, int type) {
        int pairCount = 0;
        int tripleCount = 0;
        int fourCardsCount = 0;

        clearChecked();

        for(int i = 0; i < cards.length - 1; i++) {
            if(cards[i].checked) continue;

            int count = 1;

            for(int j = (i + 1); j < cards.length; j++) {
                if(cards[j].checked) continue;

                if(cards[i].number == cards[j].number) {
                    cards[i].checked = true;
                    cards[j].checked = true;
                    count++;
                }
            }

            if(count == 2) pairCount++;
            else if(count == 3) tripleCount++;
            else if(count == 4) fourCardsCount++;
        }

        if(type == PAIR) return pairCount;
        else if(type == TRIPLE) return tripleCount;
        else if(type == FOUR_CARDS) return fourCardsCount;
        return 0;
    }

    private Card findTopCard(Card[] cards) {
        sort(cards, false);

        for(int i = 0; i < cards.length; i++) {
            if(cards[i].checked) return cards[i];
        }

        return cards[0];
    }

    private void sort(Card[] cards, boolean ascending) {
        Card temp;

        for(int i = 0; i < cards.length - 1; i++) {
            for(int j = (i + 1); j < cards.length; j++) {
                if((cards[i].number > cards[j].number && ascending) || (cards[i].number < cards[j].number && !ascending)) {
                    temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }
    }

    private void clearChecked() {
        for(int i = 0; i < cards.length; i++) {
            cards[i].checked = false;
        }
    }

    private void test() {
        for(int i = 0; i < cards.length; i++) {
            System.out.print(cards[i].number + " ");
            System.out.print(cards[i].shape + " ");
            System.out.println();
        }
    }
}
