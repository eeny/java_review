import java.util.Scanner;

public class Year {
    //윤년인지 아닌지 계산하기
    //4로 나눠 떨어지고 100으로 나눠 떨어지거나, 400으로 나눠 떨어지면 윤년이다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int year;//입력받을 연도

        System.out.println("연도를 입력하세요: ");
        year = sc.nextInt();

        if(((year%4)==0 && (year%100)==0) || (year%400)==0){
            System.out.println("윤년입니다.");
        } else{
            System.out.println("윤년이 아닙니다.");
        }
    }

}
