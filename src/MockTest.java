public class MockTest {
    //  [모의고사]
    //
    //  문제 설명
    //
    //  수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
    //  수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
    //
    //  1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    //  2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    //  3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
    //
    //  1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    //  가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    //
    //  제한 조건
    //
    //  시험은 최대 10,000 문제로 구성되어있습니다.
    //  문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    //  가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    //
    //  입출력 예
    //
    //  answers         return
    //
    //  [1,2,3,4,5]     [1]
    //  [1,3,2,4,2]     [1,2,3]
    //
    //  입출력 예 설명
    //
    //  입출력 예 #1
    //  수포자 1은 모든 문제를 맞혔습니다.
    //  수포자 2는 모든 문제를 틀렸습니다.
    //  수포자 3은 모든 문제를 틀렸습니다.
    //  따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
    //
    //  입출력 예 #2
    //  수포자 1은 [1, 4]번 문제를 맞혔습니다.
    //  수포자 2는 [3, 5]번 문제를 맞혔습니다.
    //  수포자 3은 [2, 5]번 문제를 맞혔습니다.
    //  따라서 가장 문제를 많이 맞힌 사름은 수포자 1, 2, 3 모두 인데 오름차순 정렬이므로 [1, 2, 3]을 리턴합니다.
    //

    public static void main(String[] args) {
        int[] answers = {3, 1, 4, 4, 3, 5, 2};

        for(int i = 0; i < solution(answers).length; i++) {
            if (solution(answers)[i] == 0) continue;
            else System.out.print(solution(answers)[i] + "  ");
        }
    }

    public static int[] solution(int[] answers) {
        int max = 0;
        int persons = 0;
        int array = 0;

        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] pattern4 = {3, 1, 4, 4, 3, 5, 2};

        int[] scores = {score(answers, pattern1), score(answers, pattern2), score(answers, pattern3), score(answers, pattern4)};

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= max) max = scores[i];
        }

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) persons++;
        }

        int[] firsts = new int[persons];

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                firsts[array] = i + 1;
                array++;
            }
        }

        return firsts;
    }

        //  (1) 수포자수만큼의 배열을 만들어 각각의 점수를 담기

        //  (2) (1)에서 구한 배열에서 최대 점수 찾기

        //  (3) (1)에서 구한 배열에서 최대 점수인 사람수 찾기

        //  (4) (3)에서 구한 사람수 크기의 배열을 만들기

        //  (5) (4)에서 만든 배열에 최대 점수를 받은 사람 넣기
    public static int score(int[] answers, int[] pattern) {
        int score = 0;

        for(int i = 0; i < answers.length; i++) {
            if(pattern[i % pattern.length] == answers[i]) score++;
        }

        return score;
    }
}