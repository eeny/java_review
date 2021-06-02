import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffle {// p569 예제
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i <= 10 ; i++) {
            list.add(i);
        }

        // 리스트에 존재하는 정렬을 파괴해서 원소들의 순서를 무작위로 만든다!
        Collections.shuffle(list);

        System.out.println(list);
        // [9, 5, 0, 3, 7, 2, 10, 4, 6, 1, 8]
        // [5, 8, 10, 0, 7, 6, 2, 1, 9, 3, 4]
        // 실행할 때 마다 바뀐다!
    }
}