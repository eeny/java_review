public class ActiveCnt extends Thread {
    int num;

    public static void main(String[] args) {

        // 스레드 실행하는 방법1
        ActiveCnt ac = new ActiveCnt();
        ac.num = 1;
        ac.start();

        // 스레드 실행하는 방법2
        //new ActiveCnt().start();

        ActiveCnt ac2 = new ActiveCnt();
        ac2.num = 2;
        ac2.start();

        System.out.println(ac.activeCount()+ "카운트");// 3카운트
        // 왜 스레드가 3개라고 뜨는가?
        // 위에 실행 2개 했고 , activeCount()는 static 스레드 메소드라서 이것도 포함됨!

        System.out.println(ac.getPriority() + "우선순위");
        System.out.println(ac2.getPriority() + "우선순위");
        ac.setPriority(Thread.MAX_PRIORITY);
        // 첫번째 ActiveCnt에 생성된 객체에 우선순위를 줬으므로 좀 더 자주 먼저 실행될 것이다...
        // 근데 큰 차이 없어 보인다...
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(num + ":" + (char)(i+65));// i는 처음에 0, 영어로 A는 65
        }
    }
}