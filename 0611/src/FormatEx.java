public class FormatEx {
    public static void main(String[] args) {
        // d 정수 (10진수)
        // f 실수
        // n 엔터
        // x 16진수
        // s 문자열
        // tB 정수를 지역에 맞는 달 이름으로 출력

        int a = 10;
        float b = 20.0f;// f 안쓰면 double이 된다!
        int c = 11;
        String d = "abc";
        long e = 1l;

        System.out.format("정수는 %d, 실수는 %f, 한 줄 내리기 %n, 16진수는 %x, 문자열 %s, 월 %tB", a, b, c, d, e);
    }
}