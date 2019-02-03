public class HString {
    /*
        정수를 입력받고 문자열로 표시하는 함수(codeToString)를 만드시오.

        정수    문자
        --------------
        32      스페이스

        48      0
        49      1
        50      2
        51      3
        52      4
        53      5
        54      6
        55      7
        56      8
        57      9

        65      A
        66      B
        67      C
        68      D
         (중간생략)
        88      X
        89      Y
        90      Z

        97      a
        98      b
        99      c
        100     d
         (중간생략)
        120     x
        121     y
        122     z


        입출력 예

        codes                                                       return
        --------------------------------------------------------------------------
        [65,66,67]                                                  ABC
        [73,32,97,109,32,97,32,115,116,117,100,101,110,116]         I am a student
        [73,32,104,97,118,101,32,50,56,53,32,99,97,114,115]         I have 285 cars

     */

    /*
        개발한 일시/시간을 꼭 적어주세요.

        작업1>48:00:97
     */

    public static void main(String[] agrs) {
        int[] codes = {73,32,104,97,118,101,32,50,56,53,32,99,97,114,115};

        System.out.println(codeToString(codes));
    }

    public static String codeToString(int[] codes) {
        String[] strings48_57 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] strings65_90 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] strings97_122 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s","t", "u", "v", "w", "x", "y", "z"};
        String message = "";

        /*for(int i = 0; i < codes.length; i++) {
            if(48 <= codes[i] && 57 >= codes[i]) message += strings48_57[codes[i] - 48];
            else if(65 <= codes[i] && 90 >= codes[i]) message += strings65_90[codes[i] - 65];
            else if(97 <= codes[i] && 122 >= codes[i]) message += strings97_122[codes[i] - 97];
            else message += " ";
        }*/

        int num = 65;
        char ch = '\\';
        String str = "AB\tC\nAB C\\t";

        System.out.println(str);


        return message;
    }
}