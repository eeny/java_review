import java.util.Scanner;

public class Bmi {
    //키와 몸무게를 입력받아 체지방률 출력하기
    //BMI 공식 = 몸무게(kg) / (키(m) * 키(m))
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("키는 몇 cm 인가요? ");
        double height = scan.nextDouble();
        System.out.println("몸무게는 몇 kg 인가요? ");
        double weight = scan.nextDouble();

        double bmi = weight / (height * height / 10000);

        System.out.println("체지방률은 : " + bmi + "입니다");
    }
}
