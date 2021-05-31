import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorEx {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);al.add(1);al.add(1);al.add(1);al.add(1);al.add(1);
		
		/*for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}*/

        int i = 0;
        Iterator<Integer> e = al.iterator();// 반복자
        // 반복자? while 타입으로 바꿀 때 쓴다.
        // while 타입? ~가 있을 때까지 반복한다는 뜻
        // for문은 몇 개까지 반복이지만 while은 있을 때까지 라서 개수를 신경 안써도 된다.
        // al.iterator()로 하면 Collection이 반복자 형태가 된다.
        while(e.hasNext()) {
            System.out.println(e.next());
        }
        // while문의 조건으로 hasNext()의 의미는 "값이 있다면~" 이라고 해석하면 된다.
        // next()는 hasNext()에서 말한 "값이 있다면~" 이후에 하나를 가져온다.

        String[] str = {"aa", "bb", "cc"};
        // 배열을 List로 바꾸기

        List<String> list = Arrays.asList(str);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
    }
}