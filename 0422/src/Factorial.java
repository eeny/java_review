import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        //입력받은 숫자까지의 곱 구하기
        //입력이 5인 경우 1*2*3*4*5 값이 출력된다
        Scanner sc = new Scanner(System.in);
		/*
		System.out.print("정수를 입력: ");
		int num = sc.nextInt();

		int total = 1;//팩토리얼 결과

		for(int i = 1; i <= num; i++){
			total *= i;
		}
		System.out.println(num + "의 팩토리얼 값은 " + total);
		*/

        //선생님 답안
        System.out.print("숫자를 입력: ");
        int x = sc.nextInt();

        long fac=1;// !5 처럼 팩토리얼이 표시된다 원래...
        //숫자가 크면 int범위를 넘어서므로 long타입으로 함!
        for(int i=1; i<=x; i++){
            fac = fac*i;
        }

        System.out.println(fac);
    }
}
