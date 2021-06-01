import java.util.Scanner;
import java.util.StringTokenizer;

public class Page502Ex3 {// p502 3번 예제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하시오: ");
        String str = sc.nextLine();
        // The grass is greener on the other side of the fence.
        // 라는 위의 구문을 입력했을 때

        StringTokenizer st = new StringTokenizer(str);

        int strCnt = st.countTokens();// 11개(자르기 전에 값을 넣어야 개수를 센다!)

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        //int strCnt = st.countTokens();// 0개

        System.out.println("모두 " + strCnt + "개의 단어가 있습니다.");
    }
}