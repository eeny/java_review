import java.util.Scanner;

class Book{
    private String title;
    private int price;
    private double weight;

    Book(String title, int price, double weight){
        this.title = title;
        this.price = price;
        this.weight = weight;
    }

    void setTitle(String title){
        this.title = title;
    }

    String getTitle(){
        return title;
    }

    void setPrice(int price){
        this.price = price;
    }

    int getPrice(){
        return price;
    }

    void setWeight(double weight){
        this.weight = weight;
    }

    double getWeight(){
        return weight;
    }

    void printBook(){
        System.out.println(title + "/" + price + "원/" + weight + "kg");
    }
}

public class BookManager2 {
    //Book[]과 Scanner를 전역변수로 빼서 다른 메서드에서도 사용 가능하다!
    //생성할 때 같이 메모리에 올라간다.
    Scanner sc = new Scanner(System.in);
    Book[] books;

    BookManager2(){
        books = new Book[10];

        for(int i=0; i<books.length; i++){//NullPointerException 방지하는 실행문
            books[i] = new Book("비었음", 0, 0.0);//일단 모든 Book안에 초기값을 줘버린다!!!
        }

        //sc = new Scanner(System.in);
    }

    void insertBook(int idx){//idx는 입력될 배열의 번호
        System.out.print("책 제목을 입력해주세요: ");
        String title = sc.next();
        System.out.print("책 가격을 입력해주세요: ");
        int price = sc.nextInt();
        System.out.print("책 무게를 입력해주세요: ");
        double weight = sc.nextDouble();

        //books[idx] = new Book(title, price, weight);

        //초기값을 생성하는게 아니라 바꿔야한다!!!
        //저렇게 새로 생성해도 상관은 없지만 이미 위에서 초기화를 하면서 메모리를 차지했는데,
        //새롭게 new를 하면 위에 만든 메모리 따로 새로 생성된 메모리 따로 차지하게 돼서 메모리 낭비가 된다!
        //효율적으로 메모리를 운용하기 위해서 이미 생성된 메모리 안에서 값만 바꿔주는 메서드를 사용한다!

        books[idx].setTitle(title);
        books[idx].setPrice(price);
        books[idx].setWeight(weight);
    }

    void selectBook(int idx){//이미 책이 있다고 가정하고, 있는 책의 내용을 출력
        books[idx].printBook();
    }

    void deleteBook(int idx){
        books[idx].setTitle("");
        books[idx].setPrice(0);
        books[idx].setWeight(0.0);
    }

    void startManager(){
        while(true){
            System.out.println("메뉴를 입력하세요.");
            System.out.print("(1)책입력 (2)책검색 (3)책삭제 (0)종료 : ");
            int menu = sc.nextInt();

            if(menu == 0){
                System.out.println("종료됩니다.");
                break;
            }

            System.out.print("책번호를 입력하세요: ");
            int idx = sc.nextInt();

            if(menu == 1){
                insertBook(idx);
            }else if(menu == 2){
                selectBook(idx);
            }else if(menu == 3){
                deleteBook(idx);
                System.out.println("삭제되었습니다.");
            }else {
                System.out.println("잘못 입력된 숫자입니다.");
            }
        }
    }

    public static void main(String[] args){
        BookManager2 bm = new BookManager2();
        bm.startManager();
    }
}
