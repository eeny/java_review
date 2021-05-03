public class Calc {//4칙 연산 계산기 만들기
    int x, y, result;

    void plus(int x, int y){
        result = x + y;
        System.out.println(x + "+" + y + "=" + result);
    }
    void minus(int x, int y){
        result = x - y;
        System.out.println(x + "-" + y + "=" + result);
    }
    void mult(int x, int y){
        result = x * y;
        System.out.println(x + "*" + y + "=" + result);
    }
    void divide(int x, int y){
        result = x / y;
        System.out.println(x + "/" + y + "=" + result);
    }

    public static void main(String[] args) {
        Calc c = new Calc();
        c.plus(10,5);// 15
        c.minus(10,5);// 5
        c.mult(10,5);// 50
        c.divide(10,5);// 2
    }
}
