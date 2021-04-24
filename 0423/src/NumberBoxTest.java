class NumberBox{
    int ivalue;
    float fvalue;
}

public class NumberBoxTest {
    public static void main(String[] args) {
        NumberBox box = new NumberBox();
        box.ivalue = 10;
        box.fvalue = 1.2345f;//뒤에 f를 붙여야한다!!!
        System.out.println("ivalue는 " + box.ivalue + " fvalue는 " + box.fvalue);
    }
}
