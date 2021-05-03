import java.util.Scanner;

public class Calculator {
    //저금통에 있는 돈의 금액을 계산하는 프로그램
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("500원은 몇 개? ");
        int num1 = sc.nextInt();
        System.out.print("100원은 몇 개? ");
        int num2 = sc.nextInt();
        System.out.print("50원은 몇 개? ");
        int num3 = sc.nextInt();
        System.out.print("10원은 몇 개? ");
        int num4 = sc.nextInt();

        int sum = (500 * num1) + (100 * num2) + (50 * num3) + (10 * num4);
        System.out.println("총 " + sum + "원 입니다.");
    }
}
