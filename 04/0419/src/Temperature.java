import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("화씨 온도를 입력하세요.");
        double fahrenheit = scan.nextDouble();

        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("섭씨 온도로 " + celsius + "도 입니다.");
    }
}
