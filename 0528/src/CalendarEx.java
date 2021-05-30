import java.util.Calendar;

public class CalendarEx {
    public static void main(String[] args) {
        // Calendar 클래스는 생성을 하지않는다!
        // 왜? 메서드를 통해서 생성된 객체를 가져와서 사용하게 되어있기 때문이다.
        // 한 번만 생성하면 static으로 처리되어 언제라도 불러올 수 있다! - Singleton Pattern
        // 당장은 필요없으므로 이름만 한 번 들어놓자~ (웹에서 다시 설명할 예정)

		/*Calendar d = Calendar.getInstance();// 메서드를 통해서 내부적으로 생성된다!
		System.out.println(d);// 출력결과 엄청 길다~
		System.out.println(d.get(Calendar.YEAR));// 연도
		System.out.println(d.get(Calendar.MONTH));// 1월이 0이다.
		System.out.println(d.get(Calendar.DATE));// 일
		System.out.println(d.get(Calendar.DAY_OF_WEEK));// 요일(일요일이 1이다.)*/

        // 샘이 주신 코드
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int date = today.get(Calendar.DATE);

        int woy = today.get(Calendar.WEEK_OF_YEAR);
        int wom = today.get(Calendar.WEEK_OF_MONTH);

        int doy = today.get(Calendar.DAY_OF_YEAR);
        int dom = today.get(Calendar.DAY_OF_MONTH);
        int dow = today.get(Calendar.DAY_OF_WEEK);

        int hour12 = today.get(Calendar.HOUR);
        int hour24 = today.get(Calendar.HOUR_OF_DAY);
        int minute = today.get(Calendar.MINUTE);
        int second = today.get(Calendar.SECOND);

        int milliSecond = today.get(Calendar.MILLISECOND);
        int timeZone = today.get(Calendar.ZONE_OFFSET);
        int lastDate = today.getActualMaximum(Calendar.DATE);

        System.out.println("오늘은 " + year +"년 " + month+1 + "월" + date +"일");
        System.out.println("오늘은 올해의 " + woy +"째주, 이번달의 " + wom + "째주. " + date +"일");
        System.out.println("오늘은 이번 해의 " + doy +"일이자, 이번 달의 " + dom + "일. 요일은 " + dow +"일 (1:일요일)");
        System.out.println("현재 시각은 " + hour12 +":"+ minute + ":"+ second +", 24시간으로 표현하면 " + hour24+":"+ minute + ":"+ second);
        System.out.println("오늘은 " + year +"년 " + (month+1) + "월" + date +"일");
        System.out.println("1000분의 1초 (0~999): " + milliSecond);
        System.out.println("timeZone (-12~+12): " + timeZone/(60*60*1000)); // 1000분의 1초를 시간으로 표시하기 위해 60*60*1000
        System.out.println("이 달의 마지막 날: " + lastDate);
    }
}
