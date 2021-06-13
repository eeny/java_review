public class Buffer {// 602 예제
    private int data;
    private boolean empty = true;

    public synchronized int get() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        empty = true;
        notifyAll();
        return data;
    }

    public synchronized void put(int data) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.data = data;
        notifyAll();
    }
}