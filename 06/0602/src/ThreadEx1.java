public class ThreadEx1 extends Thread {

    // 클래스라서 run()이 없어도 에러는 발생하지 않는다! 다만 없으면 실행할 것도 없다.
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        // Thread 사용법
        // Thread는 클래스이며,
        // Runnable이라는 인터페이스도 있다.
        // Thread t = new Thread();
        // t.start(); 이런식으로 사용이 가능하다!

        // Thread는 내부적으로 반드시 구현해줘야 하는 메서드가 있다!
        // 이 메서드 안의 내용이 실행된다! => run()
        // run()은 스스로 실행되지는 않고, 반드시 Thread 클래스를 생성하고,
        // 실행할 클래스에서 start()라는 메서드를 실행시켜서 자동으로 run()을 호출한다!

        ThreadEx1 t1 = new ThreadEx1();
        ThreadEx1 t2 = new ThreadEx1();
        // 자동으로 run()을 호출(실행)해 준다!
        t1.start();
        t2.start();

        // 0 1 2 3 4 5 0 1 2 6 7 8 3 4 5 6 7 8 9 9
        // 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 8 9 8 9
        // 출력 결과가 매번 뒤섞인다.
    }
}