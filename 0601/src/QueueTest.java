import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {// p561 예제
    public static void main(String[] args) throws InterruptedException {
        int time = 10;

        // Integer를 저장하는 큐를 생성
        // 실제로는 LinkedList 안에 Queue 인터페이스가 구현되어 있다!
        Queue<Integer> queue = new LinkedList<>();
        // 왜 앞에서는 Queue라고 하고 new해서  LinkedList에 담아 쓰는지?
        // Queue에 담으면 Queue의 메서드만 쓸 수 있기 때문에!

        for (int i = time; i >= 0; i--) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {// queue에 값이 들어있다면~
            System.out.print(queue.remove() + " ");
            Thread.sleep(1000);// 현재 스레드를 1초간 재운다.
        }
    }
}