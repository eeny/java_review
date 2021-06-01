import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizerEx {// p502 3번 예제 샘 풀이
    public static void main(String[] args) {
        System.out.println("문자열을 입력해 주세요: ");
        Scanner sc = new Scanner(System.in);
        // System.in은 키보드로부터 입력받겠다는 뜻.

        // 만약, File을 쓰면 파일로부터 읽어올 수도 있다!
		/*File f = new File("test.txt");
		try {
			Scanner sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/

        String str = sc.nextLine();// 한 줄을 입력받겠다~
        StringTokenizer st = new StringTokenizer(str, " ");

        // 샘 코드에서는 배열에 값이 안들어간다!
		/*int i = 0;
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
			i++;
		}
		// 배열로 만들기
		int j = 0;
		String[] strs = new String[i];// 이미 이전에 한 바퀴 돌아서 더이상 내용이 없다
		while (st.hasMoreTokens()) {
			strs[j] = st.nextToken();
			
			j++;
		}*/

        // 내가 수정한 코드
        int i = 0;
        String[] strs = new String[st.countTokens()];
        while (st.hasMoreTokens()) {
            strs[i] = st.nextToken();
            i++;
        }

        Arrays.sort(strs);

        for (int k = 0; k < strs.length; k++) {
            System.out.println(strs[k]);
        }
    }
}