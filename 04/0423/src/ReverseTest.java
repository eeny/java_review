import java.util.Scanner;

class Reverse{
    String rvStr;//거꾸로 된 문자열을 담는 변수
    void backward(String str){
        for(int i=str.length()-1; i>0; i--){//조건식 주의!
            rvStr="";
            rvStr += str.charAt(i);
            System.out.print(rvStr);
        }
    }
}

public class ReverseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Reverse rv = new Reverse();

        System.out.print("문자열을 입력하세요: ");
        String str = sc.next();
        rv.backward(str);
    }
}
