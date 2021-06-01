import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleEx {
    public static void main(String[] args) {
        // 방법1)
        //		<int> 는 안된다!
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 배열이 필요한 것이 아니라 받아온 값이 배열이라서 어쩔 수 없이 사용한다!
        // 우리가 필요한 건 List를 구현한 어떤 객체든지 가능하다!
        Collections.shuffle(list);

        // 방법2)
        Integer[] i = {1, 2, 3, 4, 5};
        List<Integer> list2 = Arrays.asList(i);

        Collections.shuffle(list2);

        System.out.println(list);// 실행할 때마다 순서가 섞인다!
        System.out.println(list2);
    }
}