public class Date3 {
    //생성자 만들기 문제
    int year, month, day;

    Date3(){
        this.year = 2020;
        this.month = 10;
        this.day = 20;
        //this(2020, 10, 20);//이렇게 한 줄로 줄일 수 있다!
    }
    Date3(int year){
        this.year = year;
    }

    Date3(int year, int month){
        this.year = year;
        this.month = month;
    }

    Date3(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    void printDate(){
        System.out.println(year + "." + month + "." + day);
    }
    public static void main(String[] args) {
        Date3 d1 = new Date3();
        d1.printDate();
        Date3 d2 = new Date3(2021);
        d2.printDate();
        Date3 d3 = new Date3(2021, 4);
        d3.printDate();
        Date3 d4 = new Date3(2021, 4, 28);
        d4.printDate();
    }
}
