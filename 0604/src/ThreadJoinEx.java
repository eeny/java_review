public class ThreadJoinEx {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " 시작");

        //new Thread(new MyRunnable()).start(); 이거 대신 쓸 크도
        MyRunnable2 r = new MyRunnable2();
        Thread t = new Thread(r);
        t.start();

        // join()이 있느냐 없느냐에 따라 스레드가 아닌 것을 대기시킨다!
        // 조금 여유가 생긴다~
        try {
            t.join();// 스레드가 종료될 때까지 강제로 대기한다!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 끝");
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        System.out.println("스레드 넘버1");
        thread2();
    }

    public void thread2() {
        System.out.println("스레드 넘버2");
        thread3();
    }
    public void thread3() {
        System.out.println("스레드 넘버3");

    }
}