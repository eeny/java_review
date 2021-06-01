import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search {// p571 예제
    public static void main(String[] args) {
        int key = 50;

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        // 이진 탐색하여 list에서 key의 위치를 반환한다.
        int index = Collections.binarySearch(list, key);

        System.out.println("탐색의 반환값 = " + index);
        // 탐색의 반환값 = 50
    }
}