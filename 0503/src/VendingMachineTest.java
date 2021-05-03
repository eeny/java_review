import java.util.Scanner;

class VendingMachine{//자판기 만들어야함...
    private int money;
    private int change;

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }

    void start(){ }

    void insertMoney(){
        System.out.println("돈을 넣어주세요");
    }

    void selectDrink(){
        System.out.println("음료수를 골라주세요");
    }

    String receiveChange(){
        return "거스름돈은 " + change + "원 입니다.";
    }
}

class CupVM extends VendingMachine{
    Scanner sc;

    CupVM(){
        start();
    }

    @Override
    void start(){
        System.out.println("===종이컵 자판기===");
        insertMoney();
        selectDrink();
        System.out.println(receiveChange());
    }

    @Override
    void insertMoney(){
        sc = new Scanner(System.in);
        System.out.println("돈을 넣어주세요");
        int coin = sc.nextInt();
        super.setMoney(coin);
    }

    @Override
    void selectDrink(){
        if(super.getMoney() < 300) {
            System.out.println("돈이 부족합니다");
            super.setChange(super.getMoney());

        }else if (super.getMoney() >= 300 && super.getMoney() < 400) {
            System.out.println("1.커피(300원)");
            System.out.println("음료수를 골라주세요");
            int menu = sc.nextInt();

            if (menu==1) {
                System.out.println("커피를 고르셨습니다.");
                super.setChange(super.getMoney() - 300);
            }

        }else if (super.getMoney() >= 400 && super.getMoney() < 500) {
            System.out.println("1.커피(300원) 2.율무차(400원)");
            System.out.println("음료수를 골라주세요");
            int menu = sc.nextInt();

            if (menu==1) {
                System.out.println("커피를 고르셨습니다.");
                super.setChange(super.getMoney() - 300);
            } else if (menu==2) {
                System.out.println("율무차를 고르셨습니다.");
                super.setChange(super.getMoney() - 400);
            }

        }else if (super.getMoney() >= 500) {
            System.out.println("1.커피(300원) 2.율무차(400원) 3.핫초코(500원)");
            System.out.println("음료수를 골라주세요");
            int menu = sc.nextInt();

            if (menu==1) {
                System.out.println("커피를 고르셨습니다.");
                super.setChange(super.getMoney() - 300);
            } else if (menu==2) {
                System.out.println("율무차를 고르셨습니다.");
                super.setChange(super.getMoney() - 400);
            } else if (menu==3) {
                System.out.println("핫초코를 고르셨습니다.");
                super.setChange(super.getMoney() - 500);
            }
        }
    }

    @Override
    String receiveChange(){
        return "거스름돈은 " + super.getChange() + "원 입니다.";
    }
}

class CanVM extends VendingMachine{
    Scanner sc;

    CanVM(){
        start();
    }

    @Override
    void start(){
        System.out.println("===캔음료 자판기===");
        insertMoney();
        selectDrink();
        System.out.println(receiveChange());
    }

    @Override
    void insertMoney(){
        sc = new Scanner(System.in);
        System.out.println("돈을 넣어주세요");
        int coin = sc.nextInt();
        super.setMoney(coin);
    }

    @Override
    void selectDrink(){
        if(super.getMoney() < 700) {
            System.out.println("돈이 부족합니다");
            super.setChange(super.getMoney());

        }else if (super.getMoney() >= 700  && super.getMoney() < 800) {
            System.out.println("1.콜라(700원)");
            System.out.println("음료수를 골라주세요");
            int menu = sc.nextInt();

            if (menu==1) {
                System.out.println("콜라를 고르셨습니다.");
                super.setChange(super.getMoney() - 700);
            }

        }else if (super.getMoney() >= 800 && super.getMoney() < 900) {
            System.out.println("1.콜라(700원) 2.사이다(800원)");
            System.out.println("음료수를 골라주세요");
            int menu = sc.nextInt();

            if (menu==1) {
                System.out.println("콜라를 고르셨습니다.");
                super.setChange(super.getMoney() - 700);
            } else if (menu==2) {
                System.out.println("사이다를 고르셨습니다.");
                super.setChange(super.getMoney() - 800);
            }

        }else if (super.getMoney() >= 900) {
            System.out.println("1.콜라(700원) 2.사이다(800원) 3.환타(900원)");
            System.out.println("음료수를 골라주세요");
            int menu = sc.nextInt();

            if (menu==1) {
                System.out.println("콜라를 고르셨습니다.");
                super.setChange(super.getMoney() - 700);
            } else if (menu==2) {
                System.out.println("사이다를 고르셨습니다.");
                super.setChange(super.getMoney() - 800);
            } else if (menu==3) {
                System.out.println("환타를 고르셨습니다.");
                super.setChange(super.getMoney() - 900);
            }
        }
    }

    @Override
    String receiveChange(){
        return "거스름돈은 " + super.getChange() + "원 입니다.";
    }
}

public class VendingMachineTest{
    public static void main(String[] args){
        //new CupVM();
        new CanVM();
    }
}