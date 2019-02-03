public class Watermelon {
    /*
        [수박수박수박수박수박수?]

        문제 설명

        길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
        예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.


        제한 조건
        n은 길이 10,000이하인 자연수입니다.


        입출력 예
        n       return
        --------------
        3       수박수
        4       수박수박
     */

    /*
        개발한 일시/시간을 꼭 적어주세요.

        작업1> 06:13:11
     */

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        String answer = "";

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) answer += "수";
            else answer += "박";
        }

        return answer;
    }
}