import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Collections 클래스가 제공하는 기타 메소드들
public class EtcEx {
    public static void main(String[] args) {// p571 참고
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(12);
        list.add(3);

        // min(), max()
        // 리스트에서 최대값, 최소값 찾기
        System.out.println(Collections.max(list));// 12
        System.out.println(Collections.min(list));// 1

        // reverse()
        // 리스트의 원소 순서를 반대로 하기
        //Collections.reverse(list);
        System.out.println(list);// [3, 12, 7, 4, 1]

        // fill()
        // 지정된 값으로 리스트 채우기
        //Collections.fill(list, 999);
        System.out.println(list);// [999, 999, 999, 999, 999]

        // copy()
        // 목적 리스트와 소스 리스트를 받아서 소스를 목적지로 복사하기
        // 목적 리스트.size()가 소스 리스트.size()보다 작으면 에러 발생
        Integer[] i = {100, 300, 500, 700, 900};
        List<Integer> srcList = Arrays.asList(i);
        //Collections.copy(list, srcList);
        System.out.println(list);// [100, 300, 500, 700, 900]

        // swap()
        // 리스트의 지정된 위치의 원소들을 서로 바꾸기
        //Collections.swap(list, 0, 3);
        System.out.println(list);// [12, 4, 7, 1, 3]

        // addAll()
        // 컬렉션 안의 지정된 모든 원소들을 추가하기
        //Collections.addAll(list, 123, 456, 789);
        System.out.println(list);// [1, 4, 7, 12, 3, 123, 456, 789]

        // frequency()
        // 지정된 컬렉션에서 지정된 원소가 얼마나 많이 등장하는지 반환하기
        Integer[] j = {1, 2, 3, 1, 3, 5, 7, 3, 8, 8};
        List<Integer> list2 = Arrays.asList(j);
        System.out.println(Collections.frequency(list2, 3));// 3

        // disjoint()
        // 두 개의 컬렉션이 겹치지 않는지 검사하기
        // (두 개의 컬렉션을 비교해서 일치하는 값이 하나도 없으면 true, 하나라도 있으면 false)
        Integer[] compare1 = {111, 4444, 777, 122, 33};
        Integer[] compare2 = {30, 12, 70, 40, 10};
        List<Integer> cplist1 = Arrays.asList(compare1);
        List<Integer> cplist2 = Arrays.asList(compare2);
        System.out.println(Collections.disjoint(list, cplist1));// true
        System.out.println(Collections.disjoint(list, cplist2));// false
    }
}