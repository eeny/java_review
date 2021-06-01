import java.util.Vector;

public class VectorTest {// p545 예제
    public static void main(String[] args) {
        // Collection (모음)
        // Vector, ArrayList, HashMap, ...
        // 배열을 대체할 수 있다!

        // Vector객체를 생성할 때, 크기를 줘도 되고 안줘도 된다!
        Vector vc = new Vector();
        // 위의 구문은 Object[] obj = new Object[개수]; 와 같다!
        // 하지만 Collection은 생성시 개수가 필요없다. 자동으로 늘어난다!
        // obj[0] = "xxx"; 이런식으로 값을 넣을 필요가 없다!

        // Vector객체는 어떤 타입의 객체라도 추가할 수 있다!
        vc.add("Hello World!");
        vc.add(new Integer(10));
        vc.add(2.5);
        vc.add('e');

        System.out.println("vector size : " + vc.size());

        //				= obj.length 배열은 기초 타입이라서 메소드가 없다!
        for (int i = 0; i < vc.size(); i++) {
            System.out.println("vector element " + i + " : " + vc.get(i));
        }

        // get()은 Object타입을 반환하므로 형변환해서 사용할 수 있다!
        String s = (String)vc.get(0);
        System.out.println("s에 들어있는 값은? " + s);

        // =========================================
        // <제네릭>을 사용해서 Vector안에 담을 값의 타입을 강제할 수 있다!
        Vector<String> vv = new Vector<String>();

        // vv.add(1); 에러 발생!
        vv.add("가능");

        // 타입을 설정했기 때문에 get()할 때, 형변환할 필요가 없다!
        System.out.println("값 바로 출력 가능? " + vv.get(0));
    }
}