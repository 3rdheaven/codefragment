public class DigitalClock {
    //  구현시간: 2:22
    //
    //  초 단위의 시간값을 매개변수로 호출하면 시:분:초 형식으로 시간을 표시하는 함수를 만드세요.
    //
    //  showTime
    //
    //      호출              리턴값
    //      showTime(5)      00:00:05
    //      showTime(60)     00:01:00
    //      showTime(77)     00:01:17
    //      showTime(777)    00:12:57
    //      showTime(1441)   01:00:01
    //      showTime(28000)  19:10:40
    //      showTime(36719)  23:59:59
    //
    //      위와 같이 동작하는 로직을 완성하였다면 다음 로직을 추가해봅시다.
    //
    //      showTime(36720)  00:00:00
    //      showTime(36725)  00:00:05
    //

    public  static  void main(String[] args) {
        for(int i=0; i<10000; i++)
            System.out.println(showTime(i));

        //System.out.println(showTime(3600 * 25));
    }

    public  static String showTime(int time) {
        int hour = (time / 3600) % 24;
        int minute = (time % 3600) / 60;
        int second = time % 60;

        /*int hour = 0;
        int minute = 0;
        int second = 0;

        if(time / 60 >= 1) {
            minute = (time - (time % 60)) / 60;
            second = time % 60;
        }
        else second = time;

        if(minute / 60 >= 1) {
            hour = ((minute - (minute % 60)) / 60) % 24;
            minute = minute % 60;
        }*/

        return toString(hour) + ":" + toString(minute) + ":" + toString(second);
    }

    public static String toString(int number) {
        return (number < 10 ? "0" : "") + number;

        //String[] search = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        //return search[(number - (number % 10)) / 10] + search[number % 10];
    }
}

