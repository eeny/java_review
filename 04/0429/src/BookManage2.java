import java.util.Scanner;

class BookMan{
    int size;//배열길이
    String[] title;
    int[] price;
    double[] weight;

    //생성자
    BookMan(int size){
        this.size = size;
        title = new String[size];
        price = new int[size];
        weight = new double[size];
    }

    //메서드
    void startPro(){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<size; i++){
            System.out.println("책 제목을 입력하세요: ");
            title[i] = sc.next();
            System.out.println("가격을 입력하세요: ");
            price[i] = sc.nextInt();
            System.out.println("무게를 입력하세요: ");
            weight[i] = sc.nextDouble();
        }

        for(int i=0; i<title.length; i++){
            System.out.println(title[i] + "\t" + price[i] + "\t" + weight[i] + "kg");
        }
    }
}

public class BookManage2 {
    public static void main(String[] args){
        //아래의 코드를 효율적으로 바꿔보자~~!!!
        BookMan b = new BookMan(3);//배열길이를 3으로 초기화
        b.startPro();
		/*
		Scanner sc = new Scanner(System.in);

		int size = 5;

		String[] title = new String[size];
		int[] price = new int[size];
		double[] weight = new double[size];

		for(int i=0; i<size; i++){
			System.out.println("책 제목을 입력하세요: ");
			title[i] = sc.next();
			System.out.println("가격을 입력하세요: ");
			price[i] = sc.nextInt();
			System.out.println("무게를 입력하세요: ");
			weight[i] = sc.nextDouble();
		}

		for(int i=0; i<title.length; i++){
			System.out.println(title[i] + "\t" + price[i] + "\t" + weight[i] + "kg");
		}
		*/
    }

}
