import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        //숫자 3개 입력받아 정렬하기 (if문으로 크기 비교하면 된다)
        Scanner sc = new Scanner(System.in);
		/*
		System.out.print("첫번째 숫자 : ");
		int a = sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int b = sc.nextInt();
		System.out.print("세번째 숫자 : ");
		int c = sc.nextInt();

		if(a<b && b<c){//a<b<c 경우
			System.out.println(a + " " + b + " " + c);
		}else if(a<c && c<b){//a<c<b 경우
			System.out.println(a + " " + c + " " + b);
		}else if(a<b && b==c){//a이 작고 b, c이 같은 경우
			System.out.println(a + " " + b + " " + c);
		}else if(a>b && b==c){//a이 크고 b, c이 같은 경우
			System.out.println(b + " " + c + " " + a);
		}else if(b<a && a<c){
			System.out.println(b + " " + a + " " + c);
		}else if(b<c && c<a){
			System.out.println(b + " " + c + " " + a);
		}else if(b<a && a==c){
			System.out.println(b + " " + a + " " + c);
		}else if(b>a && a==c){
			System.out.println(a + " " + c + " " + b);
		}else if(c<a && a<b){
			System.out.println(c + " " + a + " " + b);
		}else if(c<b && b<a){
			System.out.println(c + " " + b + " " + a);
		}else if(c<a && a==b){
			System.out.println(c + " " + a + " " + b);
		}else if(c>a && a==b){
			System.out.println(a + " " + b + " " + c);
		}else{//숫자 3개 모두 같은 경우
			System.out.println(a + " " + b + " " + c);
		}
		*/

        //선생님 답안
        System.out.print("첫번째 숫자 : ");
        int x1 = sc.nextInt();
        System.out.print("두번째 숫자 : ");
        int x2 = sc.nextInt();
        System.out.print("세번째 숫자 : ");
        int x3 = sc.nextInt();

        int high = 0, middle = 0, low = 0;
        if(x1>x2 && x1>x3){
            high = x1;
            if(x2>x3){
                middle = x2;
                low = x3;
            }else{
                middle = x3;
                low = x2;
            }
        }else if(x2>x1 && x2>x3){
            high = x2;
            if(x1>x3){
                middle = x1;
                low = x3;
            }else{
                middle = x3;
                low = x1;
            }
        }else if(x3>x1 && x3>x2){
            high = x3;
            if(x1>x2){
                middle = x1;
                low = x2;
            }else{
                middle = x2;
                low = x1;
            }
        }

        System.out.println(low + " " + middle + " " + high);
    }
}
