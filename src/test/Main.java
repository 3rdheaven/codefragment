package test;

public class Main {
    public static void main(String[] args) {
        HaechiArray array = new HaechiArray();
        int[] test = { 1,2,3 };
        int[] test2 = { 9,8,7,6,5,4,3,2,1,0 };

        for(int i = 0; i < 100000000; i++) {
            array.add(i);
        }

        for(int i = 0; i < 10; i++) {
            array.remove(0);
            System.out.println(array.size());
        }

        /*System.out.println(array.size());   //  0
        System.out.println(array.isEmpty());    // true
        array.add(333);
        System.out.println(array.size());   //  1
        System.out.println(array.isEmpty());    //  false
        array.add(777);
        System.out.println(array.size());   //  2
        array.addAll(test);
        System.out.println(array.size());   //  5
        System.out.println(array.contains(777));    //  ture
        System.out.println(array.contains(111));    //  false
        System.out.println(array.get(0));   //  333
        array.set(0, 888);
        array.print();
        System.out.println(array.get(0));   // 888
        System.out.println(array.get(3));   //  2
        System.out.println(array.get(100)); //  -1
        System.out.println(array.indexOf(777)); //  1
        System.out.println(array.indexOf(1004));    //  -1
        array.sort(true);
        array.print();  //  [1,2,3,777,888]
        array.sort(false);
        array.print();  //  [888,777,3,2,1]
        array.remove(4);
        array.print();  //  [888,777,3,2]
        array.remove(1);
        array.print();  //  [888,3,2]
        array.clear();
        System.out.println(array.size());   //  0
        array.addAll(test2);
        array.print();  //  [9,8,7,6,5,4,3,2,1,0]
        array.add(11);
        array.print();  //  [9,8,7,6,5,4,3,2,1,0,11]
        array.add(12);
        array.print();  //  [9,8,7,6,5,4,3,2,1,0,11]*/


        //01:30:9:54
    }
}
