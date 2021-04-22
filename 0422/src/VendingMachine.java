import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        /*
		자판기
		돈을 넣어주세요 : 1000
		음료를 골라주세요
		(1.콜라(500) 2.사이다(700) 3.환타(100)) : 1
		콜라 500원
		입금 1000원
		잔돈 500원
		=====================================
		돈을 넣어주세요 : 500
		음료를 골라주세요
		(1.콜라(500) 2.사이다(700) 3.환타(100)) : 2
		사이다 700원
		입금 500원
		돈이 부족합니다.
		*/
        Scanner sc = new Scanner(System.in);

        int coke = 1;//콜라
        int cider = 2;//사이다
        int fanta = 3;//환타

        System.out.print("돈을 넣어주세요(숫자만) : ");
        int money = sc.nextInt();
        System.out.println("1.콜라(500원) 2.사이다(700원) 3.환타(100원)");
        System.out.print("음료를 골라주세요(번호로) : ");
        int drink = sc.nextInt();

        if (drink == 1){
            coke = 500;
            if ((coke < money) || (coke == money)) {
                System.out.println("콜라 " + coke + "원");
                System.out.println("입금 " + money + "원");
                System.out.println("잔돈 " + (money-coke) + "원");
            } else {
                System.out.println("돈이 부족합니다.");
            }
        } else if (drink == 2){
            cider = 700;
            if (cider < money || (cider == money)) {
                System.out.println("사이다 " + cider + "원");
                System.out.println("입금 " + money + "원");
                System.out.println("잔돈 " + (money-cider) + "원");
            } else {
                System.out.println("돈이 부족합니다.");
            }
        } else if (drink == 3) {
            fanta = 100;
            if (fanta < money || (fanta == money)) {
                System.out.println("환타 " + fanta + "원");
                System.out.println("입금 " + money + "원");
                System.out.println("잔돈 " + (money-fanta) + "원");
            } else {
                System.out.println("돈이 부족합니다.");
            }
        } else {
            System.out.println("잘못 입력했습니다.");
        }
    }
}
