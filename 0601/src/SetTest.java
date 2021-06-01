import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {// p557 예제
    public static void main(String[] args) {
        // Set<String> set = new HashSet<>();
        // 이렇게 생성해도 되지만~
        // 이 경우에 실제 생성된 객체는 HashSet이지만, 담기는 변수가 Set타입이다!
        // set이라는 변수는 Set타입이 되므로 HashSet 안에 있는 메서드는 사용할 수 없다!
        // 왜? 담긴 변수가 Set타입이라서 Set이 들고 있는 메서드만 사용할 수 있다!
        // 그럼 굳이 이렇게 생성하는 이유는?
        // 만약에 Set<String> set; 처럼 전역 변수를 선언해두고
        // set = new HashSet<>();
        // set = new LinkedHashSet<>();
        // set = new TreeSet<>();
        // 이렇게 Set을 구현하는 여러 클래스를 한번에 각각 생성할 수 있기 때문이다!

        HashSet<String> set = new HashSet<>();
        // [Ham, Butter, Cheese, Milk, Bread]
        // => 마음대로 출력됨

        //LinkedHashSet<String> set = new LinkedHashSet<>();
        // [Milk, Bread, Butter, Cheese, Ham]
        // => 입력한 순서대로 출력됨

        //TreeSet<String> set = new TreeSet<>();
        // [Bread, Butter, Cheese, Ham, Milk]
        // => 정렬돼서 출력됨

        // add() 의 반환값은 true/false다.
        // 정확히 말하면 "중복"이 불가능하므로 중복된 내용을 추가할 시 false가 반환된다.
        // 중복된 내용이 아니라면 true가 반환된다.
        set.add("Milk");
        set.add("Bread");
        set.add("Butter");
        set.add("Cheese");
        set.add("Ham");
        set.add("Ham");

        System.out.println(set);
    }
}