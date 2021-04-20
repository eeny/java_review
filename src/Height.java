import java.util.Scanner;

public class Height {
    //cm로 입력받은 키를 피트와 인치로 변환하는 프로그램 만들기
    //1피트는 12인치이고 1인치는 2.54cm 이다
    public static void main(String[] args) {

        //내 코드
        Scanner scan = new Scanner(System.in);

        //처음 실패한 코드
        /*double inch = 2.54;
        double feet = 12 * inch;

        System.out.println("키 입력 : ");
        double height = scan.nextInt();

        System.out.println(height + "cm는 " + (height/feet) + "피트"
                + (height/inch) + "인치 입니다.");*/

        //두번째 코드
        System.out.println("키 입력 : ");
        int height = scan.nextInt();//cm
        double inch = height / 2.54;//inch
        int feet = (int)(inch / 12);//inch
        double modInch = inch % feet;

        System.out.println(height + "cm는 " + feet + "피트 " + modInch + "인치입니다.");

        //은주 코드
        /*Scanner sc = new Scanner(System.in);

        int cm; //163cm
        int feet;   //1feet = 12inch
        double inch;    //1inch = 2.54cm

        System.out.println("키를 입력하세요 : ");
        cm = sc.nextInt();
        inch = cm/2.54;
        feet = (int)inch/12;
        inch = inch - feet * 12;

        System.out.println(cm + "cm는 " + feet + "피트"
                + inch + "인치 입니다.");*/

        //정현 코드
        /*Scanner s = new Scanner(System.in);

        System.out.println("키를 입력해주세요 : ");
        int height = s.nextInt();

        int feet = (int) ((int)height/(12*2.54));
        double inch = (height - (12*2.54*feet))/2.54;

        System.out.println(height + "cm는 " + feet + "피트"
                + inch + "인치 입니다.");*/

        //선생님 풀이
        /*Scanner sc = new Scanner(System.in);

        System.out.println("키를 입력하세요 (cm)");
        int height = sc.nextInt();

        //1피트는 12인치이고 1인치는 2.54cm
        double inch = height / 2.54;
        System.out.println("인치는 " + inch);//64.xxxx
        //inch를 feet로 바꾸면 된다
        double feet = inch / 12;//피트
        double modinch = inch % 12;//나머지 인치
        //System.out.println("피트는 " + feet);//5.xxxx
        //System.out.println("나머지 인치는 " + modinch);//4.xxxx

        System.out.println((int)feet + "피트 " + modinch + "인치");
        //(int)는 강제 형변환이다. 아니면 printf 써야한다.*/

    }
}
