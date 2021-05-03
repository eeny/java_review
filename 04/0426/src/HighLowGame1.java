import java.util.Scanner;

class HighLowGame{
    int result;//랜덤 숫자
    int x;//내 예상 숫자

    private int randomNum(){//랜덤으로 숫자 뽑기
        result = (int)(Math.random()*10) + 1;//1 ~ 10
        return result;
    }
    private int userInput(){//사용자에게 입력받기
        System.out.print("숫자를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        return x;
    }
    private void checkNum(){//어느 숫자가 더 큰 지 알려주기
        while(true){
            if(result > x){
                System.out.println("더 큰 값을 입력하세요 ");
                userInput();
            }else if(result < x){
                System.out.println("더 작은 값을 입력하세요 ");
                userInput();
            }else{
                System.out.println("정답입니다!");
                break;
            }
        }
    }
    public void startGame(){//게임을 시작하기
        System.out.println("===숫자 맞추기 게임===");
        userInput();//x 생성
        randomNum();//result 생성
        checkNum();
    }
}

public class HighLowGame1 {
    public static void main(String[] args) {
        //랜덤 공식
        //double ran = Math.random();

        //0~0.999999999999 // 0부터 1미만의 랜덤수
        //1~10사이의 랜덤을 만들어보자
        //ran*10; //0.0~9.99999
        //(int)(ran*10); //0~9
        //((int)(ran*10))+1; //1~10

		/*
		int result = ((int)(ran*10))+1;

		Scanner sc = new Scanner(System.in);

		System.out.println("=== 숫자 맞추기 게임 ===");

		while(true){//무한반복
			System.out.println("숫자를 입력하세요 : ");
			int x = sc.nextInt();

			if(result > x){
				System.out.println("더 큰 숫자를 입력하세요 : ");
			}else if(result < x){
				System.out.println("더 작은 숫자를 입력하세요 : ");
			}else{
				System.out.println("정답입니다!");
				break;//반복문 강제 종료
			}
		}
		*/

        //HighLowGame 클래스를 위에 만들어서 메서드화 시켜보기~
        //선생님 풀이는 HighLowGame2에 있음!!!
        HighLowGame hg = new HighLowGame();
        hg.startGame();
    }
}
