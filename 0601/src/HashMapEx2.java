import java.util.HashMap;
import java.util.Map;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1111", "짱보리");
        map.put("5555", "쌀보리");
        map.put("8888", "빵보리");

        // Map을 출력
        System.out.println(map);// {1111=짱보리, 5555=쌀보리, 8888=빵보리}

        // Key를 이용해 Value를 가져온다!
        System.out.println(map.get("5555"));// 쌀보리

        // Map 전체 내용 출력하기(!!!중요!!!)
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + ":" + s.getValue());
        }
    }
}