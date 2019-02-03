public class PrimeNumber {
    //  [소수의 합]
    //
    //  문제 설명
    //
    //  2부터 N까지의 모든 소수의 합을 구하세요.
    //  N이 7이라면 {2,3,5,7} = 17을 출력 하시면 됩니다.
    //  N의 범위는 2이상 10,000,000이하 입니다.
    //  효율성 테스트의 모든 시간 제한은 1초입니다.

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(sumPrimeNumbers(8000000));
        System.out.println(solution(8000000));
        System.out.print("소요시간(ms): " + (System.currentTimeMillis() - time));
    }

    public static int solution(int n) {
        int sum = 0;

        for(int i = 2; i <= n; i++) {
            if(isPrimeNumberVer2(i)) sum += i;
        }

        return sum;
    }

    public static boolean isPrimeNumberVer1(int n) {
        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }

    public static boolean isPrimeNumberVer2(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }

    public static int sumPrimeNumbers(int n) {
        int sum = 0;
        int index = 0;
        int[] primeNumbers = new int[n - 1];

        for(int i = 0; i < primeNumbers.length; i++) {
            primeNumbers[i] = 0;
        }

        for(int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for(int j = 0; j < primeNumbers.length; j++) {
                if(primeNumbers[j] <= 0) break;

                if(i % primeNumbers[j] == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) primeNumbers[index++] = i;
        }

        for(int i = 0; i < primeNumbers.length; i++) {
            if(primeNumbers[i] <= 0) break;
            sum += primeNumbers[i];
        }

        return sum;
    }
}
