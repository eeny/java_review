
public class StringTest {
    public static void main(String[] args) {
        String str = "안녕 콜라 사이다 반갑 콜라";

        //str.substring(시작위치, 끝위치) - 정수 2개 입력해야함!

        System.out.println(str.substring(0, 5));
        // 안녕 콜라
        System.out.println(str.indexOf("사이다"));
        // 6
        System.out.println(str.indexOf("콜라"));
        // 3
        System.out.println(str.lastIndexOf("콜라"));
        // 13
        System.out.println(str.substring(0, str.lastIndexOf("콜라")));
        // 안녕 콜라 사이다 반갑
    }
}
