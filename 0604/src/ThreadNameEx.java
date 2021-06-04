public class ThreadNameEx {
    public static void main(String[] args) {
        System.out.println("시작");
        new Thread(new ThreadTesk()).start();
        new Thread(new ThreadTesk()).start();
        // 생성자에서도 스레드 이름을 설정할 수 있다!
        new Thread(new ThreadTesk(), "이름").start();
        System.out.println("끝");
    }
}

class ThreadTesk implements Runnable {
    static int cnt = 0;
    int id;

    public ThreadTesk() {
        id = cnt++;
    }

    @Override
    public void run() {
        // 내가 실행할 스레드 이름 설정하기 방법1
        //Thread.currentThread().setName("스레드작업");

        // 현재 실행중인 스레드 이름 가져오기
        String name = Thread.currentThread().getName();

        // 스레드 출력하기
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ", " + id + " " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}