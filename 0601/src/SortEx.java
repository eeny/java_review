import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEx {
    public static void main(String[] args) {
        // 방법1)직접 리스트 만들기
		/*ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("ccc");
		list.add("eee");
		list.add("zzz");
		list.add("kkk");*/

        // 방법2)배열을 리스트로 만들기
        String[] str = {"aaa", "ccc", "eee", "zzz", "kkk"};
        List<String> list = Arrays.asList(str);

        // 방법3)배열의 값을 리스트에 넣어서 리스트 만들기
		/*ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);// 이렇게 List로 만들 수도 있지만 비효율적
		}*/

        // sort() 매개 변수로는 반드시 List를 구현한 것이 들어가야 한다!
        Collections.sort(list);

        System.out.println(list);
    }
}