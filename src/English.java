import java.util.Scanner;

public class English {
    //알파벳 1개 입력받아서 모음인지 자음인지 출력하기
    //모음 : a, e, i, o, u
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char a;//알파벳

        System.out.print("알파벳 1개 입력 : ");
        a = sc.next().charAt(0);//문자열에서 첫번째 문자 꺼내오기
        //Scanner는 문자를 입력받는 기능이 없다!

        if(a == 'a'){
            System.out.println("모음");
        }else if(a == 'e'){
            System.out.println("모음");
        }
        else if(a == 'i'){
            System.out.println("모음");
        }
        else if(a == 'o'){
            System.out.println("모음");
        }
        else if(a == 'u'){
            System.out.println("모음");
        }else{
            System.out.println("자음");
        }
    }
}
