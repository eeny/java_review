class MyRunnable implements Runnable {
    String myName;

    public MyRunnable(String name) {
        myName = name;
    }

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.print(myName + i + " ");
        }
    }
}

public class TestThread {// p585 예제
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable("A"));
        Thread t2 = new Thread(new MyRunnable("B"));
        t1.start();
        t2.start();

        // A10 B10 A9 B9 A8 A7 B8 A6 A5 B7 B6 B5 A4 A3 B4 B3 B2 B1 B0 A2 A1 A0
        // B10 A10 B9 B8 B7 B6 A9 B5 A8 B4 B3 B2 B1 B0 A7 A6 A5 A4 A3 A2 A1 A0
        // 실행할 때마다 출력 결과가 뒤섞여서 나온다.
    }
}