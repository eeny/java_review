import java.util.Scanner;

public class HighLowGame2 {
    int result;// 자동 생성된 값 // 1번만 실행되서 맞을때 까지 계속 유지
    int input;// 내가 입력한 값 // 계속 입력 받고 그때 마다 random과 비교할 값

    void makeRandom(){ // 랜덤값을 만들어서 전역변수인 random에 값 집어넣는 메서드
        double ran = Math.random();
        result = ((int)(ran*10))+1;
        // 랜덤 뽑기
    }

    void startText(){
        System.out.println("=== 숫자 맞추기 게임 ===");
        // 처음 시작시 출력
    }

    int inputNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        int num = sc.nextInt();
        // 입력받기

        return num;
    }

    void checkResult(){
        while(true){
            int x = inputNum();
            // num
            if(result>x){
                System.out.println("더 큰 숫자를 입력하세요");
            }else if(result<x){
                System.out.println("더 작은 숫자를 입력하세요");
            }else{
                System.out.println("정답입니다.");
                break;
            }
        }
        // 비교하기
    }

    void startGame(){
        startText();
        makeRandom();
        checkResult();
    }

    public static void main(String args[]){
        HighLowGame2 hlg = new HighLowGame2();
        hlg.startGame();
    }
}
