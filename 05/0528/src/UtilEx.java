import java.util.Arrays;
import java.util.List;

public class UtilEx {// p492 설명
    public static void main(String[] args) {
        String[] str = {"1", "2", "3", "4", "5", "6"};
        List<String> list = Arrays.asList(str);
        for (String s : list) {
            System.out.println(s);
        }
        // Arrays.asList();
        // List : 사용하기 편한 배열
        // Arrays.asList : 배열을 리스트로 변환한다.


        int[] i = new int[10];// 0 ~ 9 까지 변수를 담을 수 있는 배열 생성
        Arrays.fill(i, 5); // 배열의 모든 부분을 5로 채운다.
        // Arrays.fill : 배열의 모든 부분을 입력한 숫자로 채운다.

        // Arrays.sort()
        // 배열의 값을 정렬해서 차례로 넣는다.

        int[] j = {1, 2, 5, 9};
        Arrays.binarySearch(j, 5);
        // Arrays.binarySearch(배열, 찾을 값)
        // 배열에서 찾을 값이 배열 안에서 몇 번째인지 찾는다.
        // 위의 예에서는 j[2]번째에 있으므로 값을 출력하면 2가 나온다!
    }
}