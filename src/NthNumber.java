public class NthNumber {
    /*
        [K번째 수]

        문제 설명

        배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

        예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

        1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
        2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
        3. 2에서 나온 배열의 3번째 숫자는 5입니다.

        배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
        commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.


        제한사항

        array의 길이는 1 이상 100 이하입니다.
        array의 각 원소는 1 이상 100 이하입니다.
        commands의 길이는 1 이상 50 이하입니다.
        commands의 각 원소는 길이가 3입니다.


        입출력 예
        array                   commands                                return
        [1, 5, 2, 6, 3, 7, 4]   [[2, 5, 3], [4, 4, 1], [1, 7, 3]]       [5, 6, 3]


        입출력 예 설명

        [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
        [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
        [1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
     */



    /*
        준형아, 다음과 같이 단계별로 해결해봐!~

        <1단계>

        array가 [1, 5, 2, 6, 3, 7, 4] 일때
        command가 [2, 5, 3]이면 5
        command가 [4, 4, 1]이면 6
        command가 [1, 7, 3]이면 3

        위와 같이 동작하는 nthNumber() 함수를 만들것


        <2단계>
        위 <1단계>의 함수를 이용하여 문제에서 원하는대로 solution() 함수를 최종 완성할것


        * 참고로 2차원 배열은 배열의 요소가 또 배열인 것을 말해.
          예를 들어 다음과 같아.

          int[][] commands = new int[3];

          commands[0] = new int[5];
          commands[1] = new int[10];
          commands[2] = new int[100];

          commands[0][0] = 123;
          commands[0][4] = 999;

          commands[1][0] = 333;
          commands[1][9] = 222;

          commands[2][0] = 983;
          commands[2][99] = 111;

          한번 잘 고민해봐.
          화이팅!!
     */
    public static void main(String[] args) {
        int[] array = { 2, 3, 54, 6, 4, 7, 42, 1, 5 };
        int[][] commands = {{1, 6, 5}, {2, 9, 7}, {1, 7, 1}, {1, 4, 3}};
        int[] answers = solution(array, commands);

        for(int i = 0; i < answers.length; i++) {
            //System.out.print(answers[i]  + "   ");
        }

        int[] result = sort(new int[] {500, 1, 2, 7, 99, 2}, true);

        for(int i=0; i<result.length; i++)
            System.out.print(result[i] + " ");
    }

    //34:41:94

    public static int nthNumber(int[] array, int[] command) {
        int start = command[0];
        int end = command[1];
        int nth = command[2];
        int index = 0;
        int[] commands = new int[(end - start) + 1];

        for(int i = start - 1; i < end; i++) {
            commands[index++] = array[i];
        }

        return sort(commands, true)[nth - 1];
    }

    //01:42:12:89

    public static int[] sort(int[] array, boolean ascending) {
        int temp;

        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
               if((array[i] > array[j] && ascending) || (array[i] < array[j] && !ascending)) {
                   temp = array[i];
                   array[i] = array[j];
                   array[j] = temp;
               }
            }
        }

        return array;
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = nthNumber(array, commands[i]);
        }

        return answer;
    }
}