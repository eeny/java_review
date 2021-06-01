// Box클래스를 참조한다!
public class BoxTest {
    public static void main(String[] args) {
        // 어떤 타입을 넣어도 가능하다!
        // 앞에만 제네릭 타입을 적어주면 뒤에는 안적어도 된다!
        Box<String> b = new Box<>();

        Box<Integer> b2 = new Box<>();
        b2.set(123);
        System.out.println(b2.get());
    }
}