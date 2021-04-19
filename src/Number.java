import java.util.Scanner;

public class Number {
    //2개의 정수를 입력받아 앞 숫자를 뒷 숫자로 나눈 값과 나머지를 출력하기
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("숫자 1 입력: ");
        int number1 = scan.nextInt();
        System.out.println("숫자 2 입력: ");
        int number2 = scan.nextInt();

        int devision = number1 / number2;
        int balance = number1 % number2;

        System.out.println(number1 + "을 " + number2 + "로 나눈 값은 " + devision + "이고, 나머지는 " + balance + "입니다.");
    }
}
