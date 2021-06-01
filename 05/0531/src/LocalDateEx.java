import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class LocalDateEx {
    // Date클래스와 Calendar클래스를 훨씬 더 많이 사용하지만
    // 쓰는 이유는 그냥 예전부터 써서 이미 익숙해졌기 때문이다!
    // 하지만 아직도 상당한 버그와 규칙없는 상수들이 많다.
    // 그래서 java 1.8버전부터 새로 만든 날짜 클래스인 LocalDate를 사용한다!
    // java.util.Date => java.util.Calendar => java.time(org.joda.time)

    // LocalDate - 오로지 날짜 정보만 필요할 때 사용
    // LocalTime - 오로지 시간 정보만 필요할 때 사용
    // LocalDateTime - 날짜 시간 정보 함께 필요할 때 사용

    public static void main(String[] args) {
        // 현재 날짜 불러오기
        LocalDate currentDate = LocalDate.now();// static형 메소드를 통해서 사용
        System.out.println(currentDate);

        // 직접 날짜 설정
        LocalDate myDate = LocalDate.of(2020, 01, 12);
        System.out.println(myDate);

        // 현재 시간 불러오기
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        // 직접 시간 설정
        LocalTime myTime = LocalTime.of(17, 45, 50);
        System.out.println(myTime);

        // 날짜 시간 함께 쓰기
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime);

        // 날짜 시간 함께 설정
        LocalDateTime myDateTime = LocalDateTime.of(2020, 05, 29, 8, 55, 44, 222);
        System.out.println(myDateTime);

        // 시간과 날짜를 비교할 수 있다!
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = LocalTime.of(9, 50, 20);
        // start보다 end가  이전인지
        System.out.println(startTime.isBefore(endTime));// true
        // start보다 end가 이후인지
        System.out.println(startTime.isAfter(endTime));// false

        // 시간과 날짜를 계산할 수 있다!
        LocalDateTime testDateTime = LocalDateTime.now();
        // plusDays, plusYears, ..., plusHours, plusMinutes,
        // minusDays, minusYears, ... 등 쉽게 계산할 수 있다!
        System.out.println(testDateTime.plusDays(3));

        // 날짜가 얼마나 차이나는지 비교할 수 있다!
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(2020, 05, 31);
        Period period = Period.between(startDate, endDate);
        System.out.println(period.getYears());// -1
        System.out.println(period.getMonths());// 0
        System.out.println(period.getDays());// 0

        // 출력 형식 설정 SimpleDateFormat => DateTimeFormatter
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str = dtf.format(ldt);
        System.out.println(str);

        // 날짜를 String타입으로 변경하기
        // 뭐든지 문자랑 합치면 문자열이 된다!
        String strDate = LocalDateTime.now() + "";

        // String타입을 LocalDate타입으로 변경하기
        LocalDate dateVal = LocalDate.parse("2021-05-19");

        System.out.println(strDate);// 2021-05-31T09:41:54.125
        System.out.println(dateVal);// 2021-05-19

        // Q. 달력을 만들 때 필요한 것? 월의 마지막 날짜.
        LocalDate targetDate = LocalDate.of(2021, 05, 02);
        YearMonth yearMonth = YearMonth.from(targetDate);
        // 해당월의 일 수 - 날짜 for문 돌릴 때
        System.out.println(yearMonth.lengthOfMonth());
        // 해당월의 마지막 날
        System.out.println(yearMonth.atEndOfMonth());

        // 출력시 나오는 T는 ISO표기법이다.
        // String 타입을 LocalDateTime으로 파싱할 때 T가 없으면 예외가 발생한다.
        String err = "2021-05-31 09:41:54";
        LocalDateTime errTime = LocalDateTime.parse(err);
        System.out.println(errTime);// java.time.format.DateTimeParseException
    }
}