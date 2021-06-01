import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // 만약 전역변수가 private이라면 getter, setter 메서드 필수!
}

// 버그! 책 목록이 하나도 없을 때 삭제, 수정, 검색 등을 실행하면 발생하는 에러 처리를 안했음!
public class BookManger {
    ArrayList<Book> al;// Book 객체를 담는다 => new Book() <=을 add 해서 추가
    Scanner sc;

    public BookManger() {
        al = new ArrayList<>();
        sc = new Scanner(System.in);
        startProgram();
    }

    void startProgram() {
        while (true) {
            System.out.println("1.책입력 2.책삭제 3.책수정 4.책목록 5.책검색(번호로) 6.종료");
            int menu = sc.nextInt();
            if (menu==1) {
                insertBook();
            } else if (menu==2) {
                removeBook();
            } else if (menu==3) {
                setBook();
            } else if (menu==4) {
                listBook();
            } else if (menu==5) {
                seletBook();
            } else if (menu==6) {
                exitProgram();
            }
        }
    }

    void insertBook() {
        System.out.print("제목 : ");
        String title = sc.next();
        System.out.print("저자 : ");
        String author = sc.next();
        System.out.print("가격 : ");
        int price = sc.nextInt();

        Book b = new Book(title, author, price);
        al.add(b);// add()를 하면 자동으로 0부터 인덱스가 부여된다!
    }

    void removeBook() {
        System.out.print("지울 책 번호 : ");
        int idx = sc.nextInt();
        al.remove(idx);
    }

    void setBook() {
        System.out.print("수정할 책 번호 : ");
        int idx = sc.nextInt();
        Book b = al.get(idx);

        System.out.print("수정할 제목 : ");
        String title = sc.next();
        System.out.print("수정할 저자 : ");
        String author = sc.next();
        System.out.print("수정할 가격 : ");
        int price = sc.nextInt();

        // Book의 전역변수들이 private이 아니라서 직접 접근이 가능하다!
        b.title = title;
        b.author = author;
        b.price = price;
    }

    void listBook() {
        for (int i = 0; i < al.size(); i++) {
            Book b = al.get(i);
            System.out.println(b.title + " " + b.author + " " + b.price);
        }
    }

    void seletBook() {
        System.out.print("책 번호 입력 : ");
        int idx = sc.nextInt();

        Book b = al.get(idx);
        System.out.println(b.title + " " + b.author + " " + b.price);
    }

    void exitProgram() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new BookManger();
    }
}