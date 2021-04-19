import java.util.Scanner;

public class NameAndAge {
    //이름과 나이를 입력받아 출력하는 프로그램 만들기
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);

        System.out.println("이름: ");
        String name = scan.next();
        System.out.println("나이: ");
        int age = scan.nextInt();

        System.out.println("이름은 " + name + "이고, 나이는 " + age + "입니다.");
    }
}
