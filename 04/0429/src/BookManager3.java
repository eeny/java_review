import java.util.Scanner;

public class BookManager3 {
    String title;
    int price;
    double weight;

    BookManager3(String title, int price, double weight){
        this.title=title;
        this.price=price;
        this.weight=weight;
    }

    void printBook(){
        System.out.println(title+" "+ price+" "+weight);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BookManager3[] bm = new BookManager3[3];// BookManager3를 담는 변수 3개

        for(int i=0; i<3; i++){
            System.out.println("책제목을 입력하세요: ");
            String t=sc.next();
            System.out.println("가격을 입력하세요: ");
            int p=sc.nextInt();
            System.out.println("무게를 입력하세요: ");
            double w=sc.nextDouble();
            bm[i] = new BookManager3(t,p,w);//값을 가진 덩어리의 배열
        }

        for(int i=0; i<3; i++){
            bm[i].printBook();
        }
    }
}
