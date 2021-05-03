import java.util.Scanner;

class DiceGame{//주사위를 굴려 나온 값 맞추기
    int diceFace;
    int userGuess;

    private void RollDice(){//7. 주사위 굴려서 나온 값 diceFace변수에 저장
        diceFace = (int)(Math.random() * 6) + 1;//Math.random()은 0.0 ~ 0.999... 난수값 발생
    }
    private int getUserInput(String prompt){//3. 유저 화면에서 예상값을 물어보고 입력한 값을 넘긴다
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextInt();//4. 입력값을 바로 넘긴다
    }
    private void checkUserGuess(){//9. 예상값이랑 주사위 굴려서 나온 값이랑 일치하는 지 확인 후 결과가 출력된다!
        if(diceFace == userGuess){
            System.out.println("맞았습니다");
        }else{
            System.out.println("틀렸습니다");
            System.out.println("정답은? " + diceFace);
        }
    }
    public void startPlaying(){//2. 게임 시작하기
        userGuess = getUserInput("예상값을 입력하시오: ");//5.넘어온 값을 userGuess변수에 저장
        RollDice();//6. 주사위 굴리기
        checkUserGuess();//8. 두 값 일치 확인 메서드 호출
    }
}

public class DiceGameTest {
    public static void main(String[] args) {
        DiceGame game = new DiceGame();//객체부터 생성!
        game.startPlaying();//1. 게임 시작하기 메서드 호출
    }
}
