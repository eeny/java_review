import java.util.HashMap;
import java.util.Map;

public class WordFreq {// p565 예제
    public static void main(String[] args) {
        // Map객체 생성
        Map<String, Integer> m = new HashMap<String, Integer>();

        String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};

        // 문자열에 포함된 단어의 빈도 계산하는 for-each문
        for (String a : sample) {
            Integer freq = m.get(a);// 첫실행시 m.get(a)의 값은? null
            // Integer는 래퍼클래스라서 null값이 들어갈 수 있다!

            // 여기서부터 Key값을 넣는다!
            // 단어를 꺼내서 빈도를 증가시킨다!
            m.put(a, (freq == null) ? 1 : freq + 1);
            // 	Key,	Value
            // to, 1
            // be, 1
            // or, 1
            // ...
            // to, 2
            // be, 2
            // ...
            // 전체 다 실행하고 나면 실제 m안의 객체 개수는? 7개(중복을 제거했으므로)
        }

        System.out.println(m.size() + " 단어가 있습니다.");
        // 7 단어가 있습니다.
        System.out.println(m.containsKey("to"));
        // true
        System.out.println(m.isEmpty());
        // false
        System.out.println(m);
        // {a=1, not=1, be=2, or=1, problem=1, is=1, to=2}
    }
}