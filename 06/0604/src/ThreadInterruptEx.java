public class ThreadInterruptEx {
    // 인터럽트란 스레드를 강제 종료시키는 메서드다!
    // 인터럽트를 실행하면 try-catch가 발생하며
    // 프로그램이 멈추기는 한다!
    // 하지만 원래 사용되던 내용들이 제대로 close가 되지않으므로
    // 사용을 추천하지는 않는다!

    // 예외를 발생시켜 스레드를 정지하는 방법 1
    public static void main(String[] args) {
        TestThread2 t = new TestThread2();
        t.start();

        try {
            Thread.sleep(500);// 0.5초 후에
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();// 스레드 실행 중지해라!
        // 인터럽트는 실제적으로는 정지되지 않는다!
        // 인터럽트로 실제 정지를 시키고 싶으면
        // 만들어진 Thread가 정지되고 난 후에 실제 프로그램을 정지시킨다.

        // 인터럽트는 이미 프로그램이 정지된 상태(sleep처럼 일시정지 상태도 포함)에서만
        // 스레드를 완전히 종료시킨다!
        // 따라서 상황에 따라 실행되다가 예외를 발생시킨다! <= 쓰면 안되는 방법이다!
    }
}

class TestThread2 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("실행중...");
                Thread.sleep(1000);
                // 스레드를 정지하는 방법2
				/*interrupt();// 스레드 실행 중지해라!
				System.out.println("되나?");*/
            }
        } catch (InterruptedException e) {
            System.out.println("예외 발생! 스레드 실행 종료!");
        }

    }
}
