import java.util.*;

class BankAccount{//p188 UML 예제2 수정
    int accountNumber;//계좌번호
    String owner;//예금주
    int balance;//잔액

    void start(){
        System.out.println("=== ATM ===");
        System.out.println("1.입금 2.출금 3.잔고확인 4.종료");

        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();

        int amount;//입출금 금액

        switch(menu){
            case 1:
                System.out.println("입금할 금액을 입력하세요: ");
                amount = sc.nextInt();
                deposit(amount);
                break;
            case 2:
                System.out.println("출금할 금액을 입력하세요: ");
                amount = sc.nextInt();
                withdraw(amount);
                break;
            case 3:
                System.out.println(toString());
                break;
            case 4:
                System.out.println("종료합니다");
                break;
            default: System.out.println("종료합니다");
        }
    }

    void deposit(int amount){//입금
        balance += amount;
        System.out.println(toString());
    }
    void withdraw(int amount){//출금
        balance -= amount;
        System.out.println(toString());
    }
    //p195 예제 6번 문제 추가~~
    //현재 객체의 잔액에서 amount만큼을 otherAccount계좌로 송금하는 메서드
    int transfer(int amount, BankAccount otherAccount){
        balance -= amount;
        otherAccount.deposit(amount);
        return otherAccount.balance;
    }

    public String toString(){
        return "현재 잔고는 " + balance + "입니다.";
    }

    //선생님 답안
	/*
	int balance;

	void deposit(int amount){
		balance+=amount;
		printBalance();
	}
	void withdraw(int amount){
		balance-=amount;
		printBalance();
	}
	void printBalance(){
		System.out.println("잔고는 "+balance+"입니다.");
	}
	void startAtm(){
		Scanner sc = new Scanner(System.in);
		System.out.println("===ATM===");

		while(true){
        System.out.println("1.입금 2.출금 3.잔고확인 4.종료");
        int input = sc.nextInt();
        int money = 0;
        if(input==1){
			System.out.print("입금할 금액을 입력하세요");
            money = sc.nextInt();
            deposit(돈);
        }else if(input==2){
            System.out.print("출금할 금액을 입력하세요");
            money = sc.nextInt();
            withdraw(돈);
        }else if(input==3){
            printBalance();
        }else if(input==4){
            System.out.println("종료합니다.");
            break;
        }else{
			System.out.println("잘못된 입력입니다.");
        }
      }
	*/
}

public class BankAccountTest2 {
    public static void main(String[] args){
        BankAccount b = new BankAccount();
        b.start();

        BankAccount otherAccount = new BankAccount();
        System.out.println("otherAccount의 잔액은 " + b.transfer(5000, otherAccount));

        //선생님 답안
		/*
		BankAccount ba = new BankAccount();
		ba.startAtm();
		*/
    }
}
