import java.util.Scanner;

public class Height {
    //cm로 입력받은 키를 피트와 인치로 변환하는 프로그램 만들기
    //1피트는 12인치이고 1인치는 2.54cm 이다
    public static void main(String[] args) {

        //내 코드ㅠㅠ
        /*
        Scanner scan = new Scanner(System.in);

        double inch = 2.54;
        double feet = 12 * inch;

        System.out.println("키 입력 : ");
        double height = scan.nextInt();

        System.out.println(height + "cm는 " + (height/feet) + "피트"
                + (height/inch) + "인치 입니다.");
         */

        //은주 코드
        Scanner sc = new Scanner(System.in);

        int cm; //163cm
        int feet;   //1feet = 12inch
        double inch;    //1inch = 2.54cm

        System.out.println("키를 입력하세요 : ");
        cm = sc.nextInt();
        inch = cm/2.54;
        feet = (int)inch/12;
        inch = inch - feet * 12;

        System.out.println(cm + "cm는 " + feet + "피트"
                + inch + "인치 입니다.");

    }
}
