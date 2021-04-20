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

        //선생님 풀이
        /*Scanner sc = new Scanner(System.in);//키보드로 입력받기 위한 세팅

        System.out.print("이름을 입력하세요");//화면에 보이기만 하는 글씨

        //입력을 받는 위치
        String name = sc.next();//키보드로 문자열(긴문자) 받기

        System.out.print("나이를 입력하세요");

        int age = sc.nextInt();//키보드로 정수 받기

        //입력받은 값들이 name과 age에 다 들어있다.

        System.out.println("이름은 " + name + "이고 나이는 " + age + "입니다.");*/
    }
}
