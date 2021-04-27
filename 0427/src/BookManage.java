import java.util.Scanner;

public class BookManage {
    String book;//책제목

    void start(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("===Book Manage===");
            System.out.println("1.책입력 2.책목록 3.종료");
            int menu = sc.nextInt();
            if(menu==1){
                addBook();
                continue;
            }else if(menu==2){
                bookList();
                continue;
            }else{
                System.out.println("종료");
                break;
            }
        }
    }

    void addBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("책 제목 입력: ");
        book = sc.nextLine();
    }

    void bookList(){
        System.out.println("책목록: " + book);
    }

    public static void main(String[] args){
        BookManage bm = new BookManage();
        bm.start();
    }

    //선생님 답안
	/*
	String book1,book2,book3;

	void insertBook(){
		Scanner sc = new Scanner(System.in);
		System.out.println("책 제목 입력 : ");
		book1 = sc.next();//안에 띄어쓰기가 있으면 nextLine()를 써야 합니다.
		System.out.println("책 제목 입력 : ");
		book2 = sc.next();//안에 띄어쓰기가 있으면 nextLine()를 써야 합니다.
		System.out.println("책 제목 입력 : ");
		book3 = sc.next();//안에 띄어쓰기가 있으면 nextLine()를 써야 합니다.
	}
	void listBook(){
		System.out.println(book1+" "+book2+" "+book3);
	}

   void startManager(){
		System.out.println("==책 관리자==");
		Scanner sc = new Scanner(System.in);
		for(;;){//while(true)랑 같음.
			System.out.println("1.책입력 2.책목록 3.종료");
			int input = sc.nextInt();
			if(input==1){
			   insertBook();
			}else if(input==2){
			   listBook();
			}else if(input==3){
			   break;
			}else{
			   System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public static void main(String args[]){
		BookManager bm = new BookManager();
		bm.startManager();
	}
	*/
}
