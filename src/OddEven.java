import java.util.Scanner;

public class OddEven {
    //입력받은 숫자가 홀수인지 짝수인지 출력하는 프로그램
    //삼항연산자 이용하기
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하세요.");
        int num = sc.nextInt();

        System.out.println(num % 2 == 0 ? "짝수!" : "홀수!");
    }
}
