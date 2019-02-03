public class Average {
    /*
        [평균 구하기]

        문제 설명

        정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.


        제한사항

        arr은 길이 1 이상, 100 이하인 배열입니다.
        arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.


        입출력 예

        arr         return
        ------------------
        [1,2,3,4]   2.5
        [5,5]       5
     */

     /*
        개발한 일시/시간을 꼭 적어주세요.

        작업1> 14:17:91
     */

    public static void main(String[] args) {
        int[] arr = {5,5};

        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0;

        for(int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        answer /= arr.length;

        return answer;
    }
}