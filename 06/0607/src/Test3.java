class Job implements Runnable {
//	String name;
//	
//	public Job(String name) {
//		this.name = name;
//	}

    @Override
    public void run() {
//		byte n = 0;
//		while (true) {
//			System.out.println(name + " : " + n++);
//		}

        try {
            System.out.println("A");
            Thread.sleep(1000);
            System.out.println("B");
        } catch (InterruptedException e) {
            System.out.println("C");
        }
        System.out.println("D");
    }
}

public class Test3 {// p609 Exercise 4번문제
//	@Override
//	public void run() {
//		byte n = 0;
//		while (true) {
//			System.out.println("" + n++);
//		}
//	}

    public static void main(String[] args) {
//		Thread t = new Thread(new Job());
//		t.start();

//		Thread t = new Test();
//		t.start();

//		Thread t1 = new Thread(new Job("스레드1"));
//		t1.start();
//		Thread t2 = new Thread(new Job("스레드2"));
//		t2.start();
//		Thread t3 = new Thread(new Job("스레드3"));
//		t3.start();

        Thread t = new Thread(new Job());
        t.start();
        t.interrupt();
    }
}