import java.util.Scanner;

class Book{//책
    private String title;
    private String author;
    private int price;
    private String isbn;

    public Book(String title, String author, int price, String isbn){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    void setTitle(String title){this.title = title;}
    void setAuthor(String author){this.author = author;}
    void setPrice(int price){this.price = price;}
    void setIsbn(String isbn){this.isbn = isbn;}

    String getTitle(){return title;}
    String getAuthor(){return author;}
    int getPrice(){return price;}
    String getIsbn(){return isbn;}
}

class User{//회원
    private String id;
    private String name;
    private String tel;
    private String addr;

    public User(String id, String name, String tel, String addr){
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

    void setId(String id){this.id = id;}
    void setName(String name){this.name = name;}
    void setTel(String tel){this.tel = tel;}
    void setAddr(String addr){this.addr = addr;}

    String getId(){return id;}
    String getName(){return name;}
    String getTel(){return tel;}
    String getAddr(){return addr;}
}

class RentBook{//빌린책
    private String rTitle;
    private String rName;
    private String rTel;
    private String rDate;

    public RentBook(String rTitle, String rName, String rTel, String rDate){
        this.rTitle = rTitle;
        this.rName = rName;
        this.rTel = rTel;
        this.rDate = rDate;
    }

    void setRTitle(String rTitle){this.rTitle = rTitle;}
    void setRName(String rName){this.rName = rName;}
    void setRTel(String rTel){this.rTel = rTel;}
    void setRDate(String rDate){this.rDate = rDate;}

    String getRTitle(){return rTitle;}
    String getRName(){return rName;}
    String getRTel(){return rTel;}
    String getRDate(){return rDate;}
}

public class RentalManager{
    Book[] b;
    User[] u;
    RentBook[] r;
    Scanner sc;

    public RentalManager(){
        b = new Book[10];//책 10권
        u = new User[10];//회원 10명
        r = new RentBook[10];//빌린책 10권
        sc = new Scanner(System.in);

        resetData();
        login();
    }

    void resetData(){
        for(int i=0; i<b.length; i++){
            b[i] = new Book("", "", 0, "");
            u[i] = new User("", "", "", "");
            r[i] = new RentBook("", "", "", "");
        }
    }

    void insertBook(int idx){
        System.out.print("ISBN: ");
        String isbn = sc.next();
        sc.nextLine();//sc.nextLine(); 오류 때문에 추가, 순서도 변경
        System.out.print("도서제목: ");
        String title = sc.nextLine();
        System.out.print("도서저자: ");
        String author = sc.next();
        System.out.print("도서가격: ");
        int price = sc.nextInt();

        b[idx].setTitle(title);
        b[idx].setAuthor(author);
        b[idx].setPrice(price);
        b[idx].setIsbn(isbn);
        System.out.println("\n도서정보가 등록되었습니다!\n");
    }

    void selectBook(int idx){
        System.out.println("도서제목: " + b[idx].getTitle());
        System.out.println("도서저자: " + b[idx].getAuthor());
        System.out.println("도서가격: " + b[idx].getPrice() + "원");
        System.out.println("ISBN: " + b[idx].getIsbn());
    }

    void deleteBook(int idx){
        b[idx].setTitle("");
        b[idx].setAuthor("");
        b[idx].setPrice(0);
        b[idx].setIsbn("");
        System.out.println("\n도서정보가 삭제되었습니다!\n");
    }

    void insertUser(int idx){
        System.out.print("회원ID: ");
        String id = sc.next();
        System.out.print("회원이름: ");
        String name = sc.next();
        System.out.print("연락처: ");
        String tel = sc.next();
        sc.nextLine();//주소 입력시 nextLine() 때문에 에러때문에 추가!
        System.out.print("주소: ");
        String addr = sc.nextLine();

        u[idx].setId(id);
        u[idx].setName(name);
        u[idx].setTel(tel);
        u[idx].setAddr(addr);
        System.out.println("\n회원정보가 등록되었습니다!\n");
    }
    void selectUser(int idx){
        System.out.println("ID: " + u[idx].getId());
        System.out.println("회원이름: " + u[idx].getName());
        System.out.println("연락처: " + u[idx].getTel());
        System.out.println("주소: " + u[idx].getAddr());
    }
    void deleteUser(int idx){
        u[idx].setId("");
        u[idx].setName("");
        u[idx].setTel("");
        u[idx].setAddr("");
        System.out.println("\n회원정보가 삭제되었습니다!\n");
    }

    void insertRentBook(int idx){
        System.out.print("대여자명: ");
        String rName = sc.next();
        System.out.print("대여자 연락처: ");
        String rTel = sc.next();
        sc.nextLine();
        System.out.print("대여도서명: ");
        String rTitle = sc.nextLine();
        System.out.print("대여일자: ");
        String rDate = sc.next();

        r[idx].setRTitle(rTitle);
        r[idx].setRName(rName);
        r[idx].setRTel(rTel);
        r[idx].setRDate(rDate);
        System.out.println("\n대여정보가 등록되었습니다!\n");
    }

