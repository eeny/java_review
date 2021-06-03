import javax.swing.JButton;
import javax.swing.JFrame;

public class WidthBox extends JFrame implements Runnable {
    JButton btn;

    public WidthBox() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 300);
        this.setLayout(null);

        btn = new JButton();
        btn.setBounds(10, 100, 50, 50);

        this.add(btn);

        (new Thread(this)).start();
        // this 자리에는 Runnable을 구현한 객체를 넣으면 된다!

        this.setVisible(true);
    }

    void makeLong(int iw) {
        // int w = btn.getWidth() + iw;
        // 라고 하면 btn.getWidth()에 자꾸 똑같이 Width가 늘어나니까
        // 엄청나게 커진다~~~
        int w = 50 + iw;
        btn.setSize(w, 50);
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            makeLong(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new WidthBox();
    }
}