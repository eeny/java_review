import java.util.ArrayList;
import java.util.Collections;

public class SearchEx {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("ee");
        list.add("cc");
        list.add("dd");

        // 이진 탐색은 반드시 list의 내용이 정렬되어 있어야 한다!
        // 정렬 안된 list로 탐색을 하면 반환값으로 음수가 나온다!
        System.out.println(Collections.binarySearch(list, "dd"));
        // -3
    }
}