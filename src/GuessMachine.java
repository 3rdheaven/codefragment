public class GuessMachine {
    public static void main(String[] args) {
        int digits = 3;
        int min = 0;
        int max = Integer.MAX_VALUE;
        int trun = 1;

        int answer = random(digits);
        int number;

        System.out.println("랜덤수: " + answer);

        while(true) {
            number = random(digits, min, max);
            System.out.println(trun + "번째 시도: " + number);

            if(number == answer) break;

            if(number < answer) min = number;
            else if(number > answer) max = number;

            trun++;
        }

        System.out.println(trun + "번 만에 정답");
    }

    public static int random(int min, int max) {
        //  중복을 허용하는 함수
        return 0;
    }

    public static int random(int digits, int min, int max) {
        int number;

        while(true) {
            number = random(digits);

            if(number >= min && number <= max) break;
        }

        return number;
    }

    public static int random(int digits) {
        if(digits >= 10) return 0;

        int result = 0;
        boolean[] selected = new boolean[10];

        for(int i = 0; i < selected.length; i++) {
            selected[i] = false;
        }

        for(int i = 0; i < digits; i++) {
            while(true) {
                int number = (int)(Math.random() * 10);

                if(i == 0 && number == 0) continue;
                else if(selected[number]) continue;
                else {
                    result += number * square(digits - i);
                    selected[number] = true;
                    break;
                }
            }
        }

        return result;
    }

    public static int square(int digits) {
        int result = 1;

        for(int i = 1; i < digits; i++) {
            result *= 10;
        }

        return result;
    }
}
