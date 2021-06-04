public class ThreadControl {// p591 예제
    // 메시지를 스레드 이름과 함께 출력하는 메서드
    static void print(String message) {
        // Thread.currentThread().getName() 로
        // 스레드 이름을 알 수 있다!
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String message[] = {
                    "Pride will have a fall.",
                    "Power is dangerous unless you have humility.",
                    "Office changes manners.",
                    "Emplty vessels make the most sound."
            };

            try {
                for (int i = 0; i < message.length; i++) {
                    print(message[i]);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                // 스레드가 인터럽트되면 메시지를 출력하는 부분
                print("아직 안 끝났어요!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int tries = 0;

        print("추가적인 스레드를 시작합니다.");
        // Thread-0
        Thread t = new Thread(new MessageLoop());
        t.start();
        // Thread-1 (이것까지 스레드 총 3개)
        Thread t2 = new Thread(new MessageLoop());
        t2.start();

        print("추가적인 스레드가 끝나기를 기다립니다.");

        while (t.isAlive()) {
            print("아직 기다립니다.");
            t.join(1000);// 스레드 t가 종료할 때까지 1초 동안 기다린다.
            tries++;

            if (tries > 2) {
                print("참을 수가 없네요!");
                t.interrupt();// 스레드 t를 강제로 중단시킨다!
                t.join();// 스레드 t가 종료하기를 기다린다.
            }
        }
        print("메인 스레드 종료!");
    }
}