    void selectRentBook(int idx){
        System.out.println("대여도서명: " + r[idx].getRTitle());
        System.out.println("대여자명: " + r[idx].getRName());
        System.out.println("대여자 연락처: " + r[idx].getRTel());
        System.out.println("대여일자: " + r[idx].getRDate());
    }

    void deleteRentBook(int idx){
        r[idx].setRTitle("");
        r[idx].setRName("");
        r[idx].setRTel("");
        r[idx].setRDate("");
        System.out.println("\n대여정보가 삭제되었습니다!\n");
    }

    void startManager1(){//모든 메뉴 메뉴 가능

        while(true){
            System.out.println("===관리자 메뉴 선택===");
            System.out.print("(1)도서등록 (2)도서정보조회 (3)도서삭제 (4)회원등록 (5)회원정보조회 (6)회원삭제 (7)도서대여 (8)대여정보조회 (9)대여정보삭제 (0)처음으로(로그아웃) : ");
            int menu = sc.nextInt();

            if(menu==1){//(1)도서등록
                System.out.print("새로 등록할 도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                insertBook(idx);

            }else if(menu==2){//(2)도서정보
                System.out.print("정보를 확인할 도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                selectBook(idx);

            }else if(menu==3){//(3)도서삭제
                System.out.print("삭제할 도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                deleteBook(idx);

            }else if(menu==4){//(4)회원등록
                System.out.print("새로 등록할 회원 번호를 입력하세요: ");
                int idx = sc.nextInt();
                insertUser(idx);

            }else if(menu==5){//(5)회원정보
                System.out.print("정보를 확인할 회원 번호를 입력하세요: ");
                int idx = sc.nextInt();
                selectUser(idx);

            }else if(menu==6){//(6)회원삭제
                System.out.print("삭제할 회원 번호를 입력하세요: ");
                int idx = sc.nextInt();
                deleteUser(idx);

            }else if(menu==7){//(7)도서대여
                System.out.print("대여할 도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                insertRentBook(idx);

            }else if(menu==8){//(8)대여정보등록
                System.out.print("정보를 확인할 대여 도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                selectRentBook(idx);

            }else if(menu==9){//(9)대여정보삭제
                System.out.print("삭제할 대여 도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                deleteRentBook(idx);

            }else if(menu==0){//(0)처음으로
                System.out.println("\n===로그인창으로 돌아갑니다===\n");
                break;

            } else if(menu!=0&&menu!=1&&menu!=2&&menu!=3&&menu!=4&&menu!=5&&menu!=6&&menu!=7&&menu!=8&&menu!=9){
                System.out.println("\n잘못된 번호 입력! 다시 선택해주세요.\n");
                continue;
            }
        }//while끝
    }//startManager1끝

    void startManager2(){//조회 기능만 가능

        while(true){
            System.out.println("===읽기전용 메뉴 선택===");
            System.out.print("(1)도서정보조회 (2)회원정보조회 (3)대여정보조회 (0)처음으로 : ");
            int menu = sc.nextInt();

            if(menu==1){//(1)도서정보
                System.out.print("정보를 확인할 도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                selectBook(idx);

            }else if(menu==2){//(2)회원정보
                System.out.print("정보를 확인할 회원 번호를 입력하세요: ");
                int idx = sc.nextInt();
                selectUser(idx);

            }else if(menu==3){//(3)대여정보조회
                System.out.print("정보를 확인할 대여도서 번호를 입력하세요: ");
                int idx = sc.nextInt();
                selectRentBook(idx);

            }else if(menu==0){//(0)처음으로
                System.out.println("\n===로그인창으로 돌아갑니다===\n");
                break;

            } else if(menu!=1&&menu!=2&&menu!=0){
                System.out.println("\n잘못된 번호 입력! 다시 선택해주세요.\n");
                continue;
            }
        }//while끝
    }//startManager2끝

    void login(){//로그인 방법 선택
        while(true){
            System.out.println("===도서 관리 프로그램===");
            System.out.println("===로그인 (1)관리자 (2)읽기전용 (0)종료===");
            int logNum = sc.nextInt();

            if(logNum==1){//관리자 로그인
                System.out.print("관리자 ID: ");
                String mId = sc.next();

                if(mId.equals("admin")){
                    System.out.print("비밀번호: ");
                    int mPwd = sc.nextInt();

                    if(mPwd==1234){
                        System.out.println("\n===로그인 성공===\n");
                        startManager1();
                    }else{
                        System.out.println("\n비밀번호를 잘못입력했습니다!\n");
                        System.out.println("재로그인 하시겠습니까? (1)예 (0)읽기전용");
                        int x = sc.nextInt();
                        if(x==1){
                            continue;
                        }else{
                            System.out.println("\n===읽기전용 접속===\n");
                            startManager2();
                        }
                    }
                }else{
                    System.out.println("\n아이디를 잘못입력했습니다!\n");
                    continue;
                }
            }else if(logNum==2){//읽기전용
                System.out.println("\n===읽기전용 접속===\n");
                startManager2();
            }else{//1, 2 제외한 숫자
                System.out.println("===프로그램 종료===");
                break;
            }
        }//while끝
    }//login끝

    public static void main(String[] args){
        new RentalManager();
    }//main끝
}