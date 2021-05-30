import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {// p493 예제
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        // 내 컴퓨터 시간 기준
        System.out.println(1900+d.getYear());
        // 취소선은 사용은 가능하나 다양한 문제로 사용하지 않기를 권고한다는 의미
        System.out.println(d.getMonth()+1);
        // 월은 0부터 시작된다. 따라서 getMonth()로 계산시 날짜는 1월이 0이다.
        System.out.println(d.getDate());

        d.setHours(12);
        // 시간 바꾸기  - 이런 set메서드는 년월일 등 종류별로 다 있다!
        d.setMinutes(34);
        d.setSeconds(0);
        System.out.println(d);

        // SimpleDateFormat sdf = new SimpleDateFormat(문자열로 출력형태를 잡아줌);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, MMM d, ' 'yy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("h:mm a");
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy년 MM월 dd일 EEE a hh시 mm분 ss초");
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf2.format(new Date()));
        System.out.println(sdf3.format(new Date()));
        System.out.println(sdf4.format(new Date()));
        System.out.println(sdf5.format(new Date()));
    }
}