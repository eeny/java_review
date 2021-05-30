import java.util.Random;

public class RandomTest {// p491 예제
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }

        // 만약 1 ~ 100 난수를 하고 싶으면?
        // random.nextInt(99) + 1 하면 된다!
    }
}