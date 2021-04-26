import java.util.Scanner;

public class VendingMachine2 {
    //자판기 변수
    int coke = 1;
    int milk = 2;
    int water = 3;
    int money;//넣는 돈
    int drink;//고른 음료수
    int changes;//잔돈

    int pay(){//돈 넣는 기능
        System.out.println("돈을 넣으세요");
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        return money;
    }

    int choice(){//음료 고르는 기능
        System.out.println("음료를 고르세요 1.콜라(500원) 2.우유(700원) 3.물(300원)");
        Scanner sc = new Scanner(System.in);
        drink = sc.nextInt();
        return drink;
    }

    void printDrink(){//선택한 음료 출력하는 기능
        if(drink == 1){
            System.out.println("콜라를 선택했습니다.");
        }else if(drink == 2){
            System.out.println("우유를 선택했습니다.");
        }else if(drink == 3) {
            System.out.println("물을 선택했습니다.");
        }else{
            System.out.println("없는 음료입니다.");
        }
    }

    int countMoney(){//음료 계산하는 기능
        if(drink == 1){
            coke = 500;
            if(money>=coke){
                changes = money-coke;
            }else{
                changes = -1;//기본값이 0이니까 다른값으로 초기화
            }
        }else if(drink == 2){
            milk = 700;
            if(money>=milk){
                changes = money-milk;
            }else{
                changes = -1;
            }
        }else if(drink == 3){
            water = 300;
            if(money>=water){
                changes = money-water;
            }else{
                changes = -1;
            }
        }else{
            changes = -2;//없는 음료의 경우 또다른 값으로 초기화
        }
        return changes;
    }

    void printChanges(){//잔돈 출력하는 기능
        money = pay();
        drink = choice();
        printDrink();
        changes = countMoney();

        if(changes >= 0){
            System.out.println("잔돈은 " + changes + "원입니다.");
        }else if(changes == -1){
            System.out.println("돈이 부족합니다!");
        }else{//없는 음료 선택의 경우 재선택하기
            System.out.println("음료를 다시 고르세요");

            drink = choice();
            printDrink();
            changes = countMoney();

            if(changes >= 0){
                System.out.println("잔돈은 " + changes + "원입니다.");
            }else if(changes == -1){
                System.out.println("돈이 부족합니다!");
            }
        }
    }

    public static void main(String[] args) {
        VendingMachine2 vm = new VendingMachine2();
        vm.printChanges();
    }
}
