package poker;

import test.HaechiArray;

public class ResultChecker {
    public static final int PAIR = 0;
    public static final int TRIPLE = 1;
    public static final int FOUR_CARDS = 2;

    public Player determineWinner(Player player1, Player player2) {
        Result result1 = player1.getResult();
        Result result2 = player2.getResult();

        if(result1.what != result2.what) return result1.what > result2.what ? player1 : player2;

        return compareDetails(player1 , player2) > 0 ? player1 : player2;
    }

    private int compareDetails(Player player1, Player player2) {
        Result result1 = player1.getResult();
        Result result2 = player2.getResult();

        if(result1.what == result1.STRAIGHT_FLUSH
                || result1.what == result1.STRAIGHT
                || result1.what == result1.FLUSH) {
            return compareNumbers(result1.tops, result2.tops);
        }
        else if(result1.what == result1.FOUR_CARDS
                || result1.what == result1.FULL_HOUSE
                || result1.what == result1.TRIPLE) {
            return result1.top > result2.top ? 1 : -1;
        }
        else {
            int result = compareNumbers(result1.tops, result2.tops);

            if(result != 0) return result;

            return compareNumbers(result1.others, result2.others);
        }
    }

    private int compareNumbers(HaechiArray numbers1, HaechiArray numbers2) {
        for(int i = 0; i < numbers1.size(); i++) {
            if(numbers1.get(i) != numbers2.get(i)) {
                return numbers1.get(i) > numbers2.get(i) ? 1 : -1;
            }
        }

        return 0;
    }

    public void makeResult(Player player) {
        Result result = new Result();
        Card[] cards = player.getCards();

        checkStraightFlush(cards, result);
        checkFourCards(cards, result);
        checkFullHouse(cards, result);
        checkFlush(cards, result);
        checkStraight(cards, result);
        checkTriple(cards, result);
        checkPair(cards, result);
        checkTop(cards, result);

        player.setResult(result);
    }

    private void checkStraightFlush(Card[] cards, Result result) {
        if(result.isDone()) return;

        if(isStraight(cards) && isFlush(cards)) {
            result.what = Result.STRAIGHT_FLUSH;
            findTops(cards, result);
        }
    }

    private void checkFourCards(Card[] cards, Result result) {
        if(result.isDone()) return;

        HaechiArray tops = sameNumbers(cards, FOUR_CARDS);

        if(!tops.isEmpty()) {
            result.what = Result.FOUR_CARDS;
            result.top = tops.first();
        }
    }

    private void checkFullHouse(Card[] cards, Result result) {
        if(result.isDone()) return;

        HaechiArray tripleTops = sameNumbers(cards , TRIPLE);
        HaechiArray pairTops = sameNumbers(cards , PAIR);

        if(!tripleTops.isEmpty() && !pairTops.isEmpty()) {
            result.what = Result.FULL_HOUSE;
            result.top = tripleTops.first();
        }
    }

    private void checkFlush(Card[] cards, Result result) {
        if(result.isDone()) return;

        if(isFlush(cards)) {
            result.what = Result.FLUSH;
            findTops(cards, result);
        }
    }

    private void checkStraight(Card[] cards, Result result) {
        if(result.isDone()) return;

        if(isStraight(cards)) {
            result.what = Result.STRAIGHT;
            findTops(cards, result);
        }
    }

    private void checkTriple(Card[] cards, Result result) {
        if(result.isDone()) return;

        HaechiArray tops = sameNumbers(cards, TRIPLE);

        if(!tops.isEmpty()) {
            result.what = Result.TRIPLE;
            result.top = tops.first();
        }
    }

    private void checkPair(Card[] cards, Result result) {
        if(result.isDone()) return;

        HaechiArray tops = sameNumbers(cards, PAIR);
        tops.sort(false);

        if(!tops.isEmpty()) {
            result.what = tops.size() == 1 ? Result.ONE_PAIR : Result.TWO_PAIR;
            result.top = tops.first();
            result.tops = tops;

            for(int i = 0; i < cards.length; i++) {
                if(!cards[i].isChecked()) result.others.add(cards[i].getNumber());
            }
        }
    }

    private void checkTop(Card[] cards, Result result) {
        if(result.isDone()) return;
        if(findTops(cards, result)) result.what = Result.TOP;
    }


    private boolean isFlush(Card[] cards) {
        for(int i = 0; i < (cards.length - 1); i++) {
            int count = 1;
            clearChecked(cards);

            for(int j = (i + 1); j < cards.length; j++) {
                if (cards[i].getShape() == cards[j].getShape()) {
                    cards[i].setChecked(true);
                    cards[j].setChecked(true);
                    count++;
                }
            }

            if(count >= 5) return true;
        }

        return false;
    }

    private boolean isStraight(Card[] cards) {
        int count = 1;

        clearChecked(cards);
        sort(cards, false);

        if(isBackStraight(cards)) return true;

        for (int i = 0; i < (cards.length - 1); i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber()) continue;
            else if ((cards[i].getNumber() - 1) == cards[i + 1].getNumber()) {
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

    private boolean findTops(Card[] cards, Result result) {
        if(cards.length <= 0) return false;

        sort(cards, false);

        result.top = cards[0].getNumber();

        for(int i = 0; i < cards.length; i++) {
            result.tops.add(cards[i].getNumber());
        }

        return true;
    }

    private boolean existsNumber(Card[] cards, int number) {
        for(int i = 0; i < cards.length; i++) {
            if(cards[i].getNumber() == number) return true;
        }

        return false;
    }

    private HaechiArray sameNumbers(Card[] cards, int type) {
        HaechiArray array = new HaechiArray();

        clearChecked(cards);

        for(int i = 0; i < cards.length - 1; i++) {
            if(cards[i].isChecked()) continue;

            int count = 1;

            for(int j = (i + 1); j < cards.length; j++) {
                if(cards[j].isChecked()) continue;

                if(cards[i].getNumber() == cards[j].getNumber()) {
                    cards[i].setChecked(true);
                    cards[j].setChecked(true);
                    count++;
                }
            }

            if(count == 2 && type == PAIR) array.add(cards[i].getNumber());
            else if(count == 3 && type == TRIPLE) array.add(cards[i].getNumber());
            else if(count == 4 && type == FOUR_CARDS) array.add(cards[i].getNumber());
        }

        return array;
    }

    private void sort(Card[] cards, boolean ascending) {
        Card temp;

        for(int i = 0; i < cards.length - 1; i++) {
            for(int j = (i + 1); j < cards.length; j++) {
                if((cards[i].getNumber() > cards[j].getNumber() && ascending) || (cards[i].getNumber() < cards[j].getNumber() && !ascending)) {
                    temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }
    }

    private void clearChecked(Card[] cards) {
        for(int i = 0; i < cards.length; i++) {
            cards[i].setChecked(false);
        }
    }
}
