import java.util.Scanner;

class SameId {
    String id = "superman";//미리 저장된 아이디

    void same(String str) {//일치여부 확인하는 메서드
        if (id.equals(str)) {
            System.out.println("아이디가 일치합니다!");
        } else {
            System.out.println("아이디가 일치하지 않습니다!");
        }
    }
}

public class SameIdTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("아이디를 입력하세요: ");
        String str = sc.next();

        SameId si =new SameId();
        si.same(str);
    }
}
