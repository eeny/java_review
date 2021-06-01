import java.util.HashMap;

class Student2 {// 예시 2
    String name;
    int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class HashMapEx {
    public static void main(String[] args) {
        // HashMap<Key, Value> map = new HashMap<>();
        // list는 값만 넣으면 자동으로 숫자가 붙는다.
        // 그래서 순서가 있다.
        // 하지만 Map은 key로 접근이 가능한 타입이다.
        // 그래서 순서가 없다.
        // 순서(번호 - int)가 없으므로 for문을 쓸 수 없다!

        // 예시 1
        HashMap<String, String> map = new HashMap<>();
        map.put("이름", "짱보리");
        map.put("주소", "부산 해운대구");
        map.put("아이디", "zzangbory");

        System.out.println(map.get("이름"));// 짱보리

        // 예시 2
        HashMap<String, Student2> map2 = new HashMap<>();
        Student2 st1 = new Student2("짱제니", 1);
        Student2 st2 = new Student2("댕댕이", 2);
        Student2 st3 = new Student2("냥냥이", 3);

        map2.put("202001", st1);
        map2.put("202002", st2);
        map2.put("202003", st3);

        Student2 ss = map2.get("202001");// 만들어진 new Student("짱제니", 1);를 가져온다.
        // get으로 가져온 객체의 타입은? st1을 가져오므로 Student타입!

        System.out.println(ss.age);
        System.out.println(ss.name);
        // System.out.println(st1.age);
        // System.out.println(st1.name);
        // 하는 것과 같다!
    }
}