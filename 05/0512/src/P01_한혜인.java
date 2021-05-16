import java.util.Scanner;

public class P01_한혜인 {//첫 번째 시험
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (;;) {
            System.out.println("구구단을 출력하고 싶은 숫자를 입력하세요.");
            int num = sc.nextInt();

            if (num>9) {
                System.out.println("잘못된 입력입니다. 더 작은 수를 입력하세요!");
                continue;
            } else if (num<2) {
                System.out.println("잘못된 입력입니다. 더 큰 수를 입력하세요!");
                continue;
            } else {
                for (int i = 1; i < 10; i++) {
                    System.out.println(num + " * " + i + " = " + (num*i));
                }

                System.out.println("그만하시겠습니까? (1)네");
                int x = sc.nextInt();
                if (x==1) {
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}