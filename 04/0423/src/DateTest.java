class Date{
    int year, month, day;//연도, 월, 일
    void print1(int year, int month, int day){//2012.7.12
        System.out.println(year + "." + month + "." + day);
    }
    void print2(int year, int month, int day){//July 12, 2012
        String str="";//초기화
        switch(month){
            case 1: str="January";
                break;
            case 2: str="February ";
                break;
            case 3: str="March ";
                break;
            case 4: str="April ";
                break;
            case 5: str="May ";
                break;
            case 6: str="June ";
                break;
            case 7: str="July ";
                break;
            case 8: str="August ";
                break;
            case 9: str="September ";
                break;
            case 10: str="October ";
                break;
            case 11: str="November ";
                break;
            case 12: str="December";
                break;
            default: System.out.println("잘못된 날짜를 입력했습니다.");
                break;
        }
        System.out.println(str + day + ", " + year);
    }
}

public class DateTest {
    public static void main(String[] args) {
        Date d = new Date();
        d.print1(2012, 7, 12);
        d.print2(2012, 7, 12);
    }
}
