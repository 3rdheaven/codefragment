package poker;

public class Result {
    public static final int NONE = 0;
    public static final int STRAIGHT_FLUSH = 1;
    public static final int FOUR_CARDS = 2;
    public static final int FULL_HOUSE = 3;
    public static final int FLUSH = 4;
    public static final int STRAIGHT = 5;
    public static final int TRIPLE = 6;
    public static final int TOW_PAIR = 7;
    public static final int ONE_PAIR = 8;
    public static final int TOP = 9;

    public int what = NONE;
    public int[] tops;  //  플러쉬, 스트레이트, 망통일때 모든 숫자들
    public int top;     //  포커, 풀하우스, 트리플의 숫자
    public int shape;   //  가장 높은 숫자의 모양

    public int[] twoPairTops;   //  2개
    public int twoPairOther;

    public int onePairTop;
    public int[] onePairOthers; //  3개

    public boolean isDone() {
        return what != NONE;
    }
}