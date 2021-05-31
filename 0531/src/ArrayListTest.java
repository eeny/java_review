import java.util.ArrayList;

public class ArrayListTest {// p551 예제
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("MILK");
        list.add("BREAD");
        list.add("BUTTER");
        list.add(1, "APPLE");// 인덱스 1에 "APPLE"을 추가한다. 해당 인덱스 뒤의 원소는 순서가 밀린다.
        list.set(2, "GRAPE");// 인덱스 2의 원소를 "GRAPE"로 대체한다.
        list.remove(3);// 인덱스 3의 원소를 삭제한다.
		
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/

        // ArrayList에 들어있는 데이터를 모두 출력하려면 for-each를 사용하는 편이 좋다!
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(list.indexOf("MILK"));// 0
    }
}