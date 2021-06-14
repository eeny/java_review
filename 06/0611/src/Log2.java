public class Log2 {// p629 예제
    public static void main(String[] args) {
        int i = 8;
        double r = Math.log(i);

        System.out.format("log(" + "%d" + ")은 " + "%+020.10f" + "입니다.%n", i, r);
        //										%띄어쓰기 . 소수점 이하 자리
    }
}