import java.util.Scanner;

public class BookManager {
    String title;
    int price;
    double weight;

    BookManager(){

    }

    BookManager(String title, int price, double weight){
        this.title = title;
        this.price = price;
        this.weight = weight;
    }

    void printBook(){
        System.out.println(title + " / " + price + "원 / " + weight + "kg");
    }

    void start(int size){
        Scanner sc = new Scanner(System.in);
        BookManager[] bm = new BookManager[size];

        for(int i=0; i<bm.length; i++){
            System.out.println("메뉴를 입력하세요");
            System.out.println("(1)책입력 (2)책검색 (3)책삭제 (0)종료");
            int num = sc.nextInt();

            if(num == 1){//책입력
                System.out.print("책번호를 입력하세요 : ");
                i = sc.nextInt();//배열의 번호
                System.out.print("책제목을 입력하세요 : ");
                title = sc.next();
                System.out.print("책가격을 입력하세요 : ");
                price = sc.nextInt();
                System.out.print("책무게를 입력하세요 : ");
                weight = sc.nextDouble();

                bm[i] = new BookManager(title, price, weight);

            }else if(num == 2){//책검색
                System.out.print("책번호를 입력하세요 : ");
                i = sc.nextInt();//배열의 번호

                bm[i].printBook();

            }else if(num == 3){//책삭제
                System.out.print("삭제할 책번호를 입력하세요 : ");
                i = sc.nextInt();//배열의 번호

                bm[i] = new BookManager("  ", 0, 0.0);
                System.out.println("삭제되었습니다.");

            }else{
                System.out.println("종료됩니다.");
                break;
            }
        }
    }

    public static void main(String[] args){
        BookManager b = new BookManager();
        b.start(10);//10권의 책
    }
}
