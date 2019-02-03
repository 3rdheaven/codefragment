public class FizzBuzz {
    //  1
    //  Babo
    //  Fizz
    //  BaboBuzz
    //  5
    //  BaboFizz
    //  7
    //  BaboBuzz
    //  Fizz
    //  Babo
    //  11
    //  BaboFizzBuzz
    //  13

    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) {
            if(i % 2 != 0 && i % 3 != 0 && i % 4 != 0) System.out.print(i);
            else {
                if (i % 2 == 0) System.out.print("Babo");
                if (i % 3 == 0) System.out.print("Fizz");
                if (i % 4 == 0) System.out.print("Buzz");
            }

            System.out.println();
        }

        System.out.println();
    }
}
