import java.util.Scanner;

public class PartTimeJob {
    //알바비 계산기
    //일한 날짜, 하루당 일한 시간, 시급에 따라서 주휴수당 포함한 알바비를 계산하기

    //주휴수당 = 시급 * 8시간 * (1주간 실제로 일한 시간 / 40시간)
    //주휴수당은 1주일 만근(주5일 하루 8시간씩) 근로자에게 추가로 1일분의 임금을 준다.
    //단, 주휴수당은 근로시간이 주15시간 미만이면 받을 수 없다.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int week;//일주일 동안 일하는 날짜
        int time;//하루에 일하는 시간.
        int month;//한달 동안 총 일한 날짜
        int wage;//시급

        int bonus;//주휴수당
        int salary;//총 알바비

        System.out.print("일주일 동안 며칠 일합니까? ");
        week = sc.nextInt();
        System.out.print("하루에 몇 시간 일합니까? ");
        time = sc.nextInt();
        System.out.print("이번달 동안 며칠 일했습니까? ");
        month = sc.nextInt();
        System.out.print("시급이 얼마입니까? ");
        wage = sc.nextInt();

        if((week*time) >= 15){//주15시간 이상 일하는 경우 = 주휴수당 받는 경우
            //bonus = (double)wage * 8.0 * ((double)week * (double)time / 40.0);
            //내가 생각한 답은 괄호가 있어서 형변환을 해야한다
            //bonus = (((time * week)*8)/40)*wage; //은주가 알려준 답(다 곱하고 나누기를 나중에 하는 방법)
            bonus = wage * 8 * week * time / 40; //정현이가 알려준 답(괄호를 빼도 되는 연산이라서)

            salary = (month * time * wage) + bonus;

            System.out.println("주휴수당은 " + bonus + "원 이고, 이번달 알바비는 " + salary + "원입니다.");

        }else{//주휴수당 못 받는 경우
            bonus = 0;

            salary = month * time * wage;

            System.out.println("주15시간 미만 근무, 주휴수당은 " + bonus + "원 이고, 이번달 알바비는 " + salary + "원입니다.");
        }
    }
}
