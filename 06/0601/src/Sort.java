import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {// p567 예제
    public static void main(String[] args) {
        String[] sample = {"i", "walk", "the", "line"};
        // 배열을 리스트로 변경(정렬 알고리즘을 실행하기 위해서)
        List<String> list = Arrays.asList(sample);

        // 리스트에 들어있는 원소들을 순서대로 정렬한다!
        Collections.sort(list);

        System.out.println(list);
        // [i, line, the, walk]
    }
}