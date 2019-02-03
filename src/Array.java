public class Array {
    //  concat
    //      두 개의 배열의 내용을 합치는 함수
    //
    //  find
    //      배열 내에 특정 요소가 있다면, 요소의 색인(인덱스)값을 리턴
    //      그렇지 않다면 -1을 리턴
    //
    //  lastFind
    //      위 find와 동일하나 요소를 배열 뒤쪽에서부터 찾는 함수
    //
    //  exists
    //      배열 내에 특정 요소가 있다면, true를 리턴
    //      그렇지 않다면 false를 리턴
    //
    public static void main(String[] args) {
        int[] input1 = {1, 3, 5, 7, 3, 11};
        int[] input2 = {23, 45, 67, 89};

        set(input1, 1, 999);

        int[] output = concat(input1, input2);
        print(output);
        System.out.println(find(input2, 45) == 1 ? "성공" : "실패");
        System.out.println(find(output, 45) == 7 ? "성공" : "실패");
        System.out.println(find(input1, 3) == 4 ? "성공" : "실패");
        System.out.println(lastFind(input1, 3) == 4 ? "성공" : "실패");
        System.out.println(!exists(input1, 45) ? "성공" : "실패");
        System.out.println(exists(output, 45) ? "성공" : "실패");
        System.out.println(get(input1, 3) == 7 ? "성공" : "실패");
    }

    public static int[] concat(int[] input1, int[] input2) {
        int[] output = new int[input1.length + input2.length];
        int index = 0;

        for(int i = 0; i < input1.length; i++) {
            output[index++] = input1[i];
        }

        for(int i = 0; i < input2.length; i++) {
            output[index++] = input2[i];
        }

        return output;
    }

    public static void set(int[] array, int index, int number) {
        if(index >= 0 || index < array.length) {
            array[index] = number;
        }
    }

    public static int get(int[] array, int index) {
        if(index < 0 || index >= array.length) return 0;

        return array[index];
    }

    public static int find(int[] array, int number) {
        for(int index = 0; index < array.length; index++) {
            if(array[index] == number) return index;
        }

        return -1;
    }

    public static int lastFind(int[] array, int number) {
        for(int index = array.length - 1; index >= 0; index--){
            if(array[index] == number) return index;
        }

        return -1;
    }

    public static boolean exists(int[] array, int number) {
        return find(array, number) >= 0;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

        System.out.println();
    }

    public static int[] reverse(int[] input) {
        int[] output = new int[input.length];
        int index = 0;

        for(int i = input.length - 1; i >= 0; i--) {
            output[index++] = input[i];
        }

        return output;
    }
}
