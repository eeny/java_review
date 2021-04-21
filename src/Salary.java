import java.util.Scanner;

public class Salary {
    //월급, 판매량에 따라서
    //판매량이 10개 이상이면 보너스는 10%
    //판매량이 5개 이상이면 보너스는 5%
    //이하는 보너스가 없다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int salary;//월급
        int salse;//판매량
        int bonus;//보너스
        int money;//총월급

        System.out.print("월급을 입력하세요 : ");
        salary = sc.nextInt();
        System.out.print("판매량을 입력하세요 : ");
        salse = sc.nextInt();

        if(salse >= 10){
            bonus = (int)(salary*0.1);
            money = salary + bonus;
            System.out.println("이번달 월급은 판매량 10을 넘었으므로 기본급 "+ salary
                    + "만원 + 보너스 " + bonus + "만원 = " + money + "만원 입니다.");
        }else if(salse >= 5){
            bonus = (int)(salary*0.05);
            money = salary + bonus;
            System.out.println("이번달 월급은 판매량 5를 넘었으므로 기본급 "+ salary
                    + "만원 + 보너스 " + bonus + "만원 = " + money + "만원 입니다.");
        }else{
            System.out.println("보너스가 없습니다!!! 이번달 월급은 " + salary + "만원 입니다.");
        }
    }
}
