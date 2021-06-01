import java.util.ArrayList;
import java.util.Scanner;

class MyBook {
    // 책제목, 저자, 가격
    String title;
    String writer;
    int price;

    public MyBook(String title, String writer, int price) {
        this.title = title;
        this.writer = writer;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

public class MyBookManager {
    ArrayList<MyBook> arr = new ArrayList<>();
    MyBook b;
    Scanner sc = null;

    public MyBookManager() {
        start();
    }

    public void start() {
        sc = new Scanner(System.in);

        System.out.println("=== 도서 관리 프로그램 ===");

        while (true) {
            System.out.println("메뉴를 선택하세요.");
            System.out.print("1.책입력 2.책삭제 3.책수정 4.책목록 5.책검색(번호로) 6.종료 : ");

            int menu = sc.nextInt();

            if (menu==1) {// 책입력
                insertBook();

            } else if (menu==2) {// 책삭제
                deleteBook();

            } else if (menu==3) {// 책수정
                modBook();

            } else if (menu==4) {// 책목록
                printBook();

            } else if (menu==5) {// 첵검색
                searchBook();

            } else if (menu==6) {// 종료
                System.out.println("=== 프로그램 종료 ===");
                sc.close();
                System.exit(0);
            }
        }
    }

    // 책입력
    void insertBook() {
        System.out.print("책 제목 : ");
        String title = sc.next();
        System.out.print("책 저자 : ");
        String writer = sc.next();
        System.out.print("책 가격 : ");
        int price = sc.nextInt();

        b = new MyBook(title, writer, price);
        arr.add(b);

        System.out.println("책이 등록되었습니다.");
    }
    // 책삭제
    void deleteBook() {
        System.out.print("삭제할 책 번호를 입력하세요 : ");
        int num = sc.nextInt();

        if (arr.size() <= num) {
            System.out.println("해당하는 책이 없습니다.");
        } else {
            arr.remove(num);
            System.out.println("책이 삭제되었습니다.");
        }
    }
    // 책수정
    void modBook() {
        System.out.print("수정할 책 번호를 입력하세요 : ");
        int num = sc.nextInt();

        if (arr.size() <= num) {
            System.out.println("해당하는 책이 없습니다.");
        } else {
            System.out.print("책 제목 : ");
            String title = sc.next();
            System.out.print("책 저자 : ");
            String writer = sc.next();
            System.out.print("책 가격 : ");
            int price = sc.nextInt();

            b = new MyBook(title, writer, price);
            arr.set(num, b);
            System.out.println("책이 수정되었습니다.");
        }
    }
    // 책목록
    void printBook() {
        if (arr.isEmpty()) {
            System.out.println("등록된 책이 없습니다.");
        } else {
            int i = 0;
            for (MyBook b : arr) {
                System.out.println(i + "번 책 : " + b.getTitle() + "/" + b.getWriter() + "/" + b.getPrice());
                i++;
            }
        }
    }
    // 첵검색
    void searchBook() {
        System.out.print("검색할 책 번호를 입력하세요 : ");
        int num = sc.nextInt();

        if (arr.size() <= num) {
            System.out.println("해당하는 책이 없습니다.");
        } else {
            MyBook b = arr.get(num);
            System.out.println(num + "번 책 : " + b.getTitle() + "/" + b.getWriter() + "/" + b.getPrice());
        }
    }

    public static void main(String[] args) {
        new MyBookManager();
    }
}