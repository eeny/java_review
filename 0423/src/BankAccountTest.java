class BankAccount{
    int balance;//잔액

    void deposit(int amount){//저금
        balance = balance + amount;
        System.out.println(amount + "원 저금");
    }
    void withdraw(int amount){//인출
        if(balance > amount){//잔고가 양수
            balance = balance - amount;
            System.out.println(amount + "원 인출");
        }else{
            System.out.println("잔고가 부족합니다.");
        }
    }
    int getBalance(){//잔고 반환
        return balance;			//한개의 메서드에서 return은 한개만 가능
    }
    int addInterest(int balance){//연 7.5%이자
        double interest;//이자
        interest = balance*0.075;
        balance = balance + (int)interest;
        return balance;//이자가 추가된 잔액
    }
}

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();

        //b의 잔고가 100. b에서 60을 인출. b의 현재 잔고를 얻어서 화면에 출력하기
        b.balance = 100;
        b.withdraw(60);
        System.out.println("현재 잔고는 " + b.getBalance() + "원 입니다.");

        //현재 잔액에 대해 연 7.5%의 이자를 계산하여 추가하는 addInterest() 메서드를 구현하고 테스트
        //현재 잔액 1000원인 경우~
        System.out.println("연 7.5% 이자를 추가한 잔액은 " + b.addInterest(1000) + "원 입니다.");

        //현재 잔고가 음수이면 예금 인출이 일어나지 않도록 withdraw() 메서드 변경하기
        //이러한 BankAccount 클래스를 변경해도 BankAccountTest클래스는 변경하지 않아도 된다!

        //BankAccount 클래스 앞에 public을 붙이면?
        //class BankAccount is public, should be declared in a file named BankAccount.java
        //public은 파일명과 같은 클래스에만 붙일 수 있다! 따라서 파일명을 변경하라는 에러가 뜬다!
    }
}
