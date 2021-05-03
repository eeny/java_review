import java.util.Scanner;

public class Mathematics2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //소금물의 농도 = (소금의 양 / 소금물의 양) * 100
        int salt; //소금의 양
        int saltWater; //소금물의 양

        System.out.print("소금의 양은? ");
        salt = sc.nextInt();
        System.out.print("소금물의 양은? ");
        saltWater = sc.nextInt();

        int result1 = salt / saltWater * 100;

        System.out.println("소금물의 농도는 " + result1);

        //부채꼴 호의 길이 = 2 * 원주율 * 원의 반지름 * 부채꼴 중심각 / 360
        int s; //부채꼴의 넓이
        int r; //원의 반지름
        int x; //부채꼴의 중심각
        double PI = 3.14; //원주율

        System.out.print("부채꼴의 넓이는? ");
        s = sc.nextInt();
        System.out.print("원의 반지름은? ");
        r = sc.nextInt();
        System.out.print("부채꼴의 중심각은? ");
        x = sc.nextInt();

        double result2 = (2 * PI * r * x / 360);

        System.out.println("부채꼴 호의 길이는 " + result2);

        //부채꼴 넓이 = 원주율 * 원의 반지름 제곱 * 부채꼴 중심각 / 360
        double result3 = PI * r * r * x / 360;

        System.out.println("부채꼴 넓이는 " + result3);

        //속력 = 거리 / 시간
        int distance = 0; //거리(m)
        int time = 0; //시간(s)

        System.out.print("거리는?(m) ");
        distance = sc.nextInt();
        System.out.print("시간은?(s) ");
        time = sc.nextInt();

        int result4 = distance / time;

        System.out.println("속력은 " + result4);

        //속도 = 변위 / 시간
        int displacement = 0; //변위

        System.out.print("변위는? ");
        displacement = sc.nextInt();

        int result5 = displacement / time;

        System.out.print("속도는? " + result5);
    }
}
