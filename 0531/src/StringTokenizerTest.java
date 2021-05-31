import java.util.StringTokenizer;

public class StringTokenizerTest {// p496 예제
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("Will Java change my life?");
        while (st.hasMoreTokens()) {
            // 문자열을 토큰으로 분리하여 출력
            System.out.println(st.nextToken());
        }
    }
}