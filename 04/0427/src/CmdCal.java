import java.util.Scanner;

public class CmdCal {
    int x, y;//산술할 변수 2개
    int result;//연산 결과
    double divResult;//나누기 연산 결과
    String str;//산술 기호 변수

    void start(){//계산기 작동
        Scanner sc = new Scanner(System.in);
        System.out.println("===cmd 계산기===");
        System.out.print("첫번째 숫자를 입력하세요: ");
        x = sc.nextInt();
        System.out.print("산술식을 입력하세요(+ - * / %): ");
        str = sc.next();
        System.out.print("두번째 숫자를 입력하세요: ");
        y = sc.nextInt();

        switch (str){
            case "+": plus(x, y); break;
            case "-": minus(x, y); break;
            case "*": multiply(x, y); break;
            case "/": divide(x, y); break;
            case "%": mod(x, y); break;
            default:
                System.out.println("잘못된 입력");
        }

        if (str.equals("/")) {//나누기 연산은 소수점이 나올 수도 있어서 따로 출력했다
            divResult();
        } else {
            result();
        }

        System.out.println("1.계속 2.중지");
        int c = sc.nextInt();
        if (c==1) {
            start();
        } else {
            System.out.println("계산기가 꺼집니다.");
        }
    }
    int plus(int a, int b){//더하기
        result = a + b;
        return result;
    }
    int minus(int a, int b){//빼기
        result = a - b;
        return result;
    }
    int multiply(int a, int b){//곱하기
        result = a * b;
        return result;
    }
    double divide(double a, double b){//나누기
        divResult = a / b;
        return divResult;
    }
    int mod(int a, int b){//나머지
        result = a % b;
        return result;
    }
    void result(){//결과 출력
        System.out.println("결과는 " + result);
    }
    void divResult(){//나누기 연산 결과 출력
        System.out.println("결과는 " + divResult);
    }

    public static void main(String[] args) {
        CmdCal cc = new CmdCal();
        cc.start();
    }
}
