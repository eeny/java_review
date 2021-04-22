import java.util.Scanner;

public class Pressure {
    //압력의 세기 = 힘(kg) / 면적(제곱m)
    //파스칼 Pa = 1 제곱미터에 1N의 힘이 일정하게 미칠 때 압력의 세기
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("힘을 입력하세요. ");
        int power = sc.nextInt();

        System.out.print("면적을 입력하세요.");
        double area = sc.nextDouble();

        double Pa = power / area;
        System.out.println("파스칼 " + Pa + "입니다.");
    }
}
