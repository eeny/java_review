import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam01 {
    public static void main(String[] args) {
        String[] str = {"Milk", "Bread", "Butter", "Cheese", "Ham"};
        // 현재 배열의 내용을 정렬하고
        // 정렬 후 Butter의 위치를 출력하기
        List<String> list = Arrays.asList(str);
        Collections.sort(list);
        System.out.println(list);// [Bread, Butter, Cheese, Ham, Milk]
        System.out.println("Butter의 위치는? " + list.indexOf("Butter"));
        // 정답 : 1
    }
}