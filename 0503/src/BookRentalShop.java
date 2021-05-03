import java.util.Scanner;

class Book{
    private String title;
    private String writer;
    private int price;
    private int isbn;
    //private 다른 클래스에서 접근이 안된다 => getter / setter 필수(모든 변수 다 만들어야하는 건 아님!)

    Book(String title, String writer, int price, int isbn){
        this.title = title;//this를 붙이면서 필드에 있는 변수로 취급된다!
        this.writer = writer;
        this.price = price;
        this.isbn = isbn;
    }

    String getTitle(){
        return title;
    }


    void printAll(){
        System.out.println(title + "/" + writer + "/" + price + "/" + isbn);
    }
}

class Member{
    private String name;
    private String phone;
    private String addr;
    private String id;

    Member(String name, String phone, String addr, String id){
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.id = id;
    }

    String getName(){
        return name;
    }

    String getPhone(){
        return phone;
    }

    void printAll(){
        System.out.println(name + "/" + phone + "/" + addr + "/" + id);
    }
}

class Rental{
    String date;//String은 참조형이지만 특수케이스라서 일반 변수처럼 사용할 수 있다!
    String name;
    String book;
    String phone;
    int mnum;
    int bnum;

    Rental(String date, String name, String book, String phone, int mnum,int bnum){
        this.date = date;
        this.name = name;
        this.book = book;
        this.phone = phone;
        this.mnum = mnum;
        this.bnum = bnum;
    }

    void printAll(){
        System.out.println(date + "/" + name + "/" + book + "/" + phone);
    }
}

public class BookRentalShop{
    Book[] books;
    Member[] members;
    Rental[] rentals;

    final int SIZE = 10;//상수! 이 변수에는 다른 값을 넣을 수 없다! 어차피 똑같은 값을 넣을 거면 효율적으로!
    static int bnum = 0;//생성자가 실행될 때마다 자동으로 0부터 9까지 배열 숫자가 들어가게~
    static int mnum = 0;//우리는 BookRentalShop을 한 개만 만들거라서 굳이 필요는 없지만~
    static int rnum = 0;

    Scanner sc;

    BookRentalShop(){
        books = new Book[SIZE];//배열 변수 공간 확보
        members = new Member[SIZE];
        rentals = new Rental[SIZE];
        sc = new Scanner(System.in);

        selectMenu();
    }

    void selectMenu(){
        while(true){
            System.out.print("메뉴를 선택해 주세요(1.입력 2.책전체출력 3.회원입력 4.회원전체출력 5.책대여 6.대여책전체출력 0.종료): ");
            int menu = sc.nextInt();
            if(menu==0){
                System.out.println("종료합니다.");
                break;
            }else if(menu==1){
                insertBook();
            }else if(menu==2){
                printBookAll();
            }else if(menu==3){
                insertMember();
            }
            else if(menu==4){
                printMemberAll();
            }else if(menu==5){
                rentalBook();
            }else if(menu==6){
                printRentalAll();
            }
        }
    }

    void insertBook(){
        System.out.println("등록할 책 정보를 입력해주세요");
        System.out.print("책 제목을 입력해주세요: ");
        String title = sc.next();
        System.out.print("책 저자를 입력해주세요: ");
        String writer = sc.next();
        System.out.print("책 가격을 입력해주세요: ");
        int price = sc.nextInt();
        System.out.print("책 isbn을 입력해주세요: ");
        int isbn = sc.nextInt();

        books[bnum] = new Book(title, writer, price, isbn);
        books[bnum].printAll();//현재 넣은 값이 제대로 들어갔는지 확인
        bnum++;//자동으로 숫자 증가!
    }

    void printBookAll(){
		/*
		for(int i=0; i<SIZE; i++){//SIZE = 10 배열의 총 길이
			books[i].printAll();			
		}
		//10개만큼 값이 저장돼있지 않아서 에러가 발생한다! <= 이렇게 하려면 초기값을 넣어둬야한다!
		*/
        for(int i=0; i<bnum; i++){//bnum = 현재 저장된 책 개수와 같다!
            System.out.print(i + " ");//현재 책번호
            books[i].printAll();
        }
        //생성된 책 개수만큼만 반복을 돌리니까 에러가 안생김!
    }

    void insertMember(){
        System.out.println("등록할 회원 정보를 입력해주세요");
        System.out.print("회원 이름을 입력해주세요: ");
        String name = sc.next();
        System.out.print("회원 전화번호를 입력해주세요: ");
        String phone = sc.next();
        System.out.print("회원 주소를 입력해주세요: ");
        String addr = sc.next();
        System.out.print("회원 id를 입력해주세요: ");
        String id = sc.next();

        members[mnum] = new Member(name, phone, addr, id);
        members[mnum].printAll();
        mnum++;
    }

    void printMemberAll(){
        for(int i=0; i<mnum; i++){//mnum은 insert할 때마다 1씩 추가됨
            System.out.print(i + " ");//현재 회원번호
            members[i].printAll();
        }
    }

    void printRentalAll(){
        for(int i=0; i<rnum; i++){
            System.out.print(i + " ");//현재 대여번호
            rentals[i].printAll();
        }
    }

    void rentalBook(){
        printBookAll();//책 목록을 먼저 전부 보여준다
        System.out.print("빌리려는 책 번호를 입력해주세요: ");
        int selectB = sc.nextInt();
        System.out.print("빌리는 회원의 번호를 입력해주세요: ");
        int selectM = sc.nextInt();
        System.out.print("빌리는 날짜를 입력해주세요: ");
        String date = sc.next();

        rentals[rnum] = new Rental(date, members[selectM].getName(), books[selectB].getTitle(), members[selectM].getPhone(), selectM, selectB);
        rentals[rnum].printAll();
    }

    public static void main(String[] args){
        new BookRentalShop();
    }
}