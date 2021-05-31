import java.util.Random;

public class Test2 {// p485 예제 포함
    void printClassName(Object obj) {
        System.out.println("The class of " + obj + " is " + obj.getClass().getName());
    }

    public static void main(String[] args) {
        System.out.println(MyRandom.hiRandom(2, 10));

        // Class class1 = null;
        // 이클립스에서 노란줄? 만들어졌지만 사용을 하고 있지 않다는 뜻
        // 또는 특정 타입을 정의하지 않았다(Object로 되어있다!)는 뜻

        Test2 t = new Test2();
        t.printClassName(t);
        // The class of Test@6d06d69c is Test
        Random r = new Random();
        t.printClassName(r);
        // The class of java.util.Random@7852e922 is java.util.Random

        System.out.println(System.currentTimeMillis());
        // 1970-01-01 12시를 기준으로 현재까지의 시간을 초로 바꾼 값
        System.out.println(System.nanoTime());
        // 더 디테일한 메서드인데 잘 안 씀

        // 예시 - for문 돌리는 동안 걸리는 시간 몇 초인지 구하기(이럴 때 사용한다~)
        System.out.println(System.currentTimeMillis());
        long ll = 0l;// 뒤에 l을 붙여야 한다!
        for (int i = 0; i < 1000000000; i++) {
            ll = ll + i;
        }
        System.out.println(ll);
        System.out.println(System.currentTimeMillis());

        String s = "안녕하세요";// String은 기초변수 처럼 사용가능
        // StringBuffer sb = "안녕하세요";// 이렇게 못 쓴다!
        // StringBuffer는 내부적으로는 조금 더 효율적이기는 하지만
        // new로 생성해서 값을 넣어야 해서 불편하다.
        StringBuffer sb = new StringBuffer();
        sb.append("안녕하세요");// 이렇게 써야한다...
    }
}