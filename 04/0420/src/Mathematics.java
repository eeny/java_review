import java.util.Scanner;

public class Mathematics {
    //6학년 수학 공식 프로그램
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a; //가로
        int b; //세로
        int c; //높이

        System.out.print("가로는? ");
        a = sc.nextInt();
        System.out.print("세로는? ");
        b = sc.nextInt();
        System.out.print("높이는? ");
        c = sc.nextInt();

        //직육면체의 겉넓이 = 밑넓이 * 2 + 옆넓이
        int result1 = (a * b) * 2 + ((a + a + b + b) * c);
        //정육면체의 겉넓이 = 한 면의 넓이 * 6
        int result2 = (a * b) * 6;
        //직육면체의 부피 = 가로 * 세로 * 높이
        int result3 = a * b * c;

        System.out.print("직육 겉넓이는 " + result1);
        System.out.print(" 정육 겉넓이는 " + result2);
        System.out.print(" 직육 부피는 " + result3);

        int r; //반지름
        double PI = 3.14; //원주율

        System.out.print("\n반지름은? ");
        r = sc.nextInt();

        //원주 = 반지름 * 2 * 3.14
        double result4 = r * 2 * PI;
        //원의 넓이 = 반지름 * 반지름 * 3.14
        double result5 = r * r * PI;

        System.out.print("원주는 " + result4);
        System.out.print(" 원의 넓이는 " + result5);
    }
}
